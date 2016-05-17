package com.woong.netio.multi.echo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EchoServerProgram {
	

	public static void main(String[] args) throws IOException {
		ServerSocket svrSocket = new ServerSocket(10000);
		boolean isRun = true;
		List<PrintStream> noutList= new ArrayList<>();
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

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
						
						readWriteLock.writeLock().lock();
						noutList.add(nout);
						readWriteLock.writeLock().unlock();
						
						
						Scanner nscan = new Scanner(nis);

						String msg;

						do {

							msg = nscan.nextLine();
							System.out.println(socket.getRemoteSocketAddress()+" : "+msg);

							readWriteLock.readLock().lock();
							for(PrintStream nps : noutList)
								nps.println("echo: " + msg);
							readWriteLock.readLock().unlock();

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

}
