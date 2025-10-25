
package Automation.startSeleniumPractice;

public class Duplicateinarray {
	public static void main(String[] args) {
        int[] array = {2, 4, 4, 3, 6, 7, 5, 6};
        System.out.println("Duplicate elements:");

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                    break; // Break inner loop once duplicate is found
                }
            }
        }
    }

}
