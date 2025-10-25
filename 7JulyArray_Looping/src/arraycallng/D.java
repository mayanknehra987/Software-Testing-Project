package arraycallng;

public class D {
	public static void main(String[] args) {
		D obj = new D();
		obj.checkOddNumber();
	}
	public void checkOddNumber() {
	//	int arr1=0;
		int []arr = new int[101];
		for(int i=0;i<101;i++) {
			arr[i]=i;
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2!=0) {
				System.out.println("The odd number is-->" +i);
			}
		}
	}
	
}
