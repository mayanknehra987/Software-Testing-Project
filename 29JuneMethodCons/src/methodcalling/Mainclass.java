package methodcalling;

public class Mainclass{

	public static void main(String[] args) {
		Subclass1 obj = new Subclass1();
		Subclass2 obj1 = new Subclass2();
		// Subclass2 obj2 = new Subclass2();

		obj.sum();
		int x = obj.sub(3, 8);
		obj.mul(x, 0);
	}
}
