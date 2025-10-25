package methodcalling;

public class D extends C{
	int a;
	public D() {
		super();
		System.out.println("child class cons");
	}
	public void print() {
		System.out.println("child class method");
	}
	public static void main(String[] args) {
		D obj = new D();
		obj.call();
	}
	public void call() {
		super.print(a);
		
	}
	

}
