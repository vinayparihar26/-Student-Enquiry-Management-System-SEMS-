package in.vinay;

public class SumVargs {
	
	public static void main(String[] args) {
		sum(10, 20);
		sum(10, 20, 30);
		sum(10, 20, 30, 40);
		sum(10, 20, 60);
	}
		public static void sum(int... a) {
		int total=0;
		for(int i=0;i<a.length;i++) {
			total+=a[i];
		}
		System.out.println(total);
	}
}
