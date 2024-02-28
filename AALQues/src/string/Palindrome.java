package string;

public class Palindrome {

	public static boolean checkPalindrome(String str) {
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i) !=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true; 
	}
	
	public static float getShortestpath(String str) {
		int x=0,y=0;
		for(int i=0;i<str.length();i++) {
			char dir=str.charAt(i);
			// south
			if(dir=='S') {
				y--;
			}
			// north
			else if(dir=='N') {
				y++;
			}
			// west
			else if(dir=='W') {
				x--;
			}
			// east
			else {
				x++;
			}
		}
		int x2=x*x;
		int y2=y*y;
		return (float) Math.sqrt(x2+y2);
	}
	public static void main(String[] args) {
		String str="racecar";
		String str2="WNEENESENNN";
		String fruits[]= {"mango","apple","banana"};
		String largest= fruits[0];
		for(int i=1;i<fruits.length;i++) {
			if(largest.compareTo(fruits[i])<0){
				largest=fruits[i];
			}
		}
		System.out.println(largest);
		System.out.println(str2.substring(0, 5));
		System.out.println(checkPalindrome(str));
System.out.println(getShortestpath(str2));
	}

}
