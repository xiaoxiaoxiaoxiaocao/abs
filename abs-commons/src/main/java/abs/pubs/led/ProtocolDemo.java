package abs.pubs.led;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
//import java.util.Calendar;

public class ProtocolDemo {

    // ====���붯����ʽ�б�(��ֵ��0��ʼ)====
    // 0 = '���',
    // 1 = '������ʾ',
    // 2 = '�����ʾ',
    // 3 = '�Ϲ���ʾ',
    // 4 = '�ҹ���ʾ',
    // 5 = '�¹���ʾ',
    // 6 = '���������ʾ',
    // 7 = '�����Ϲ���ʾ',
    // 8 = '�����ҹ�',
    // 9 = '�����¹�',
    // 10 = '�м�������չ��',
    // 11 = '�м�������չ��',
    // 12 = '�м�������չ��',
    // 13 = '������������',
    // 14 = '������������',
    // 15 = '��������չ��',
    // 16 = '��������չ��',
    // 17 = '�����Ͻ�����',
    // 18 = '�����½�����',
    // 19 = '�����Ͻ�����',
    // 20 = '�����½�����',
    // 21 = '������������',
    // 22 = '������������',
    // 23 = '�����Ҷ��',
    // 24 = '�����Ҷ��',
    // =====================================

    // ====����������ʽ�б�(��ֵ��0��ʼ)====
    // 0 = '���',
    // 1 = '����ʧ',
    // 2 = '������ʧ',
    // 3 = '�������м��£',
    // 4 = '�������м��£',
    // 5 = '�������м��£',
    // 6 = '���������Ƴ�',
    // 7 = '���������Ƴ�',
    // 8 = '���������£',
    // 9 = '�������Һ�£',
    // 10 = '�����Ͻ��Ƴ�',
    // 11 = '�����½��Ƴ�',
    // 12 = '�����Ͻ��Ƴ�',
    // 13 = '�����½��Ƴ�',
    // 14 = '���������Ƴ�',
    // 15 = '���������Ƴ�',
    // 16 = '�����Ҷ��',
    // 17 = '�����Ҷ��'
    // =====================================

    // ====ͣ��������ʽ�б�(��ֵ��0��ʼ)====
    // 0 = '��̬��ʾ',
    // 1 = '��˸��ʾ'
    // =====================================
    
    public static MyUdpSocket my_udp;
    public static String ledhost;
    //public static int ledport;
    public static LEDSender2010 ledsender = new LEDSender2010();
   // public static String ledhost = "127.0.0.1";
//    public static String ledhost = "192.168.0.99";
    public static int ledport = 6666;
    public static int addr = 0;
    
    

	/*public void ProtocolDemo(MyUdpSocket myUdpSocket){
    	
    }*/
    
    public static void mysleep(int msec){
        try{  
            Thread.sleep(msec);  
            }  
            catch (InterruptedException e){  
             e.printStackTrace();  
            }  
    }
    
   
    
    
    //����UDP����bufferΪ�������ݣ�sizeΪ�������ݳ���
    public static void udp_send(byte[] buffer, int size){
        byte[] packet = new byte[size];
        ledsender.blockCopy(packet, 0, buffer, 0, size);
        ledsender.print_stream(packet, size);
        try {    
            my_udp.send(ledhost, ledport, packet, size);
        } catch (Exception ex) {    
            ex.printStackTrace();    
        }
    }
    
    //����UDP����bufferΪ�������ݣ�sizeΪ�������ݳ���
    public static int udp_receive(byte[] buffer){
        int size=0;
        size=my_udp.receive();
        if(size>0){ 
        	my_udp.get_receive_packet(buffer, size);
        }
        return size;
    }

    public static void do_command(byte[] buffer, int size){
        byte[] packet = new byte[1280];
        int tx, tx_repeat=5;
        int isize=0;
        int i;
        for (tx=0; tx<tx_repeat; tx++){
            udp_send(buffer, size);
            for (i=0; i<50; i++){
            	isize=udp_receive(packet);
                if (isize>0 && ledsender.parse_cmd_respond(packet, isize)==1) 
                {
                	return;
                }
            }
        }
        System.out.println("��ʱ");
    }
    
    public static void demo_power_on(){
        int size;
        byte[] packet = new byte[1280];
        size=ledsender.pkg_set_power(packet, (byte)0, 1);
        System.out.println("�򿪵�Դ...");
        do_command(packet, size);
    }
    
    public static void demo_power_off(){
        int size;
        byte[] packet = new byte[1280];
        size=ledsender.pkg_set_power(packet, (byte)0, 0);
        System.out.println("�رյ�Դ...");
        do_command(packet, size);
    }
    
    public static void demo_get_power(){
        int size;
        byte[] packet = new byte[1280];
        size=ledsender.pkg_get_power(packet, (byte)0);
        System.out.println("��ȡ��Դ״̬...");
        do_command(packet, size);
    }
    
    public static void demo_set_bright(){
        int size;
        byte[] packet = new byte[1280];
        size=ledsender.pkg_set_bright(packet, (byte)0, 7);
        System.out.println("��������...");
        do_command(packet, size);
    }

    public static void demo_get_bright(){
        int size;
        byte[] packet = new byte[1280];
        size=ledsender.pkg_get_bright(packet, (byte)0);
        System.out.println("��ȡ����...");
        do_command(packet, size);
    }
    
    public static void demo_adjust_time(){
        int size;
        byte[] packet = new byte[1280];
        //Calendar calendar = Calendar.getInstance();
        //ָ��ʱ��Уʱ��12Сʱ��
        //size=ledsender.pkg_adjust_time_ex(packet, (byte)0, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_WEEK)-1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        //ָ��ʱ��Уʱ��24Сʱ��
        //size=ledsender.pkg_adjust_time_ex(packet, (byte)0, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_WEEK)-1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        //�Ե�ǰϵͳʱ��Уʱ
        size=ledsender.pkg_adjust_time(packet, (byte)0);
        System.out.println("У��ʱ��...");
        do_command(packet, size);
    }

    public static void demo_get_boardparam(){
        int size;
        byte[] packet = new byte[1280];
        size=ledsender.pkg_get_boardparam(packet, (byte)0);
        System.out.println("��ȡ���ƿ�����...");
        do_command(packet, size);
    }
    
    public static void demo_power_schedule(){
        int size;
        byte[] packet = new byte[1280];
        //��һ��7��ÿ�ն�ʱ��������ÿ�տ��Զ���3��ʱ��
        size=ledsender.pkg_power_schedule_weekday(packet, (byte)0, true);
        //��ָ������ֹ����ʱ�䲥�ţ�һ�����Զ���21��ʱ��
        //size=ledsender.pkg_power_schedule_period(packet, (byte)0, true);
        System.out.println("���ö�ʱ�������ƻ�...");
        do_command(packet, size);
    }
    
    //dib_bufferΪ����ͼƬ��RGB���飬����Ϊ�������飬�����ÿ����Ԫ����һ�����ص��RGBֵ
    //  ���ص�(X,Y)��RGBֵ����һ��һ��˳�����У������64����32����
    //    (0,0),(0,1),(0,2),...(0,31)  (1,0),(1,1),(1,2),...(1,31)  (2,0),(2,1),(2,2),...(2,31)  ... (63,0),(63,1),(63,2),...(63,31)
    //    ���ص��RGBֵ��������ʾ��0-7λ��ʾ��ɫ��8-15λ��ʾ��ɫ��16-23��ʾ��ɫ��24-31λ������0
    //    ����dib_buffer[n]&0xFF ��ʾ��ɫ
    //        (dib_buffer[n]>>8)&0xFF ��ʾ��ɫ
    //        (dib_buffer[n]>>16)&0xFF ��ʾ��ɫ
    public static int dib_width = 64;
    public static int dib_height = 64;
    public static int dib_buffer_size = dib_width*dib_height; 
    public static int[] dib_buffer = new int[dib_buffer_size];
    public static void draw_dib(){
        int x, y, z=0;
        int seek=0;
        int color=0xFF;
        for (x=0; x<dib_width; x++){
            for (y=0; y<dib_height; y++){
                dib_buffer[seek++]=color;
            }
            z++;
            if (z>=4) {
                switch(color){
                case 0xFF:
                    color=0xFF00;
                    break;
                case 0xFF00:
                    color=0xFFFF;
                    break;
                case 0xFFFF:
                    color=0xFF;
                    break;
                default:
                    color=0xFF;
                    break;
                }
                z=0;
            }
        }
    }
    
    public static void send_data(){
    	int size=0;
        byte[] packet = new byte[1280];
        int i, j, k, x, r;
        int tx, tx_repeat=5;
        boolean ok;
        //����ΪͨѶ���룬�������ݵĲ�ִ��������
        //    ������UDPͨѶ������

        //��ʼ��
        ok=false;
        System.out.println("������ʼ��...�����к�=0");
        for (tx=0; tx<tx_repeat; tx++){
            size=ledsender.pkg_begin(packet, addr);
            udp_send(packet, size);
            for (x=0; x<50; x++){
            	size=udp_receive(packet);
            	if (size>0 && ledsender.parse_trans_respond(packet, size, LEDSender2010.PKC_BEGIN, 0)>0){
                    System.out.println("��ʼ��������ɣ����к�=0");
                    ok=true;
                    break;
            	}
            }
            if (ok) break;
        }
        if (!ok){
            System.out.println("��ʱ");
            return;
        }

        //���ݰ�
        k=ledsender.get_pkg_count(512);
        i=1;
        while (i<=k){
            ok=false;
            System.out.println("�������ݰ�...�����к�="+i);
            for (tx=0; tx<tx_repeat; tx++){
            	j=i;
                size=ledsender.pkg_data(packet, addr, i, 512);
                udp_send(packet, size);
                for (x=0; x<50; x++){
                	size=udp_receive(packet);
                	if (size>0){
                		r=ledsender.parse_trans_respond(packet, size, LEDSender2010.PKC_DATA, i);
                		switch(r){
                		case 0x1:
                        	System.out.println("���ݰ�������ɣ����к�="+i);
                            ok=true;
                            j=i+1;
                			break;
                		case 0x2:
                        	System.out.println("���ݰ����к�У�Դ���Ӧ��="+i+"��ʵ��="+ledsender.fix_serialno);
                			j=ledsender.fix_serialno;
                			break;
                		}
                        //ok=true;
                        //break;
                	}
                    if (ok) break;
                }
                i=j;
                if (ok) break;
            }
            if (!ok){
                System.out.println("��ʱ");
                return;
            }
        }

        //������
        ok=false;
        System.out.println("���ͽ�����...�����к�="+i);
        for (tx=0; tx<tx_repeat; tx++){
            size=ledsender.pkg_end(packet, addr, i);
            udp_send(packet, size);
            for (x=0; x<50; x++){
            	size=udp_receive(packet);
            	if (size>0 && ledsender.parse_trans_respond(packet, size, LEDSender2010.PKC_END, i)>0){
                    System.out.println("������������ɣ����к�="+i);
                    ok=true;
                    break;
            	}
            }
            if (ok) break;
        }
        if (!ok){
            System.out.println("��ʱ");
            return;
        }
    }
    
    public static void demo_upgrade(){
    	ledsender.Upgrade("d:\\vsd.bin");
    	send_data();
    }
    
    public static void demo_play(){
        //String[] formats={"#y", "��", "#m", "��", "#d", "��", " ", "#h", ":", "#n", ":", "#s"};
        //String[] formats={"#h", ":", "#n", ":", "#s"};

        //���ɽ�Ŀ����
        //ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);
    	ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);
        ledsender.AddChapter(1, 1000);
        ledsender.AddRegion(0, 0, 64, 32);
        
        ///*
        //����ͼƬ
       // ledsender.AddLeaf(1, 2000);
        //draw_dib();
        //ledsender.AddDib(0, 0, 64, 64, dib_buffer, dib_buffer_size, dib_width, dib_height, 1, 5, 2, 5, 0, 0, 1000);
       /* BufferedImage bi;
        try {
            bi = LEDSender2010.createImageEx("�л����񹲺͹�", new Font("����", Font.BOLD, 14), Color.BLACK, Color.CYAN, 0, false, 64);
            System.out.println("width:"+bi.getWidth()+"height:"+bi.getHeight());
            ledsender.AddWindow(0, 0, 64, 32, LEDSender2010.getBufferedImageRGB(bi), bi.getWidth() * bi.getHeight(), bi.getWidth(), bi.getHeight(), 2, 0, 2, 0, 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //*/
        
        
        //�������֣��Զ����У�
        ledsender.AddLeaf(1, 2000);
        ledsender.AddText(0, 0, 64, 32, "�л����񹲺͹�", "����", 14, Color.BLACK, Color.YELLOW, 0, 0, true, 1, 0, 2, 0, 0, 0, 0);
        

        
      /*  //�������֣����У�֧�ֶ��뷽ʽ��
        ledsender.AddLeaf(1, 2000);
        ledsender.AddTextEx(0, 0, 64, 32, "abc", LEDSender2010.ALIGN_CENTER, LEDSender2010.ALIGN_TOP, "����", 14, Color.BLACK, Color.RED, 0, 1, 0, 2, 0, 0, 0, 0);
        //
*/
        /*
        //16������������
        ledsender.AddLeaf(1, 2000);
        ledsender.AddString(0, 0, 64, 32, "����Hello world", 1, 5, 2, 5, 0, 0, 1000, 0xFFFF, 0);
        //16������������ʱ�䣬��ʽyyyy��mm��dd�� hh:nn:ss
        ledsender.AddLeaf(1, 2000);
        ledsender.AddStringDateTime(0, 0, 256, 32, 0xFFFFFF, 0, formats, 5);
        */

        /*
        //24������������
        ledsender.AddLeaf(1, 2000);
        ledsender.AddString(0, 0, 64, 32, "��ӭ����abc", 2, 0, 2, 0, 0, 0, 0, 0xFF, 1);
        //24��������ʱ�䣬��ʽyyyy��mm��dd��
        ledsender.AddLeaf(1, 2000);
        ledsender.AddStringDateTime(0, 0, 256, 32, 0xFFFF, 1, formats, 6);
        */

        //ledsender.Compress();
        send_data();
    }

    public static void demo_play_chapterschedule(){
        //String[] formats={"#y", "��", "#m", "��", "#d", "��", " ", "#h", ":", "#n", ":", "#s"};
        //String[] formats={"#h", ":", "#n", ":", "#s"};

        //���ɽ�Ŀ����
        ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);

        ledsender.AddChapterEx(1, 1000, 1, 1, 0x7F, 2016, 8, 17, 0, 0, 0, 2016, 12, 27, 23, 59, 59);
        ledsender.AddRegion(0, 0, 64, 64);
        
        //�������֣��Զ����У�
        ledsender.AddLeaf(1, 2000);
        ledsender.AddText(0, 0, 64, 32, "��ӭ����abc", "����", 14, Color.BLACK, Color.RED, 0, 2, true, 3, 0, 2, 0, 0, 0, 0);

        ledsender.AddChapterEx(1, 1000, 1, 1, 0x7F, 2016, 4, 28, 10, 10, 0, 2016, 12, 27, 23, 15, 0);
        ledsender.AddRegion(0, 0, 64, 64);
        
        //�������֣����У�֧�ֶ��뷽ʽ��
        ledsender.AddLeaf(1, 2000);
        ledsender.AddTextEx(0, 0, 64, 32, "лл�ݹ�abc", LEDSender2010.ALIGN_CENTER, LEDSender2010.ALIGN_TOP, "����", 14, Color.BLACK, Color.RED, 0, 1, 0, 2, 0, 0, 0, 0);

        send_data();
    }

    public static void demo_play_picture(){
        //���ɽ�Ŀ����
        ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);
        ledsender.AddChapter(1, 1000);
        ledsender.AddRegion(0, 0, 64, 64);
        ledsender.AddLeaf(1, 2000);
        ledsender.AddPicture(0, 0, 64, 64, "c:\\demo.bmp", 1, 0, 2, 0, 0, 0, 0);
        send_data();
    }

    public static void demo_datetime_play(){
        String[] formats_datetime={"#y", "��", "#m", "��", "#d", "��", " ", "#h", ":", "#n", ":", "#s"};
        String[] formats_date={"#y", "��", "#m", "��", "#d", "��"};
        String[] formats_time={"#h", ":", "#n", ":", "#s"};
        String[] formats_week={"����", "#w"};

        //���ɽ�Ŀ����
        //ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);
        ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_THREE);
        ledsender.AddChapter(1, 10000);
        ledsender.AddRegion(0, 0, 64, 64);

        ledsender.AddLeaf(1, 2000);
        ledsender.AddDateTime(0, 0, 64, 32, formats_datetime, 12, "����", 14, Color.BLACK, Color.YELLOW, 0);
        ledsender.AddLeaf(1, 2000);
        ledsender.AddDateTime(0, 0, 64, 32, formats_date, 6, "����", 14, Color.BLACK, Color.RED, 0);
        ledsender.AddLeaf(1, 2000);
        ledsender.AddDateTime(0, 0, 64, 32, formats_time, 5, "����", 14, Color.BLACK, Color.GREEN, 0);
        ledsender.AddLeaf(1, 2000);
        ledsender.AddDateTime(0, 0, 64, 32, formats_week, 2, "����", 14, Color.BLACK, Color.RED, 0);

        send_data();
    }

    public static void demo_schedule_child_play(){
        //���ɽ�Ŀ����
        //String[] formats_datetime={"#y", "��", "#m", "��", "#d", "��", " ", "#h", ":", "#n", ":", "#s"};

        ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);
        ledsender.AddChapter(1, 10000);
        ledsender.AddRegion(0, 0, 64, 64);

        ledsender.AddLeaf(1, 2000);
        ledsender.AddWindows(0, 0, 64, 32);
        //ledsender.AddChildText("abc", "����", 14, Color.BLACK, Color.RED, 0, false, 1, 0, 2, 0, 0, 0, 0);
        ledsender.AddChildScheduleText("��ӭ����", "����", 14, Color.BLACK, Color.RED, 0, 0, false, 1, 0, 2, 0, 0, 0, 2000, 1, 0x7F, 2016, 4, 28, 16, 10, 0, 2016, 6, 27, 23, 15, 0);
        ledsender.AddChildScheduleText("лл�ݹ�", "����", 14, Color.BLACK, Color.RED, 0, 0, false, 1, 0, 2, 0, 0, 0, 2000, 1, 0x7F, 2016, 4, 28, 16, 10, 0, 2016, 5, 27, 23, 15, 0);

        send_data();
    }
    
    public static void demo_fontset_import(MyUdpSocket udp, String ip, int num, String text){
    	byte[] packet = new byte[1024];
    	byte[] s; 
    	int i, size;
    	int c;

    	size=0;
		try {
	    	s=text.getBytes("GB2312");
	    	size=0;
			packet[size++]=0x55;
	    	packet[size++]=0x25;
	    	packet[size++]=0x3E;
	    	packet[size++]=(byte)(((num/100)%10)+0x30);
	    	packet[size++]=(byte)(((num/10)%10)+0x30);
	    	packet[size++]=(byte)((num%10)+0x30);
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
	            udp = new MyUdpSocket(8868);
	            udp.send(ip, 6666, packet, size);
	        } catch (Exception ex) {    
	            ex.printStackTrace();    
	        }
		}
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        
    	
        try {    
            my_udp = new MyUdpSocket(8898);
        } catch (Exception ex) {    
            ex.printStackTrace();    
        }
        
    	//demo_fontset_import(my_udp, "192.168.0.99",6666, "�������123");
        
        demo_play();
        //demo_play_chapterschedule();
        //demo_upgrade();
        //demo_datetime_play();
        //demo_play_picture();
        //demo_schedule_child_play();
        //demo_get_boardparam();
        demo_power_off();
//        demo_power_on();
        //demo_get_power();
        //demo_set_bright();
        //demo_get_bright();
        //demo_adjust_time();
        //demo_power_schedule();
        
        System.out.println("���н���.");
    }

}
