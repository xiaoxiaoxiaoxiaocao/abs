package abs.pubs.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cserver {

	  private static final int PORT = 8813;  
	    private static List<Socket> mClientList = new ArrayList<Socket>();  
	    private ServerSocket server = null;  
	    private ExecutorService mExecutors = null; // 线程池对象  
	  
	    public static void main(String[] args) {  
	          new Cserver();
	    }  
	  
	    /** 
	     * 构造方法：任务是启动服务器，等待客户端连接 
	     * @return 
	     */  
	    public Cserver() {  
	        try {  
	            server = new ServerSocket(PORT);//创建一个服务端的socket
	            mExecutors = Executors.newCachedThreadPool(); // 创建线程池  
	            System.out.println("服务器已启动，等待客户端连接...");  
	            Socket client = null;  
	            /* 
	             * 用死循环等待多个客户端的连接，连接一个就启动一个线程进行管理 
	             */  
	            while (true) {  
	                client = server.accept();  
	                // 把客户端放入集合中  
	                mClientList.add(client);  
	                Service service=new Service(client,"哈哈哈");
	                mExecutors.execute(service); // 启动一个线程，用以守候从客户端发来的消息  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
}
