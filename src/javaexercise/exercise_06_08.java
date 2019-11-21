package javaexercise;
import java.text.DecimalFormat;
import java.util.*;
public class exercise_06_08 {
	static DecimalFormat df1 = new DecimalFormat("0.0");
	static DecimalFormat df2 = new DecimalFormat("0.00");
	public static double celsiusToFahrenheit(double celsius) {
		return Double.parseDouble(df1.format((9.0/5)*celsius+32));
	}
	
	public static double fahrenheitToCelsius(double fahrenheit){
		return Double.parseDouble(df2.format((5.0/9)*(fahrenheit-32)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] celsiusArr = {40.0, 39.0, 32.0, 31.0};
		double[] fahrenheitArr = {120.0, 110.0, 40.0, 30.0};
		System.out.println("摄氏度\t华氏度\t\t华氏度\t摄氏度");
		double celStart = 40;
		double faStart = 120;
		for(int i=0;i<10;++i) {
			System.out.println((celStart-i)+"\t"+celsiusToFahrenheit(celStart-i)+
					"\t\t"+(faStart-i*10)+"\t"+fahrenheitToCelsius(faStart-i*10));
		}
		
		
	}

}
