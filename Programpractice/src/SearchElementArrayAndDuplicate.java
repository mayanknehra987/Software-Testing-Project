import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchElementArrayAndDuplicate {
	// other program referance startseleniumpractive-prog.java
	public static void main(String[] args) {
        int[] array = {1, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int searchElement = scanner.nextInt();

        List<Integer> indices = new ArrayList<>();

        // Search for all indices
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchElement) {
                indices.add(i);
            }
        }

        // Print result
        if (indices.isEmpty()) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index/indices: " + indices);
        }

        scanner.close();
        
    }

}
