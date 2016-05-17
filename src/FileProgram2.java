import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProgram2 {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("res/images/kei.bmp");
//		FileOutputStream fos = new FileOutputStream("res/images/kei-copy.bmp");
/*
		byte[] buf=new byte[1024];
		int size;
		
		while((size=fis.read(buf))!=-1)
			fos.write(buf,0, size);
		
		*/
		fis.read();
		fis.read();
		byte[] buf = new byte[4];
		
		buf[0]=(byte)fis.read();
		buf[1]=(byte)fis.read();
		buf[2]=(byte)fis.read();
		buf[3]=(byte)fis.read();
				
		int num=((int)buf[0]&0xff )|((int)buf[1]&0xff )<<8|((int)buf[2]&0xff )<<16|((int)buf[3]&0xff )<<24;
		
		//int num= buf[0]+buf[1]*256+buf[2]*65536;
		System.out.println(num);
		fis.read(buf);
		fis.read(buf);
		fis.read(buf);
		fis.read(buf);
		int width=((int)buf[0]&0xff )|((int)buf[1]&0xff )<<8|((int)buf[2]&0xff )<<16|((int)buf[3]&0xff )<<24;
		fis.read(buf);
		int height=((int)buf[0]&0xff )|((int)buf[1]&0xff )<<8|((int)buf[2]&0xff )<<16|((int)buf[3]&0xff )<<24;
		
		System.out.println(width);
		System.out.println(height);
		
		/*int n;
		while((n=fis.read())!=-1)
			fos.write(n);
		
		fos.close();*/
		fis.close();

	}

}
