package privatemodifiers;

public class A {
	private int data=40;  
	private void msg(){
		System.out.println("Hello java");
	}
	public int getData(){
		return data;
	}
	

	public void setData(int a , boolean isAuth){
		if(isAuth){
			data=a;
			
		}
		else{
			System.out.println("not allowed");
		}
		
	}

}
//Note: A class cannot be private or protected except nested class


//Role of Private Constructor
//If you make any class constructor private, you cannot create the instance of that class from outside the class. For example:
//private A() //private constructor
//{}  
//void msg(){
//	System.out.println("Hello java");}  
//}  
//public class Simple{ 
//	
//
// public static void main(String args[]){  
//   A obj=new A();//Compile Time Error  
// }
//}
