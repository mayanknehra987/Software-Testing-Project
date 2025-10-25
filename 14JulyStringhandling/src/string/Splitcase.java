package string;

public class Splitcase {
	
	public static void main(String[] args) {
		int count=0;
		String s1 = "Delhi is is capital of india";
		String [] arr = s1.split(" ");
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].equals("is")) {
				count++;
			//System.out.println("Found");
		}
	}
		System.out.println(count);
}
}