package string;

public class Reverse_of_string {
		
		public static void main(String[] args) {
			  char c;
			  String s1 = "Hello World";
			  String s2 = "My mayank";
			  String s3 = "My Country";
			  System.out.println(s1.length());
			  for(int i=s1.length()-1;i>=0;i--) { 
				  c=s1.charAt(i);
				  System.out.print(c);
				  }
			  System.out.println(s2.concat(" " +s3));
			  System.out.println(s2+" "+s3);
			  System.out.println(s2.substring(2));
			  System.out.println(s3.substring(3, 4));   /// it will work on indexing and return less than 1 value from end string
		}	
}