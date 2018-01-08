package abs.pubs.domain;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket 线程类
 * 
 * @author huajian
 */
public class SocketThread extends Thread {
	private ServerSocket serverSocket = null;
	private static Socket socket=null;

	public SocketThread(ServerSocket serverScoket) {
		try {
			if (null == serverSocket) {
				this.serverSocket = new ServerSocket(8813);
				System.out.println("socket start");
			}
		} catch (Exception e) {
			System.out.println("SocketThread创建socket服务出错");
			e.printStackTrace();
		}

	}

	public void run() {
		while (!this.isInterrupted()) {
			try {
				socket = serverSocket.accept();

				if (null != socket && !socket.isClosed()) {
					// 处理接受的数据
					new SocketOperate(socket).start();
				}
				socket.setSoTimeout(30000);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void closeSocketServer() {
		try {
			if (null != serverSocket && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 public static void sendMessage(String msg) {  
         System.out.println(msg);// 先在控制台输出  
//         int count = mClientList.size();  
         // 遍历客户端集合  
//         for (int i = 0; i < count; i++) {  
//             Socket mSocket = mClientList.get(i);  
             PrintWriter out = null;  
             try {  
                 out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),  
                         true);// 创建输出流对象  
                 out.println(msg);// 转发  
             } catch (IOException e) {  
                 e.printStackTrace();  
             }  
//         }  
     }
}