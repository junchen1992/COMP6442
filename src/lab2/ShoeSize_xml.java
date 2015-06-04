package lab2;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 */

public class ShoeSize_xml {
	@SuppressWarnings("unused")
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.xml";

	private Integer shoesize;

	public ShoeSize_xml() {
		shoesize = null;
		try {
			load();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String show() {
		return (shoesize == null ? "" : shoesize.toString());
	}

	public boolean set(Integer v) {
		if (v == null || v >= ShoeSize_xml.SHOESIZEMIN
				&& v <= ShoeSize_xml.SHOESIZEMAX) {
			shoesize = v;
			save();
			return true;
		} else {
			shoesize = null;
			return false;
		}
	}

	void load() throws FileNotFoundException {
		// add code here that will save shoe size into a file called "FILENAME"
		File f = new File(FILENAME);
		if (!f.exists())
			return;
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
				new FileInputStream(FILENAME)));
		shoesize = (Integer) decoder.readObject();
		decoder.close();
	}

	void save() {
		// add code here that will load shoe size from a file called "FILENAME"
		try {
			XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream(FILENAME)));
			encoder.writeObject(shoesize);
			encoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}