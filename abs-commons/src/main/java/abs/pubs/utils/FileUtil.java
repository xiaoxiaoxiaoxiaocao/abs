package abs.pubs.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import abs.pubs.domain.Pls;
import abs.pubs.domain.Res;
import abs.pubs.manager.service.IXmlService;

/**
 * 工具类，从数据库读取数据，创建xml文件
 * 
 * @author kun
 *
 */
@Component
public class FileUtil {

	@Autowired
	private IXmlService xmlService; // 添加所需service的私有成员
	private static FileUtil fileUtil; // 关键点1 静态初使化 一个工具类 这样是为了在spring初使化之前

	public void setTestService(IXmlService xmlService) {
		this.xmlService = xmlService;
	}

	@PostConstruct // 关键二 通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
	public void init() {
		fileUtil = this;
		fileUtil.xmlService = this.xmlService; // 初使化时将已静态化的testService实例化
	}

	/*
	 * @Autowired private static IXmlService xmlService;
	 */
	public void createFile(){
		// 创建program_ccb文件
		Document doc = DocumentHelper.createDocument();
		// 添加根节点program
		Element program = doc.addElement("program");
		// 默认播放节点defaultpls
		Element defaultpls = program.addElement("defaultpls");
		defaultpls.addAttribute("areatype", "model_full_h");
		// 查询所有res添加到默认（default = 1）的list集合
		List<Res> list = xmlService.findDefaultRes();
		if (list != null && list.size() > 0) {
			// 添加res节点
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Element res = defaultpls.addElement("res");
				// 添加attribute属性
				res.addAttribute("resname", list.get(i).getResname());
				res.addAttribute("resid", list.get(i).getResid() + "");

			}

		}
		// pls节点，查询所有的pls
		List<Pls> plsList = xmlService.findAllPls();
		if (plsList != null && plsList.size() > 0) {
			for (Pls p : plsList) {
				// pls节点
				Element pls = program.addElement("pls");
				pls.addAttribute("areatype", p.getAreatype());
				pls.addAttribute("stdtime", p.getStdtime());
				pls.addAttribute("edtime", p.getEdtime());
				// 查询所有符合areatype的res
				Element resarr = pls.addElement("resarr");
				List<Res> resList = xmlService.findResByPlsId(p.getId());
				for (Res res : resList) {

					resarr.addAttribute("resname", res.getResname());
					resarr.addAttribute("resid", res.getPlsId() + "");
					resarr.addAttribute("area", res.getArea());
					resarr.addAttribute("playcnt", res.getPlaycnt() + "");
					resarr.addAttribute("priority", res.getPriority());
					if (res.getStdtime() != null) {
						resarr.addAttribute("stdtime", res.getStdtime());
					}
					if (res.getEndtime() != null) {
						resarr.addAttribute("edtime", res.getEndtime());
					}
				}

			}

		}
		try {
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setLineSeparator("\r\n");
			FileWriter writer = new FileWriter("F:/program.xml");
			XMLWriter outPut = new XMLWriter(writer, outputFormat);
			outPut.write(doc);
			outPut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	 /**
     * 字节缓冲流读写复制文件
     * @param src 源文件
     * @param out 目标文件
     */
    public static void BufferInputStreamBufferOutputStream(String src, String out) {
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(out));
            bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
            byte[] bytes = new byte[1024];
            int num = 0;
            while ((num = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, num);
                bufferedOutputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
	
}
