package com.woong.netio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerProgram {

	public static void main(String[] args) throws IOException {
		ServerSocket svrSocket = new ServerSocket(10000);
		
		
		
		String msg;
	
		System.out.println("Listenning......");			
		Socket socket = svrSocket.accept();
		InputStream nis= socket.getInputStream();
		OutputStream nos = socket.getOutputStream();
		
		PrintStream nout= new PrintStream(nos, true);
		Scanner nscan=new Scanner(nis);
	
		System.out.println("connected from " + socket.getRemoteSocketAddress());
		
		do {

			msg=nscan.nextLine();
			System.out.println(msg);
			
			nout.println("echo: "+ msg);
			
		}while(!msg.equals("bye"));
		
		nout.close();
		nos.close();
		nis.close();
		socket.close();
		
		

	}

}
