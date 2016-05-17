package com.woong.netio.multi.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class ChatClientWindow extends JFrame implements Runnable{

	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu miExit;
	private JMenu mnTool;
	private JMenuItem miConnect;

	private JButton btnSend;
	private JTextArea textInput;
	private JPanel panel = new JPanel();
	private JTextArea textOutput;
	
	private Socket socket;
	private PrintStream nout;
	private Scanner nscan;

	public ChatClientWindow() {
		setSize(800, 600);
		getContentPane().setBackground(Color.CYAN);
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		mnTool = new JMenu("Tool");
		miExit = new JMenu("Exit");
		miConnect = new JMenuItem("Connect");
		miConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket("211.238.142.105", 10000);
					if(socket.isConnected()){
						textOutput.setText("Connected to ");
						
						InputStream is=socket.getInputStream();
						OutputStream os=socket.getOutputStream();
						
						nout=new PrintStream(os, true);
						nscan =new Scanner(is);
						
						new Thread(ChatClientWindow.this).start();
					}
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		mnFile.add(miExit);
		mnTool.add(miConnect);
		menuBar.add(mnFile);
		menuBar.add(mnTool);

		setJMenuBar(menuBar);

		panel.setLayout(new BorderLayout());

		textOutput = new JTextArea();
		textOutput.setPreferredSize(new Dimension(100, 100));
		this.add(textOutput, BorderLayout.CENTER);
		textOutput.setEditable(false);

		textInput = new JTextArea();
		textInput.setPreferredSize(new Dimension(100, 100));
		textInput.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		panel.add(textInput, BorderLayout.CENTER);

		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// textOutput.append(textInput.getText()+"\n");
				String msg = textOutput.getText();
				if (msg.isEmpty())
					msg += textInput.getText();
				else
					msg += "\n" + textInput.getText();
				nout.println(textInput.getText());
				textOutput.setText(msg);
				textInput.setText("");

			}
		});

		textInput.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}
			


			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (e.getModifiers() & KeyEvent.SHIFT_MASK) != 0) {
					textInput.setText(textInput.getText() + "\n");
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER);
//					textInput.setText("");
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (e.getModifiers() & KeyEvent.SHIFT_MASK) != 0) {

				} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String msg = textOutput.getText();
					if (msg.isEmpty())
						msg += textInput.getText();
					else
						msg += "\n" + textInput.getText();
					textOutput.setText(msg);
					nout.println(textInput.getText());
					textInput.setText("");
				}

			}
		});
		panel.add(btnSend, BorderLayout.LINE_END);

		this.add(panel, BorderLayout.PAGE_END);

	}

	@Override
	public void run() {
		while(true){
			String msg=nscan.nextLine();
			textOutput.setText(msg);
		}
		
	}

}
