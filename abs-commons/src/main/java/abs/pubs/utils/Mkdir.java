package abs.pubs.utils;

import java.io.File;
/**
 * 工具类：传一个string类型的路径，如该路径不存在就创建一个
 * @author kun
 *
 */
public class Mkdir {
	public static void mkdir(String path){
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

}
