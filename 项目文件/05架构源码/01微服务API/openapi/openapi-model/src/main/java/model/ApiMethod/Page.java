package model.ApiMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	private int pageNo = 1;// 页码，默认是第一页
	private int pageSize = 15;// 每页显示的记录数，默认是15
	private int total;// 总记录数
	private int totalPage;// 总页数
	private List<T> rows;// 对应的当前页记录

	private Map<String, Object> params = new HashMap<String, Object>();// 其他的参数我们把它分装成一个Map对象

	
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		// 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
		int totalPage = total % pageSize == 0 ? total / pageSize : total
				/ pageSize + 1;
		this.setTotalPage(totalPage);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
				.append(pageSize).append(", results=").append(rows)
				.append(", totalPage=").append(totalPage)
				.append(", totalRecord=").append(total).append("]");
		return builder.toString();
	}

}
