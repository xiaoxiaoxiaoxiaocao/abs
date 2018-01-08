package abs.pubs.manager.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import abs.pubs.domain.SocketThread;

public class SocketServiceLoader implements ServletContextListener{
	//socket server 线程 
	private SocketThread socketThread; 

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if(null==socketThread) 
		{ 
		//新建线程类 
		socketThread=new SocketThread(null); 
		//启动线程 
		socketThread.start(); 
		} 
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		if(null!=socketThread && !socketThread.isInterrupted()) 
		{ 
			socketThread.closeSocketServer(); 
			socketThread.interrupt(); 
		} 
		
	}

}
