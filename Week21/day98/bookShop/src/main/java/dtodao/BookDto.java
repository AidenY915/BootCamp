package dtodao;

import java.io.Serializable;

public class BookDto implements Serializable{
	private static final long serialVersionUID = 3488409533212425779L;
	private int id;
	private String name;
	private int price;
	public BookDto() {
		super();
	}
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
