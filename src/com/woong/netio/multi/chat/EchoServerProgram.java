package com.woong.netio.multi.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EchoServerProgram {
    public static void main(String[] args) throws IOException{
		
    ReadWriteLock readWriteLock = 
                                     new ReentrantReadWriteLock();
		
    List<PrintStream> nouts = new ArrayList<>();
    
    boolean isRunning = true;		
    ServerSocket svrSock = new ServerSocket(10000);
		
    System.out.println("listening...");
		
    while(isRunning){
        Socket sock = svrSock.accept();        
        System.out.println("connected from " 
                                       + sock.getRemoteSocketAddress());
			
        new Thread(new Runnable() {
            public void run() {			
                Socket socket = sock;
                OutputStream nos;
                InputStream nis;
					
                try {					 
                    nos = sock.getOutputStream();
                    nis = sock.getInputStream();
					    
                    PrintStream nout = new PrintStream(nos, true);
                    Scanner nscan = new Scanner(nis);

                    readWriteLock.readLock().lock();	
                    nouts.add(nout);                    
                    readWriteLock.readLock().unlock();

                    Scanner scan = new Scanner(System.in);				

                    String msg;
                    do{
                        msg = nscan.nextLine();
                        System.out.println(msg);
		
                        for(PrintStream ps : nouts)
                            ps.println("echo : " + msg);
                    }while(!msg.equals("bye"));
					
                    nout.close();
                    nscan.close();
						
                    nis.close();
                    nos.close();
						
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();						
                }				
            }
        }).start();
    }

    svrSock.close();
						
    }
}


/*import java.io.FileOutputStream;
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
		boolean isRun = true;

		System.out.println("Listenning......");

		while (isRun) {
			Socket socket = svrSocket.accept();
			System.out.println("connected from " + socket.getRemoteSocketAddress());

			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						InputStream nis = socket.getInputStream();
						OutputStream nos = socket.getOutputStream();

						PrintStream nout = new PrintStream(nos, true);
						Scanner nscan = new Scanner(nis);

						String msg;

						do {

							msg = nscan.nextLine();
							System.out.println(socket.getRemoteSocketAddress()+" : "+msg);

							nout.println("echo: " + msg);

						} while (!msg.equals("bye"));

						nscan.close();
						nout.close();
						nos.close();
						nis.close();
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			}).start();
			

		}

	}

}*/
