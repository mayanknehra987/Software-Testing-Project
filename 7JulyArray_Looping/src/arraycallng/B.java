package arraycallng;

public class B {
	public static void main(String[] args) {
		B obj = new B();
		obj.checkPrimeNumber(5);
	}
	int num;
	public void checkPrimeNumber(int num) {
		int [] arr = {4,5,1,5,8,6,5,3};
		 for(int i=0;i<arr.length;i++) { 
			 if(arr[i]%2==0) {
				 System.out.println("given number is prime number---->" + arr[i]); 
			}else {
				 System.out.println("given number is not prime number---->" + arr[i]); 
				 }
			}
		 
		if(num%2==0) {
			System.out.println("given number is prime number---->" + num);
		}else {
			System.out.println("given number is not prime number---->" + num);
		}
		
	}

}
