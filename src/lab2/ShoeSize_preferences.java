package lab2;

import java.util.prefs.Preferences;

/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 */

public class ShoeSize_preferences {
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.xml";

	private Integer shoesize;

	public ShoeSize_preferences() {
		shoesize = null;
		load();
	}

	public String show() {
		return (shoesize == null ? "" : shoesize.toString());
	}

	public boolean set(Integer v) {
		if (v == null || v >= ShoeSize_preferences.SHOESIZEMIN && v <= ShoeSize_preferences.SHOESIZEMAX) {
			shoesize = v;
			save();
			return true;
		} else {
			shoesize = null;
			return false;
		}
	}

	// ---------------------Approach: Java Preferences
	// System---------------------------

	void save() {
		// add code here that will save shoe size into a file called "FILENAME"
		Preferences pre = Preferences.userNodeForPackage(ShoeSize_preferences.class);
		if (shoesize == null) {
			return;
		}
		pre.putInt(SHOESIZEENAME, shoesize);
	}

	void load() {
		// add code here that will load shoe size from a file called "FILENAME"
		Preferences pre = Preferences.userNodeForPackage(ShoeSize_preferences.class);
		shoesize = pre.getInt(SHOESIZEENAME, 0);
	}
}