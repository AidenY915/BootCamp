package com.loginboard.www.daodto;

import java.io.Serializable;
import java.sql.Timestamp;

public class BoardDto implements Serializable{
	private static final long serialVersionUID = -5690069701926789656L;
	private int no;
	private String id;
	private String nickname;
	private String title;
	private String content;
	private Timestamp createdDate;
	private int views;
	private int groupNum;
	private int stepNum;
	private int indentNum;
	
	public BoardDto() {}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}
	public int getStepNum() {
		return stepNum;
	}
	public void setStepNum(int stepNum) {
		this.stepNum = stepNum;
	}
	public int getIndentNum() {
		return indentNum;
	}
	public void setIndentNum(int indentNum) {
		this.indentNum = indentNum;
	}
	
}
