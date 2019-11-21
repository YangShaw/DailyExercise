package daily;
	
	interface Mini{
		abstract void print() ;
		abstract void tos();
	}

	class Base implements Mini{
		int i;
		Base(){
			add(1);
		}
		void add(int v) {
			i = i+v;
		}
		@Override
		public void print() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void tos() {
			// TODO Auto-generated method stub
			
		}
	}
	
	class Extension extends Base{
		Extension() {
			// TODO Auto-generated constructor stub
			add(2);
		}
		void add(int v) {
			i = i+v*2;
		}
	}
	
public class T {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Base b = new Extension();
		bogo(new Extension());
	}
	 static void bogo(Base b) {
		 b.add(8);
		 System.out.println(b.i);
	 }

}
