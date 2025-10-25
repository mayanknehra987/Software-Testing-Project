package Automation.startSeleniumPractice;

public class ReverseArray {
	public static void main(String[] args) {
        // Original array
        int[] numbers = {10, 20, 30, 40, 50};

        // Print original array
        System.out.print("Original array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // Reverse the array
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }

        // Print reversed array
        System.out.print("\nReversed array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
}
}
