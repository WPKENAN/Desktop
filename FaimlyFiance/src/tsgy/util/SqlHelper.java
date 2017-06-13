/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 15CR-1528LL
 */
public class SqlHelper {
 	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/tsjy";
	private static final String USER="root";
	private static final String PWD="root";
	public Connection openCon(){
	Connection conn=null;
     try {      //加载驱动
		Class.forName(DRIVER);
		//获取连接
		conn=DriverManager.getConnection(URL,USER,PWD);
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
     
	return conn;
}

        //释放资源
	public void closeCon(Connection conn,PreparedStatement ps,ResultSet rs){
			try {
				if(conn!=null)conn.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
	}
}
