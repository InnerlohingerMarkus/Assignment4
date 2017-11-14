import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;


public class Reader implements Assignment4{

	private Document doc;
	private List rootList;
	private Element root;
	
	
	Reader(File file){
		rootList=new List("root");
		try{
			loadXml(file);
			buildXmlTree(root,rootList);
		}catch(Exception e){
			System.err.println("ERROR: File not found!");
		}
	}
	
	
	
	   /** loads the xml file or throws an Exception if anything goes wrong */
	   public void loadXml(File input) throws Exception{
		
			File xmlFile= input;
			DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
			doc= dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			root = doc.getDocumentElement();
			
	   }
	   
	   
	   //builds an object-tree out of the XML-Basis
	   private void buildXmlTree(Node root,Item list){
		   if(root.hasChildNodes()){
			   for(int i=0;i<root.getChildNodes().getLength();i++){
				   Node child=root.getChildNodes().item(i);
				   if(child.hasChildNodes()){
					   List tempList=new List(child.getAttributes().item(0).getNodeValue());
					   list.add(tempList);
					   buildXmlTree(child,tempList);
				   }
				   else{
					   if (child.getNodeName().startsWith("b")){
						   
						   Book book=new Book(child.getAttributes().item(1).getNodeValue(),Integer.parseInt(child.getAttributes().item(2).getTextContent()),child.getAttributes().item(2).getNodeValue());
						   list.add(book);
					   }
					   else if (child.getNodeName().startsWith("c")){
						   CD cd=new CD(child.getAttributes().item(0).getNodeValue(),Integer.parseInt(child.getAttributes().item(1).getTextContent()));
						   list.add(cd);
					   }
				   }
			   }
		   }	
	   }
		   
	   
	   /** returns the price of an item (cd, book, or list) */
	   public double getPrice(String item){
			return getPrice(rootList,item);
	   }
	   
	   
	   
	   
	   public double getPrice(List list, String name){
		   double output=0;
		   
		   //needed for lists
			if(list.getName().compareTo(name)==0){
				output+=list.getPrice();
			}
		   
			// goes into recursion if item is a list
			for(int i=0;i<list.size();i++){
				if(list.get(i).getName().startsWith("L")){
					output+=getPrice((List)list.get(i),name);
				}
				
				//needed for single-items
				else{
					if(list.get(i).getName().compareTo(name)==0){
						output+=list.get(i).getPrice();
					}
				}
			}
			return output;
	   }
}

