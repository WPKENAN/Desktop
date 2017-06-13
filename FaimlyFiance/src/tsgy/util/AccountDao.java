/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.util;

import tsgy.model.AccountData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class AccountDao extends SqlHelper {
    	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
    
        public ResultSet getAccount(){
	try {
		String sql="select * from account_type";
		conn=this.openCon();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
            return rs;
	}
        public int addAccount(AccountData accountdata){
            int result=0;
            try{
                String sql="insert into account_type(name,balance) values(?,?)";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, accountdata.getname());
                ps.setString(2, accountdata.getbalance());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
        
            public int delAccount(AccountData accountdata){
            int result=0;
            try{
                String sql="delete from account_type where name=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, accountdata.getname());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
            public ResultSet queryAccount(AccountData accountdata){
            try{
                String sql="select * from account_type where name=? and balance=? and remark=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, accountdata.getbalance());
                ps.setString(2, accountdata.getbalance());
                rs=ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }return rs;
        }
            
        public int alterAccount(String n1,String n2,String se3,String s3){
            int i=0;
            try{
		String sql="update account_type set name='"+n2+"',balance='"+se3+"',remark='"+s3+"' where name='"+n1+"'";
		conn=this.openCon();
                ps=conn.prepareStatement(sql);
		i=ps.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
             return i;
        }}

    
