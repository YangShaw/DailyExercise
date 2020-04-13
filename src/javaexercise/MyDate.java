package javaexercise;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {

    private int year;
    private int month;
    private int day;

    //	������ǰ���ڵ�Date����
    public MyDate() {
        Calendar cal = Calendar.getInstance();
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH);
        this.day = cal.get(Calendar.DATE);

    }

    //	�������ź���������Date����
    public MyDate(long ms) {
        this.setDate(ms);

    }

    //	����ָ���������մ���Date����
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(long elapsedTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String target = sdf.format(new Date(elapsedTime));
        String[] dateArray = target.split("-");
        this.year = Integer.parseInt(dateArray[0]);
        this.month = Integer.parseInt(dateArray[1]);
        this.day = Integer.parseInt(dateArray[2]);
    }


    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


}
