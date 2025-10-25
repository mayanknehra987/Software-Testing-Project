package arraycallng;

public class E {
	public static void main(String[] args) {
		E obj = new E();
		obj.duplicateValue();
	}
	
	public void duplicateValue() {
		int x=0; int t=0;
		int arr[] = {3,6,4,4,9,6,7,6,7,3};
		for(int i=0;i<=arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
				//t = arr[i];
				System.out.println("Duplicate element in Array ->" +arr[j]);
			}
			}
		}
	}
}
