package step2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestObjectOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p = new Person("백박사", "mc", "성남시 중원구");
		
		try {
			FileOutputStream fos = new FileOutputStream("/Users/ihyunju/Desktop/person.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
			System.out.println("객체 직렬화하여 파일에 저장");
			oos.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
