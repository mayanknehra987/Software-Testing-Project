package arraycallng;

public class A {
	public static void main(String[] args) {
		A obj = new A();
		obj.data();
	}
	public void data() {
		int t=0; int z=0;
		int arr[] = {3,1,6,9,1,4,67,6,9,9,4,4};
		int x=arr.length;
		for(int i=0;i<x;i++) {
			
			if(arr[i]==1) {
				 t++;
			}else if(arr[i]==4){
				z++;
				/*
				 * if(i==arr.length-1)
				 * System.out.println("Check any value is there if yes print count is ->" +z);
				 */
			}
	
		}
		System.out.println("Check any value is there if yes print count 4 is ->" +z);
		System.out.println("Check any value is there if yes print count 1 is ->" +t);
	}
	
	

}
