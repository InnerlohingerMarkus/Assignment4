
public class CD implements Item {

	
	private String name;
	private int price;
	
	CD(String name, int price){
		this.name=name;
		this.price=price;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void add(Item i){}
}


