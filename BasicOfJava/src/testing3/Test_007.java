package testing3;

public class Test_007 {
	
	final int Totalmarks = 10;
			int marks = 20;
	  
	  public void Hello() {
		//Totalmarks=9;												can not assign/increment value to final keyword
		  marks=30;
		System.out.println("Hello marks =" + marks);
		System.out.println(marks);
	}
}
