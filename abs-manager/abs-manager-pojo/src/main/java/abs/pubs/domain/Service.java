package abs.pubs.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Service implements Runnable{
	
	 private static Socket socket;  
     private BufferedReader in = null;  
     private String message = "";  

     public Service(Socket socket,String msg) {  
         this.socket = socket;  
         try {  
             in = new BufferedReader(new InputStreamReader(  
                     socket.getInputStream()));// 获得输入流对象  
             // 客户端只要一连到服务器，便发送连接成功的信息  
             message = "服务器地址：" + this.socket.getInetAddress();  
//             this.sendMessage(message);  
//             message = "当前连接总数:" + mClientList.size();  
             this.sendMessage(message+msg);  
         } catch (IOException e) {  
             e.printStackTrace();  
         }  

     }  

     @Override  
     public void run() {  
         try {  
             while (true) {  
                 if ((message = in.readLine()) != null) {  
                     // 当客户端发送的信息为：exit时，关闭连接  
                     if (message.equals("exit")) {  
                         closeSocket();  
                         break;  
                     } else {  
                         // 接收客户端发过来的信息message，然后转发给客户端。  
                         message = socket.getInetAddress() + ":" + message;  
                         this.sendMessage(message);  
                     }  
                 }  
             }  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
     }  

     /** 
      * 关闭客户端 
      *  
      * @throws IOException 
      */  
     public void closeSocket() throws IOException {  
//         mClientList.remove(socket);  
         in.close();  
//         message = "主机:" + socket.getInetAddress() + "关闭连接\n目前在线:"  
//                 + mClientList.size();  
         socket.close();  
         this.sendMessage(message);  
     }  

     /** 
      * 将接收的消息转发给每一个客户端 
      *  
      * @param msg 
      */  

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
