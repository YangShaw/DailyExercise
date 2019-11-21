package daily;

import java.io.*;

public class TestSeri {

	public static void main(String[] args) {
		File file = new File("d:\\first.user");
		try {
	
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			User user1 = new User();
			user1.setId(10001);
			user1.setName("pku");
			user1.setPassword("2019");
			oos.writeObject(user1);
			System.out.println("write finished");
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			User user2 = (User)ois.readObject();
			System.out.println("read finished");
			System.out.println(user2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
