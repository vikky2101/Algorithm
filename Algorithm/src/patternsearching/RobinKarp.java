package patternsearching;

public class RobinKarp {

	public static void main(String[] args) {
		String txt = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		int q = 101; // A prime number
		robinKarpsearch(pat, txt, q);

	}

	private static void robinKarpsearch(String pattern, String txt, int q) {
		int txtLen = txt.length();
		int patLen = pattern.length();
		int d = 256;
		int h = 1;
		int p = 0;
		int t = 0;
		for (int i = 0; i < patLen; i++) {
			h = (h * d) % q;
		}
		for (int i = 0; i < patLen; i++) {
			t = (d * t + txt.charAt(i)) % q;
			p = (d * p + pattern.charAt(i)) % q;
		}
		for(int i = 0 ; i <= txtLen-patLen; i++){
			if(t == p){
				int j = 0;
				for(j = 0; j<patLen; j++){
					if(txt.charAt(i) != pattern.charAt(j))
						break;
				}
				if(j == patLen){
					System.out.println("Pattern found at index"+i);
				}
			}
			if(i < txtLen){
				t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+patLen))%q;
				if(t<0)
					t = t + q;
			}
		}

	}

}
