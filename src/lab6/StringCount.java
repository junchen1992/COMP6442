package lab6;

/**
 * Broken program for counting the occurrences of one string in
 * another.
 *
 * Original C version written by Jim Grundy, 2000.
 * Eiffel version written by Ian Barnes, 2001.
 * Java version written by Ian Barnes, 2005.
 */
class StringCount {

    /**
     * The number of occurrences of one string in another.
     * @param s The needle we're looking for.
     * @param t The haystack we're searching in.
     */
    public static int count(String s, String t) {
	int result = 0;
	int i = 0;
	while (i < t.length() - s.length()) {
	    i++;
	    int j = 1;
	    while (j < s.length() && 
		   i+j < t.length() && 
		   s.charAt(j) == t.charAt(i + j)) {
		j++;
	    }
	    if (j >= s.length()) {
		result++;
	    }
	}
	return result;
    }
    
    public static int count2(String s, String t) {
    	int result = 0;
    	int i = 0;
    	while (i <= t.length() - s.length()) {
    		int j = 0;
    		while(j < s.length() && s.charAt(j) == t.charAt(i + j)) {
    			j++;
    		}
    		if(j >= s.length() - 1) {
    			result++;
    		}
    		i++;
     	}
    	return result;
    }
    
    

    /** Read command-line arguments and call strcnt(). */   
    public static void main(String[] args) {
	/*if (args.length != 2) {
	    System.err.println("Usage: java StringCount string1 string2");
	} else {
	    System.out.println(count2(args[0], args[1]));
	}*/
    	
    	System.out.println(count2("abca", "ababcabcabca"));
    }
}
