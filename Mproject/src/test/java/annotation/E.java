package annotation;

public class E {
	
	public static void main(String[] args) {
//		int arr[]={1,2,3,4,5};
//		int z=0;
//		for( int z  :  arr){
//			System.out.println(z);
//			
//		}
//		for(int i=0;i<=3;i++){
//			z=z+arr[i];
//		}
//		System.out.println(z);
		String s1 = "dfgwerwsewd";
		int count=0;
		
		for(int i=0;i<s1.length();i++){
			System.out.print(s1.charAt(i));
			char c=s1.charAt(s1.indexOf('e'));
			if(s1.charAt(i)==c){
				count = count+1;
			}
		}
		System.out.println(count);
		System.out.println(s1.length()-s1.replace("e", "").length());
	}

}
