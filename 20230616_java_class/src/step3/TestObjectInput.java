package step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import step2.Person;

public class TestObjectInput {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("/Users/ihyunju/Desktop/person.obj");
			//역직렬화하여 객체를 복원하기위한 프로세스 스트림을 생성
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person p = (Person)ois.readObject();
			System.out.println("객체 역직렬화하여 객체복원"+p);
			ois.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
