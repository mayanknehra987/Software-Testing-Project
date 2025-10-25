package testing;

//Rule 1: whatever code we are going to write that must be inside class boundry.
//Rule 2: Class can have variable, constants, method/function, constructor.
//Rule 3: Otherthan variable and constants whatever code we gonna write that must be inside method boundry.
//Rule 4: To access any method inside we need object of class. 
public class Test_001 {
	
	static int a=12;
	static String b="mayank";
	public static void main(String[] args) {
		
		int c=9;
		System.out.println("Hello  =  " +c);
		Test_001 obj = new Test_001();
		obj.print1();
		
		
	}
	
	public void print() {
		
		System.out.println("Tis is the first method1");
	}
	public void print1() {
		System.out.println("Tis is the first method");

	}

	
	
	

}
