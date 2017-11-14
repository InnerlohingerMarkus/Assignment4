

import java.util.ArrayList;

public class List implements Item {
	private String name;
	private ArrayList<Item> list;
	
	
	List(String name){
		this.name=name;
		list=new ArrayList<Item>();
		
	}
	
	public String getName(){
	return name;
	}
	
	public int getPrice(){
		int output=0;
		for(int i=0;i<list.size();i++){
			output+=list.get(i).getPrice();
		}
		return output;
	}
	
	public void add(Item i){
		list.add(i);
	}
	
	
	public int size(){
		return list.size();
	}
	
	public Item get(int i){
		return list.get(i);
		
	}
	
}

