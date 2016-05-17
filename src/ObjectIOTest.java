/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos= new FileOutputStream("res/Object.dat");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		
		oos.writeObject(new Integer(10));
		oos.writeObject(new Double(3.14));
		oos.writeObject(new int[]{1,2,3});
		oos.writeObject(new String("�����"));
		
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis= new FileInputStream("res/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Integer obj1= (Integer)ois.readObject();
		Double obj2= (Double)ois.readObject();
		//Double obj1= (Double)ois.readObject();
		//Integer obj2= (Integer)ois.readObject();
		int[] obj3= (int[])ois.readObject();
		String obj4=(String)ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3[0]+","+obj3[1]+","+obj3[2]);
		System.out.println(obj4);
		

	}

}
*/
import java.io.*;
public class ObjectIOTest {
    public static void main(String[] args) throws Exception {
/* ������ ��� �װ��� ��ü�� ����ȭ ���Ѽ� �����Ѵ�. */
// ���� ��� ��Ʈ���� ����. 
    FileOutputStream fos = new FileOutputStream("_imsi.txt");
// ��ü ��Ʈ���� ����, ��ü��Ʈ���� ���� ��ü�� ���Ͽ� ����
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(new SerializableClass("Serialize Test Program", 1004));
// ��Ʈ���� �ݴ´�. 
    oos.close();
/* ����ȭ �� ��ü�� ����� ���Ϸ� ���� ��ü�� �������� ������ ��ü�� ����*/
// ���� �Է� ��Ʈ�����κ��� ��ü �Է� ��Ʈ���� ����.
    FileInputStream fis = new FileInputStream("_imsi.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);
// ��ü �Է� ��Ʈ�����κ��� ��ü�� �о�´�.
    SerializableClass sc = (SerializableClass)ois.readObject();
// ��Ʈ���� �ݴ´�. 
    ois.close();
/* ��Ʈ�����κ��� �о���� ��ü�� ������ ��� ���� �����Ǿ��� ��ü�� ���� ���� ���´ٴ� ���� �˼��� �ִ�. */
    System.out.println("String : " + sc.mString);
    System.out.println("Integer : " + sc.mInt);
   }
}
/* �ϳ��� ���ڿ��� ������ �����ϰ��ִ� Ŭ����
Serializable�� implements �����ν� ��Ʈ���� ���� ����ȭ�ǰ� �����Ǿ����� �ִ�. */
class SerializableClass implements Serializable{
    public String mString;
    public int mInt;
// ������ 
    public SerializableClass(String s, int i) {
        this.mString = s;
        this.mInt = i;
    }
}
