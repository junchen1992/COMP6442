package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.JSONException;
import org.json.JSONObject;

/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 */

public class ShoeSize_json {
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.xml";

	private Integer shoesize;

	public ShoeSize_json() throws IOException, JSONException {
		shoesize = null;
		load();
	}

	public String show() {
		return (shoesize == null ? "" : shoesize.toString());
	}

	public boolean set(Integer v) throws JSONException, IOException {
		if (v == null || v >= ShoeSize_json.SHOESIZEMIN
				&& v <= ShoeSize_json.SHOESIZEMAX) {
			shoesize = v;
			save();
			return true;
		} else {
			shoesize = null;
			return false;
		}
	}

	// ---------------------Approach: JSON---------------------------

	void save() throws JSONException, IOException {
		// add code here that will save shoe size into a file called "FILENAME"
		JSONObject jsonObj = new JSONObject();
		if (shoesize == null)
			return;
		jsonObj.put(SHOESIZEENAME, shoesize.toString());
		Writer w = new FileWriter("shoesize.json");
		jsonObj.write(w);
		w.close();
	}

	void load() throws IOException, JSONException {
		// add code here that will load shoe size from a file called "FILENAME"
		File f = new File("shoesize.json");
		if (!f.exists()) {
			return;
		}
		BufferedReader br = new BufferedReader(new FileReader(f));
		String s = br.readLine();
		JSONObject jsonObj = new JSONObject(s);
		br.close();
		shoesize = jsonObj.getInt(SHOESIZEENAME);
	}
}