package leetcode;

class B {
    public void p(double i) {
        System.out.println(i * 2);
    }


}

class A extends B {
    public void p(double i) {
        System.out.println(i);
    }
}

public class MoveZeroes {
    public static void main(String[] args) {
        B a = new A();
        a.p(10);
        a.p(10.0);
        //	����A��д�˷���p����̬���ӣ���������ķ���
    }
//	public void moveZeroes(int[] nums) {
//		int pos = 0;
//		int l = nums.length;
//		for(int i=0;i<l;++i) {
//			if(nums[i]!=0) {
//				nums[pos] = nums[i];
//				pos++;
//			}
//		}
//		for(int i=pos;i<l;++i) {
//			nums[i] = 0;
//		}
//		
//	}


}
