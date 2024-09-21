package in.vinay;

public class MultiplyVargs {
	public static void main(String[] args) {
		mult(20,30);
		mult(20,40);
		mult(20,50);
	}
	
	public static void mult(int... num) {
		int total=1;
		for(int i=0;i<num.length;i++) {
			total*=num[i];
		}
		System.out.println(total);
	}
}
