package com.replyboard.www;

import java.sql.Timestamp;

public class BoardDto {
	private int no;
	private String writer;
	private String title;
	private String content;
	private String password;
	private Timestamp createdDate;
	private int groupNum;
	private int stepNum;
	private int indentNum;
	
	public BoardDto() {}

	public BoardDto(int no, String writer, String title, String content, String password, Timestamp createdDate,
			int groupNum, int stepNum, int indentNum) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.password = password;
		this.createdDate = createdDate;
		this.groupNum = groupNum;
		this.stepNum = stepNum;
		this.indentNum = indentNum;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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
