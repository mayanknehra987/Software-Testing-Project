package privatemodifiers;

public class B {
	  
		 public static void main(String args[]){  
		   A obj=new A();  
		   //obj.setData(888);
		   obj.setData(12, false);
		  System.out.println(obj.getData());
		   
		  // System.out.println(obj.data);//Compile Time Error  
		  // obj.msg();//Compile Time Error  
		   }
	}


