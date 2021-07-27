package daily;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestHomework {

    //等价类划分
    @Test
    public void testBoundaryInput() {
        final Scanner input = new Scanner(System.in);
        int b, c;
        b = BlackBoxTest.boundaryInput(input, "下界");
        c = BlackBoxTest.boundaryInput(input, "上界");
        //验证上界大于下界
        assertTrue((b < c));
        int a;
        a = BlackBoxTest.boundaryInput(input, "中值");
        //验证中值小于上界且大于下界
        assertTrue((a > c || a < b));
    }


    //边界值分析技术
    @Test
    public void testBoundaryChecking(){
        final Scanner input = new Scanner(System.in);
        int b=0, c=0;
        b = BlackBoxTest.boundaryInput(input, "下界");
        c = BlackBoxTest.boundaryInput(input, "上界");
        //验证上界是否大于最小值，下界是否小于最大值
        assertTrue((b - 1 != Integer.MAX_VALUE || c + 1 != Integer.MIN_VALUE));
    }

    //随机数生成
    @Test
    public void testRandomGenerate(){
        //输入一个测试值
        //final Scanner input = new Scanner(System.in);
        int left = 0, right = 0;
        //int d = input.nextInt();
        int d = 5;
        List<Integer> s = BlackBoxTest.randomGenerate2(d, left, right);
        //判断随机数数量是否相同
        System.out.println("equals");
        assertEquals(s.size(), d);
        //判断随机数数量是否重复
        boolean isRepeated = false;
        for(int x=0; x<s.size()-1;x++){
            for(int y=x+1; y< s.size()-1;y++){
                if(s.get(x)==s.get(y)){
                    isRepeated=true;
                    break;
                }
            }
            if(isRepeated){
                break;
            }
        }
        assertTrue(isRepeated);
    }
}
