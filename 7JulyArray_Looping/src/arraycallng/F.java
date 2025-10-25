package arraycallng;

public class F {
	public static void main(String []args) {
		F obj = new F();
		obj.sortArray();
	}
	public void sortArray() {
		int tmp;
		int arr[] = {3,6,4,1,2,4,6};
		for (int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
			if(arr[i]<arr[j]) {
				tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
				
			}
			}
			System.out.println("Reverse of an array ->"  +arr[i]);
			//System.out.println("Sorting of an array ->"  +arr[i]);
		}
		}
}
