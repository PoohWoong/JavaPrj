package com.woong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		//String sql="SELECT * FROM MEMBER WHERE MID LIKE '����%'";
		String sql;
		Scanner scan=new Scanner(System.in);
		
		String mid;
		String name;
		String age;
		
		System.out.printf("\t[ȸ�� �˻� ���α׷�]\n");
		System.out.print("�̸� �˻��� �Է�: ");
		String keyword= scan.next();
		
		sql="SELECT * FROM MEMBER WHERE NAME LIKE \'%"+keyword+"%\'";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(sql);
		System.out.printf("���̵�\t%6s\t����\n", "�̸�");
		while(rs.next()){ //�������� ���ڵ� �ϳ� ������
			
			mid=rs.getString("MID");
			name=rs.getString("Name");
			age=rs.getString("Age");
			
			
			System.out.printf("%s\t%6s\t%s\n", mid, name, age);
		}
	}

}
