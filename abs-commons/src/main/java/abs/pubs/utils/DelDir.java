package abs.pubs.utils;

import java.io.File;

public class DelDir {
	  //递归方法
	     public static void deletefile(File allfile) {
	         //获取该目录下的所有文件或文件夹的File数组
	         File[] arrayfile = allfile.listFiles();
	         
	         for(File file : arrayfile){
	             if(file.isDirectory()){
	                 deletefile(file);
	             }
	             else{
	                file.delete();
	             }
	         }
	 
	     }
}
