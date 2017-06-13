/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.util;
import tsgy.model.member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xhj
 */
public class Mem extends SqlHelper {
    	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
    
        public ResultSet getMember(){
	try {
		String sql="select * from member";
		conn=this.openCon();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
            return rs;
	}
        public int addMember(member memberdata){
            int result=0;
            try{
                String sql="insert into member(name,sex) values(?,?)";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getname());
                ps.setString(2, memberdata.getsex());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
        
            public int delMember(member memberdata){
            int result=0;
            try{
                String sql="delete from member where name=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getname());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
            public ResultSet queryMember(member memberdata){
            try{
                String sql="select * from member where name=? and sex=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getname());
                ps.setString(2, memberdata.getsex());
                rs=ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }return rs;
        }
            
        public int alterMember(String n1,String n2,String se3){
            int i=0;
            try{
		String sql="update member set name='"+n2+"',sex='"+se3+"' where name='"+n1+"'";
		conn=this.openCon();
                ps=conn.prepareStatement(sql);
		i=ps.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
             return i;
        }
}
