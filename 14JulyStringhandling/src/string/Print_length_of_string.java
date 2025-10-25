package string;

public class Print_length_of_string {
	String s1 = "Hello World m";
	public static void main(String[] args) {
		String s2 = "HELLO WORLD";
		String s1 = "Hello World";
		//System.out.println(s1.length());
		System.out.println(s1);
		System.out.println(s1.toUpperCase());
		System.out.println(s2.toLowerCase());
		int count=0;
		for(int i=0; i<s1.length();i++) {
			count = count+1;
		}
		System.out.println(count);
		
	}

}
