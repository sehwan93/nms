package org.nms.util;

public class Criteria {
	private int page;
	private int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if(page <=0 ) {
			this.page=1;
			return;
		}
		this.page=page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum=perPageNum;
	}
	
	// mybatis에서 사용 할 수 있도록 get을 접두어로 만들어줌
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
}
