package abs.pubs.led;

public class FontSetImportDemo {
    
    private static MyUdpSocket my_udp;
    
    private static void socketOpen(int port) {  
        try {    
            my_udp = new MyUdpSocket(port);
        } catch (Exception ex) {    
            ex.printStackTrace();    
        }
    }
    
    private static void socketClose(){
        try {    
        	my_udp.close();
        } catch (Exception ex) {    
            ex.printStackTrace();    
        }
    }

    public FontSetImportDemo(int port) {  
    	socketOpen(port);
    }
    
    private static String winno2ip(int winno){
    	return "192.168.20.99";
    }
    
    private static int winno2index(int winno){
    	return winno - 1;
    }

    public static void sendWindowText(int winno, String text){
    	byte[] packet = new byte[1024];
    	byte[] s; 
    	int i, k, size;
    	int c;
    	String ip;
    	int no;
    	Boolean ok;
    	
		ip=winno2ip(winno);
		no=winno2index(winno);
    	size=0;
		try {
	    	s=text.getBytes("GB2312");
	    	size=0;
			packet[size++]=0x55;
	    	packet[size++]=0x25;
	    	packet[size++]=0x3E;
	    	packet[size++]=(byte)(((no/100)%10)+0x30);
	    	packet[size++]=(byte)(((no/10)%10)+0x30);
	    	packet[size++]=(byte)((no%10)+0x30);
			for (i=0; i<s.length; i++){
				if (s[i]>=0) c=s[i]; else c=(256+s[i]);
				switch(c>>4){
				case 0: packet[size++]=0x30; break;
				case 1: packet[size++]=0x31; break;
				case 2: packet[size++]=0x32; break;
				case 3: packet[size++]=0x33; break;
				case 4: packet[size++]=0x34; break;
				case 5: packet[size++]=0x35; break;
				case 6: packet[size++]=0x36; break;
				case 7: packet[size++]=0x37; break;
				case 8: packet[size++]=0x38; break;
				case 9: packet[size++]=0x39; break;
				case 10: packet[size++]=0x61; break;
				case 11: packet[size++]=0x62; break;
				case 12: packet[size++]=0x63; break;
				case 13: packet[size++]=0x64; break;
				case 14: packet[size++]=0x65; break;
				case 15: packet[size++]=0x66; break;
				default: packet[size++]=0x30; break;
				}
				switch(c&0xF){
				case 0: packet[size++]=0x30; break;
				case 1: packet[size++]=0x31; break;
				case 2: packet[size++]=0x32; break;
				case 3: packet[size++]=0x33; break;
				case 4: packet[size++]=0x34; break;
				case 5: packet[size++]=0x35; break;
				case 6: packet[size++]=0x36; break;
				case 7: packet[size++]=0x37; break;
				case 8: packet[size++]=0x38; break;
				case 9: packet[size++]=0x39; break;
				case 10: packet[size++]=0x61; break;
				case 11: packet[size++]=0x62; break;
				case 12: packet[size++]=0x63; break;
				case 13: packet[size++]=0x64; break;
				case 14: packet[size++]=0x65; break;
				case 15: packet[size++]=0x66; break;
				default: packet[size++]=0x30; break;
				}
			}
			packet[size++] = 0x23;
			packet[size++] = (byte)0xAA;
		} catch (Exception e) {
		}
		if (size>0)	{
	        try { 
	        	ok = false;
	            for (i=0; i<5; i++){
	            	my_udp.send(ip, 6666, packet, size);
	                for (k=0; k<20; k++){
	                    if (my_udp.receive()>0) 
	                    {
	                      ok = true;
	                      break;
	                    }
	                }
	                if (ok) break;
	            }
	        } catch (Exception ex) {    
	            ex.printStackTrace();    
	        }
		}
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        
    	socketOpen(8811);

    	sendWindowText(1, "你好朋友123");
    	
    	socketClose();
        
        System.out.println("运行结束.");
    }

}
