package Automation.startSeleniumPractice;

public class J{
	
	static int i=9;
	
	J(){
		i++;
		System.out.println(i);
	}
	public static void main(String[] args) {
		
		//System.out.println(i);
		J p = new J();
		p.m();
		A obj =new A();
		obj.sap();
		
	}
	
	static{
		i=4;
	}
	public void m(){
		i++;
		System.out.println(i);
	}
	

}
