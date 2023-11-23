package com.write.www;

import java.sql.Time;

public class BoardDTO {
	private int id;
	private String writer;
	private String title;
	private String content;
	private Time createdDate;
	private String password;
	
	public BoardDTO(int id, String writer, String title, String content, Time createdDate, String password) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Time getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Time createdDate) {
		this.createdDate = createdDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
