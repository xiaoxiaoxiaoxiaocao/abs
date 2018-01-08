package abs.pubs.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EasyUITreeNode implements Serializable {
	//根据easyui框架需要树形返回值的结果来定义javabean
	//树形节点id
	private Integer id;
	//树形节点的名称
	private String text;
	//树形节点的状态，如果此节点有子节点，状态为closed表示可以打开
	//如果此节点没有子节点，状态为open，表示已经打开
	private String state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
