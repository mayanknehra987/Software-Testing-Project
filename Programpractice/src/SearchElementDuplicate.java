
	
	import java.util.Scanner;

	public class SearchElementDuplicate {
	    public static void main(String[] args) {
	        int[] array = {91, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9,6};

	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the element to search: ");
	        int target = scanner.nextInt();
	        boolean found = false;

	        System.out.print("Element found at index: ");
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] == target) {
	                System.out.print(i + " ");
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("Element not found");
	        }

	        scanner.close();
	    }
	}



