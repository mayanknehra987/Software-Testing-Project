package Automation.startSeleniumPractice;

public class Duplicateinstring {
	 public static void main(String[] args) {
	        String str = "mayank";
	        char[] chars = str.toCharArray();

	        System.out.println("Duplicate characters:");
	        for (int i = 0; i < chars.length; i++) {
	            for (int j = i + 1; j < chars.length; j++) {
	                if (chars[i] == chars[j]) {
	                    System.out.println(chars[i]);
	                    break; // break inner loop after finding first duplicate
	                }
	            }
	        }
	    }

}
