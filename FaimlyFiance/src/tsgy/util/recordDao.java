/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.util;

import tsgy.model.record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xhj
 */
public class recordDao extends SqlHelper {
    	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
    
        public ResultSet getRecord(){
	try {
		String sql="select * from record";
		conn=this.openCon();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
            return rs;
	}
        public int addRecord(record memberdata){
            int result=0;
            try{
                String sql="insert into record(type,record_type,account_type,member,remark,sum,rdate) values(?,?,?,?,?,?,?)";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getType());
                ps.setString(2, memberdata.getRecord_type());
                ps.setString(3, memberdata.getAccount_type());
                ps.setString(4, memberdata.getMember());
                ps.setString(5, memberdata.getRemark());
                ps.setString(6, memberdata.getSum());
                ps.setString(7, memberdata.getRdate());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
        
            public int delRecord(record memberdata){
            int result=0;
            try{
                String sql="delete from record where type=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getType());
                result=ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }return result;
        }
            public ResultSet queryRecord(record memberdata){
            try{
                String sql="select * from record where name=? and sex=?";
                conn=this.openCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, memberdata.getType());
                ps.setString(2, memberdata.getRecord_type());
                ps.setString(3, memberdata.getAccount_type());
                ps.setString(4, memberdata.getMember());
                ps.setString(5, memberdata.getRemark());
                 ps.setString(6, memberdata.getSum());
                ps.setString(7, memberdata.getRdate());
                rs=ps.executeQuery();
            }catch(SQLException e){
                e.printStackTrace();
            }return rs;
        }
            
        public int alterRecord(String n1,String n2,String n3,String n4,String n5,String n6,String n7,String n8){
            int i=0;
            try{
		String sql="update record set type='"+n2+"',record_type='"+n3+"',account_type='"+n4+"',member='"+n5+"',remark='"+n6+"',sum='"+n7+"',rdate='"+n8+"' where member='"+n1+"'";
		conn=this.openCon();
                ps=conn.prepareStatement(sql);
		i=ps.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
             return i;
        }
}

