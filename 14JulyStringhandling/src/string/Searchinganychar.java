package string;

public class Searchinganychar {
	
	public static void main(String[] args) {
		 int count =0;
		 String s1 = "practice of program practice";				//20
		 for(int i=0;i<s1.trim().length();i++) {
			 char s2 =s1.charAt(s1.indexOf('a'));
			 if(s1.charAt(i)==s2) {
				 count++;
			// System.out.println("Search ch is->" +s2);
			 }
			 
		 }
		 System.out.println("Occurance ch is->" +count);
		 System.out.println(s1.length()-s1.replace("p", "").length());
	}

}
