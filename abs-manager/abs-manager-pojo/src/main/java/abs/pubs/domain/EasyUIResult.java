package abs.pubs.domain;

import java.io.Serializable;
import java.util.List;
/**
 * easyui返回结果集，分页必备参数
 * @author 曹起坤
 *
 */
@SuppressWarnings("serial")
public class EasyUIResult implements Serializable{

	private Long total;
	private List<?> rows;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
