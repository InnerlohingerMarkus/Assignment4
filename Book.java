
public class Book implements Item {

	private String name, isbn;
	private int price;
	
	Book(String name, int price, String isbn){
		this.name=name;
		this.price=price;
		this.isbn=isbn;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public void add(Item i){}

}
