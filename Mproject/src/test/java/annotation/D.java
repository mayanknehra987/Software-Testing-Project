package annotation;

public class D {
	
	public static void main(String[] args) {	
		String[] arr = {"abcd"};

        // Extract the string at index 0
        String value = arr[0];

        // Convert the string to a character array
        char[] charArray = value.toCharArray();

        // Print the character array
//        for(int i=(charArray.length)-1;i>=0;i--){
//        	 System.out.println(charArray[i]);
//        }
//        System.out.println("Character array:");
        for (char c : charArray) {
            System.out.print(c + ",");
        }
	}

}
