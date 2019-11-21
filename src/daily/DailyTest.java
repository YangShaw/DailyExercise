package daily;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long msec = 34355555133101L;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String date = sdf.format(new Date(msec));
		System.out.println(date);
	}

}
