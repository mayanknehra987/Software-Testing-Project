package testing1;

public class Test_005 {
	static int age = 60;
	public static void main(String[] args) {
		
		if(age>=18 && age<=60) {
			System.out.println("Able To Vote" +age);
		}else if(age<=55){
			System.out.println("Not Able To Vote" + age);
		}else{
			System.out.println("Out of criteria" + age);
		}
		
	}
	

}
