package ch04.com.dto;

import java.io.Serializable;

public class Person implements Serializable{
	private int id = 20181004;
	private String name = "홍길순";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
