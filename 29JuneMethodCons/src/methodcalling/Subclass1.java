package methodcalling;

public class Subclass1 {
	
	int a=101;
	int b=15;
	
	public void sum() {
		int a=12; int b=14;
		int c=a+b;
		System.out.println(c);
	}
	public int sub(int a, int b) {
		int c= a+b;
		return c;
	}
	public void mul(int a, int b) {
		int c=a*b;
		System.out.println(c);
		if(c>0) {
			System.out.println("number is greater given number");
		}
		else if(c>=0 && c<=150) {
			System.out.println("number is ok");
		}
		else if(c<=150) {
			System.out.println("number is greater");
		}
		else {
			System.out.println(c);
		}
	}
}
//  10*20----200
//  number>0------number is lessthan given number
//  number50 is between 150 ----- number is ok
//  number<==200------ number is greater.