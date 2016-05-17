
public class RecursiveProgram {

	public static void main(String[] args) {
		
		int num;
		
		num=sum(10);
		
		System.out.println(num);
		
	}
	
	public static int an(int n){
		return 3+(n-1)*7;
	}
	
	public static int sum(int n){
		if(n==1)
			return an(1);
		
		return sum(n-1)+an(n);
	}

}
