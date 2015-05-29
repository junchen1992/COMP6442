package lab2;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 */

public class ShoeSize {
	//private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.xml";

	private Integer shoesize;

	public ShoeSize() {
		shoesize = null;
		File file0 = new File("sizerecord");
		if(file0.exists())
		{
			System.out.println("tp 3");
			shoesize = load("sizerecord").shoesize;
		}

	}

	public String show() {
		return (shoesize == null ? "" : shoesize.toString());
	}

	public boolean set(Integer v) {
		if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
			shoesize = v;
			save("sizerecord");
			return true;
		} else {
			shoesize = null;
			return false;
		}
	}

	static public ShoeSize load(String filename) {
		// add code here that will save shoe size into a file called "FILENAME"
		System.out.println("tp 1");
		File file = new File(filename);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		ShoeSize res = new ShoeSize();
		
		System.out.println("tp 1");
		try{
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			
			Node shoe = doc.getFirstChild();
			NodeList nl = shoe.getChildNodes();
			Node n = nl.item(0);
			System.out.println("Age : " );
				if(n.getNodeName().equals("Size"))
					res.shoesize = Integer.parseInt(n.getTextContent());

		}catch(Exception e)
		{
			System.err.println("Problem loading " + filename);
		}
		return res;
	}

	void save(String filename) {
		// add code here that will load shoe size from a file called "FILENAME"
		File file = new File(filename);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try{
			db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			Element shoe = doc.createElement("SHOE");
			Element size = doc.createElement("Size");
			size.appendChild(doc.createTextNode(Integer.toString(shoesize)));
			shoe.appendChild(size);
			doc.appendChild(shoe);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		}catch (Exception e){
			System.err.println("Problem saving " + filename);			
		}
	}
}
