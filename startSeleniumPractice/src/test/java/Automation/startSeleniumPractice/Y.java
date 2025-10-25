package Automation.startSeleniumPractice;

public class Y extends T {
	//
	// int i=9;
	static int arr[] = { 3, 5, 6, 3, 4, 5, 6, 2 };
static int count;
	public static void main(String[] args) {

		// T obj = new Y();
		po obj = new po();
		obj.sum1(4, 6);
		for (int i = 2; i <= 11; i++) {
			System.out.print((i * 2) - 2 + ",");

		}
		System.out.println("--------------*----------------");
		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == 3) {
//				count++;
//				System.out.println(arr[i]);
//			}
			if (arr[i]%2 == 0) {
				//count++;
				System.out.println("number is prime"+arr[i]);
			}else{
				System.out.println(arr[i]);
			}
			
		}
		System.out.println("number of 3 occurance in array is = "+ count);
		System.out.println("--------------*----------------");
		System.out.println(arr[5]);
	}
}
