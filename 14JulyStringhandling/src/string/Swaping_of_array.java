package string;

public class Swaping_of_array {
	
	public static void main(String[] args) {
		int tmp,tmp1=0;
		int arr[] = {7,2,3,9,5,6,7,2};
		int arr1[] = {1,2,3,4,5,6,7,8,9,0};
		 for(int i=0;i<arr.length;i++) { 
			 for(int j=i+1;j<arr.length;j++) {
				 if(arr[i]>arr[j]) { 
					 tmp = arr[i]; 
					 arr[i]=arr[j]; 
					 arr[j]=tmp; 
					// break;
					 } 
				 }
		 
			 	System.out.print(arr[i] + "   "); 
			}
		  for(int j=arr1.length-1;j>=0;j--) { 
			  tmp1=arr1[j];
		  System.out.print(tmp1); }
		
	}

}
