package com.woong.netio.multi.echo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClientProgram {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		
		
		try(Socket socket = new Socket("211.238.142.248",  10000)){
			
			OutputStream nos=socket.getOutputStream();
			InputStream nis= socket.getInputStream();
			
			PrintStream nout= new PrintStream(nos, true);
			Scanner nscan= new Scanner(nis);
			Scanner scan=new Scanner(System.in);
			String msg;
			
			do{
				msg=scan.nextLine();
				nout.println(msg);
				
				String echo=nscan.nextLine();
				System.out.println(echo);
			}while(!msg.equals("bye"));
			
			
			
			nout.close();
			nscan.close();
			
			
			nis.close();
			nos.close();			
			/*socket.setSoTimeout(15000);
			InputStream nin = socket.getInputStream();
			OutputStream nout = socket.getOutputStream();
			
			InputStream fin= new FileInputStream("d:\\test.jpg");
			
			for(int c=fin.read(); c!=-1; c=fin.read())
				nout.write(c);
			
			nout.flush();
			
			fin.close();
			nout.close();
			nin.close();
			System.out.println("파일 전송 완료");*/
			
		}catch(IOException ex){
			System.err.println("연결오류");
		}
		
		
		

	}

}
