package abs.pubs.led;
import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.Set;

public class MyUdpSocket {
	private DatagramChannel channel;
    private Selector selector;
	private final int MAX_SIZE = 1280;
	private static int client_port;
	private static String client_ip;
	ByteBuffer receive_buffer = ByteBuffer.allocate(MAX_SIZE);
  
	public MyUdpSocket(int port) throws IOException {
		channel=DatagramChannel.open();
		selector=Selector.open();
		try{
			//������ͨ��Ϊ������ģʽ  
			channel.configureBlocking(false);  
			//��ȡ���׽���ͨ���������׽��֣��������׽��ְ󶨵�����ָ���˿�  
			channel.socket().bind(new InetSocketAddress(port));
			//Ϊͨ��ѡ����ע��ͨ������ָ��������ѡ�����  
			channel.register(selector, SelectionKey.OP_READ);  
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public final void send(String ip, int port, byte[] buffer, int size) throws IOException {
		InetSocketAddress client=new InetSocketAddress(ip, port);
		channel.send(ByteBuffer.wrap(buffer), client);  //��EchoClient�ظ�һ�����ݱ�
	}
	
	public final void close() throws IOException {
		selector.close();
		channel.close();
	}
	
	public final int get_client_port(){
		return client_port;
	}

	public final String get_client_ip(){
		return client_ip;
	}
	
	public final void get_receive_buffer(byte[] buffer){
		receive_buffer.get(buffer);
	}

	public final int receive() {
		try{
			receive_buffer.clear();
			if (selector.select(10)!=0){
				Set<SelectionKey> readyKeys = selector.selectedKeys();  
				for(SelectionKey key : readyKeys){  
					readyKeys.remove(key);  
					if(key.isReadable()){
						DatagramChannel dc = (DatagramChannel)key.channel();  
						InetSocketAddress client = (InetSocketAddress)dc.receive(receive_buffer); //������������һ��Client�����ݱ�
						if (client!=null)
						{
							client_ip=client.getAddress().getHostAddress();
							client_port=client.getPort();
							//System.out.println(client_ip+":"+client_port+" size="+receive_buffer.position());
							key.interestOps(SelectionKey.OP_READ);
							return receive_buffer.position();
						}
						else
						{
							return 0;
						}
					}
					else
					{
						return 0;
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public final void get_receive_packet(byte[] packet, int size){
		int i;
		for (i=0; i<size; i++){
			packet[i]=receive_buffer.array()[i];
		}
	}

}
