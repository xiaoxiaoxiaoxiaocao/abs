package abs.pubs.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtil implements Runnable{
	private static Socket socket;
	
	@SuppressWarnings("resource")
	public static void send(String msg){
		 PrintWriter out;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),  
			         true);
			out.println("Hello Client，I'm Server");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 创建输出流对象  
	}
	
	public static void main(String[] args) {
		send("ceshi ceshi");
	}

	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(8813);
			System.out.println("服务创建");
			socket = serverSocket.accept();
			System.out.println("客户端连接");
			//Socket socket = new Socket("192.168.0.229", 8813);
			
//			 socket.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
