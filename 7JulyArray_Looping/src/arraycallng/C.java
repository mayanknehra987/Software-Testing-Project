package arraycallng;

public class C {
	
	public static void main(String[] args) {
		C obj = new C();
		obj.sumOfArray();
	}
	public void sumOfArray() {
		int sum=0;
		int arr[]= {3,9,0,2,5,3,6};
		for(int i=0;i<3;i++) {
			sum=sum+arr[i];
			System.out.println(arr);
		}
		System.out.println(arr);
		System.out.println("Sum of first 3 number is ->" +sum);
	}

}
