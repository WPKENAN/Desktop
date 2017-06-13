/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.util;
import tsgy.model.record_type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xhj
 */
public class Record_typeDao extends SqlHelper {
    	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
    
        public ResultSet getRecord_type(){
	try {
		String sql="select * from record_type";
		conn=this.openCon();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
            return rs;
	}
        public int addRecord_type(record_type memberdata){
            int result=0;
            try{
                String sql="insert into record_type(name,type) values(?,?)";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getName());
                ps.setString(2, memberdata.getType());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
        
            public int delRecord_type(record_type memberdata){
            int result=0;
            try{
                String sql="delete from record_type where name=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getName());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
            public ResultSet queryRecord_type(record_type memberdata){
            try{
                String sql="select * from record_type where name=? and type=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getName());
                ps.setString(2, memberdata.getType());
                rs=ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }return rs;
        }
            
        public int alterRecord_type(String n1,String n2,String se3){
            int i=0;
            try{
		String sql="update record_type set name='"+n2+"',type='"+se3+"' where name='"+n1+"'";
		conn=this.openCon();
                ps=conn.prepareStatement(sql);
		i=ps.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
             return i;
        }
}
