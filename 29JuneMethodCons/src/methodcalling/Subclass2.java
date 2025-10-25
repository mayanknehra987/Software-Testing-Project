package methodcalling;

public class Subclass2 {
	
	static int i=3;
	public Subclass2() {
		i++;
		System.out.println(i);
		System.out.println("This is constructor");
	}
	public Subclass2(int a) {
		System.out.println("This is parameterized constructor"+ "  ->   " +a);
	}
	public Subclass2(int a, int b) {
		int c=a+b;
		System.out.println(c);
		System.out.println("This is parameterized constructor"+ "  ->   " +a +b);
	}
}
