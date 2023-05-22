package kr.go.gangneung.dto;

public class Category {
	private String ct; //최상위 카테고리 분류코드 (a, b, c, d) 
	private String cate; //카테고리 코드 a01, b01, c01, d01...
	private String cateGroup; //상위 카테고리명
	private String cateName; //하위 카테고리명
	private String bno;	//게시글 번호
	
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCateGroup() {
		return cateGroup;
	}
	public void setCateGroup(String cateGroup) {
		this.cateGroup = cateGroup;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	
}
