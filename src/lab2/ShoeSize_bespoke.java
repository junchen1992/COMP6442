package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 */

public class ShoeSize_bespoke {
	@SuppressWarnings("unused")
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.xml";

	private Integer shoesize;

	public ShoeSize_bespoke() throws NumberFormatException, IOException {
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

	public boolean set(Integer v) throws IOException {
		if (v == null || v >= ShoeSize_bespoke.SHOESIZEMIN
				&& v <= ShoeSize_bespoke.SHOESIZEMAX) {
			shoesize = v;
			save();
			return true;
		} else {
			shoesize = null;
			return false;
		}
	}

	void load() throws NumberFormatException, IOException {
		// add code here that will load shoe size from a file called "FILENAME"
		File f = new File("shoesize.txt");
		if (!f.exists())
			return;
		BufferedReader br = new BufferedReader(new FileReader(f));
		shoesize = Integer.parseInt(br.readLine().trim());
		br.close();
	}

	void save() throws IOException {
		// add code here that will save shoe size into a file called "FILENAME"
		if (shoesize == null)
			return;
		File f = new File("shoesize.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(shoesize.toString());
		bw.close();
	}
}