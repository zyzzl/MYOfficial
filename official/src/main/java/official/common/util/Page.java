package official.common.util;

import java.util.List;

/**
 * 分页
 * 
 * @author zY
 *
 */
public class Page {
	private int pageIndex = 1; // 页码
	
	private int pageSize = 20; // 每页数据量
	
	private int totalCount; // 总数据量
	
	private int totalPage; // 总页数

	private List<?> T;
	
	public Page(Integer pageIndex, Integer pageSize, Integer totalCount) {
		super();
		this.setTotalCount(totalCount);

		this.setPageSize(pageSize);

		this.setTotalPage();
		this.setPageIndex(pageIndex);//当前页放在最后赋值
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {//index 为null
		if (pageIndex == null) {
			return;
		}
		if (pageIndex > this.totalPage) {
			this.pageIndex = this.totalPage;
		} else if (pageIndex <= 0 ) {
			this.pageIndex = 1;
		} else {
			this.pageIndex = pageIndex;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			return;
		}
		this.pageSize = pageSize < 0? 0 : pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if (totalCount == null) {
			return;
		}
		this.totalCount = totalCount < 0? 0 : totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		if (this.pageSize > 0) {
			this.totalPage = this.totalCount % this.pageSize == 0? this.totalCount / this.pageSize : this.totalCount / this.pageSize +1;
		} else {
			this.totalPage = 0;
		}
	}

	public List<?> getT() {
		return T;
	}

	public void setT(List<?> t) {
		T = t;
	}
}

