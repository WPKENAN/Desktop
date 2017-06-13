/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.util;

import tsgy.model.budget;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class budgetDao extends SqlHelper {
    	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
    
        public ResultSet getBudget(){
	try {
		String sql="select * from budget";
		conn=this.openCon();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
            return rs;
	}
        public int addBudget(budget accountdata){
            int result=0;
            try{
                String sql="insert into budget(name,sum,bdate) values(?,?,?)";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, accountdata.getName());
                ps.setString(2, accountdata.getSum());
                ps.setString(3, accountdata.getBdate());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
        
            public int delBudget(budget accountdata){
            int result=0;
            try{
                String sql="delete from budget where name=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, accountdata.getName());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
            public ResultSet queryBudget(budget accountdata){
            try{
                String sql="select * from budget where name=? and sum=? and bdate=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                 ps.setString(1, accountdata.getName());
                ps.setString(2, accountdata.getSum());
                ps.setString(3,  accountdata.getBdate());
                rs=ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }return rs;
        }
            
        public int alterBudget(String n1,String n2,String se3,String s3){
            int i=0;
            try{
		String sql="update budget set name='"+n2+"',sum='"+se3+"',bdate='"+s3+"' where name='"+n1+"'";
		conn=this.openCon();
                ps=conn.prepareStatement(sql);
		i=ps.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
             return i;
        }}

    

