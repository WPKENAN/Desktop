/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.view;

import tsgy.util.recordDao;
import tsgy.model.record;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tsgy.model.member;

/**
 *
 * @author xhj
 */
public class Record extends JFrame
{
    JPanel panel1,panel2;
    JButton b1=new JButton("添加");
    JButton b2=new JButton("删除");
    JButton b3=new JButton("列表");
    JButton b4=new JButton("查询");
    JButton b5=new JButton("修改");
    JLabel label1=new JLabel("账目类型");
    JLabel label2=new JLabel("账目类别");
    JLabel label3=new JLabel("账户类型");
    JLabel label4=new JLabel("家庭成员");
    JLabel label5=new JLabel("备注");
    JLabel label6=new JLabel("金额");
    JLabel label7=new JLabel("日期");
   JTextField t1=new JTextField(20);
    JTextField t2=new JTextField(20);
     JTextField t3=new JTextField(20);
    JTextField t4=new JTextField(20);
     JTextField t5=new JTextField(20);
    JTextField t6=new JTextField(20);
     JTextField t7=new JTextField(20);
    JTable table=null;
    ResultSet rs=null;
   recordDao recorddao=new recordDao();
        
    public Record() {
        this.setLayout(new FlowLayout());
        this.setSize(600,600);
           Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();   
          Dimension   framesize   =   this.getSize();
          int   x   =   (int)screensize.getWidth()/2   -   (int)framesize.getWidth()/2;   
          int   y   =   (int)screensize.getHeight()/2   -   (int)framesize.getHeight()/2;   
          this.setLocation(x,y);   
          this.setVisible(true);   
       
        Object[][] playerInfo={
                 //创建表格中的数据
	};
	String[] Names={"ID","Type","Record Type","Account Type","Member","Remark","Sum","Rdate"};//创建表格中的横标题
        final DefaultTableModel dtm=new DefaultTableModel(playerInfo,Names);//创建一个默认的表格模型
	table=new JTable(dtm);//以模型中的数据为参数，创建一个表格
	table.setPreferredScrollableViewportSize(new Dimension(600,300));//  设置此表视口的首选大小
        JScrollPane scrollPane=new JScrollPane(table);//将表格加入到滚动条组件中
	
        panel1=new JPanel(new GridLayout(7,7));
        panel1.add(label1);
        panel1.add(t1);
        panel1.add(label2);
        panel1.add(t2);
        panel1.add(label3);
        panel1.add(t3);
        panel1.add(label4);
        panel1.add(t4);
        panel1.add(label5);
        panel1.add(t5);
        panel1.add(label6);
        panel1.add(t6);
        panel1.add(label7);
        panel1.add(t7);
        panel2=new JPanel();
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b4);
        panel2.add(b5);
        this.getContentPane().add(scrollPane,BorderLayout.NORTH);
        this.getContentPane().add(panel1,BorderLayout.CENTER );
        this.getContentPane().add(panel2, BorderLayout.SOUTH);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            String ftype=t1.getText();
            String frecord_type=t2.getText();
            String faccount_type=t3.getText();
            String fmember=t4.getText();
            String fremark=t5.getText();
            String fsum=t6.getText();
            String frdate=t7.getText();
            record md = new record(ftype,frecord_type,faccount_type,fmember,fremark,fsum,frdate);
            int result=recorddao.addRecord(md);
            JOptionPane.showMessageDialog(null,"添加成功!");
            t1.setText("");  
            t2.setText("");
             t3.setText("");  
            t4.setText("");
             t5.setText("");  
            t6.setText("");
             t7.setText("");  
           //显示成员列表
            dtm.setRowCount(0);
            ResultSet rs=recorddao.getRecord();
            try {
	    while(rs.next()){
	        Vector v=new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("type"));
		v.add(rs.getString("record_type"));
                v.add(rs.getString("account_type"));
                 v.add(rs.getString("member"));
		v.add(rs.getString("remark"));
                v.add(rs.getString("sum"));
                 v.add(rs.getString("rdate"));
		dtm.addRow(v);
		}
	    } catch (SQLException ext) {
	        ext.printStackTrace();
		 }
            }
            });
        
             b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();//返回表格中选择的行数
            int rowcount = dtm.getRowCount()-1;//getRowCount返回行数，rowcount<0代表已经没有任何行了。 
            if(rowcount >= 0)
            {
                 String s1= (String)table.getValueAt(row, 1);
                 String s2= (String)table.getValueAt(row, 2);
                    String s3= (String)table.getValueAt(row, 3);
                 String s4= (String)table.getValueAt(row, 4);
                    String s5= (String)table.getValueAt(row, 5);
                 String s6= (String)table.getValueAt(row, 6);
                    String s7= (String)table.getValueAt(row, 7);
                 record md = new record(s1,s2,s3,s4,s5,s6,s7);
                 int result=recorddao.delRecord(md);
                 int i=JOptionPane.showConfirmDialog(null,"确定要删除吗?",null, JOptionPane.YES_NO_CANCEL_OPTION);//单击"确定"按钮,则返回值为0. 
                 if(i==0){   
                 dtm.removeRow(row);
                 dtm.setRowCount(rowcount);//删除行比较简单，只要用DefaultTableModel的removeRow()方法即可。删除行完毕后必须重新设置列数，也就是使用DefaultTableModel的setRowCount()方法来设置当前行。
                 }
             }
             table.revalidate();
            }
            }); 
            
            
            b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            //显示成员列表
            dtm.setRowCount(0);
            ResultSet rs=recorddao.getRecord();
            try {
	    while(rs.next()){
                //Vector类可实现了一个动态数组
		Vector v=new Vector();
                v.add(rs.getString("id"));
                 v.add(rs.getString("type"));
		v.add(rs.getString("record_type"));
                v.add(rs.getString("account_type"));
                 v.add(rs.getString("member"));
		v.add(rs.getString("remark"));
                v.add(rs.getString("sum"));
                 v.add(rs.getString("rdate"));
		dtm.addRow(v);
		}
	    } catch (SQLException ext) {
	        ext.printStackTrace();
		 }
            }
            });
            
            b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             String ftype=t1.getText();
            String frecord_type=t2.getText();
            String faccount_type=t3.getText();
            String fmember=t4.getText();
            String fremark=t5.getText();
            String fsum=t6.getText();
            String frdate=t7.getText();
            record md = new record(ftype,frecord_type,faccount_type,fmember,fremark,fsum,frdate);
            t1.setText("");  
            t2.setText("");
             t3.setText("");  
            t4.setText("");
             t5.setText("");  
            t6.setText("");
             t7.setText("");  
        
            dtm.setRowCount(0);
            rs =recorddao.queryRecord(md);
            try {
	        while(rs.next()){
		Vector v=new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("type"));
		v.add(rs.getString("record_type"));
                v.add(rs.getString("account_type"));
                 v.add(rs.getString("member"));
		v.add(rs.getString("remark"));
                v.add(rs.getString("sum"));
                 v.add(rs.getString("rdate"));
		dtm.addRow(v);
		}
	    } catch (SQLException ext) {
	        ext.printStackTrace();
		 }
            }
            });
            
            b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String s1=JOptionPane.showInputDialog(null, "请输入要修改的成员", null,JOptionPane.PLAIN_MESSAGE);
            String s2=JOptionPane.showInputDialog(null, "请修改账目类型", null,JOptionPane.PLAIN_MESSAGE);
            String s3=JOptionPane.showInputDialog(null, "请修改账目类别", null,JOptionPane.PLAIN_MESSAGE);
            String s4=JOptionPane.showInputDialog(null, "请修改账户类型", null,JOptionPane.PLAIN_MESSAGE);
            String s5=JOptionPane.showInputDialog(null, "请修改家庭成员", null,JOptionPane.PLAIN_MESSAGE);
            String s6=JOptionPane.showInputDialog(null, "请修改备注", null,JOptionPane.PLAIN_MESSAGE);
            String s7=JOptionPane.showInputDialog(null, "请修改金额", null,JOptionPane.PLAIN_MESSAGE);
            String s8=JOptionPane.showInputDialog(null, "请修改日期", null,JOptionPane.PLAIN_MESSAGE);
            int result=recorddao.alterRecord(s1,s2,s3,s4,s5,s6,s7,s8);
            JOptionPane.showMessageDialog(null,"修改成功!");
            
            dtm.setRowCount(0);
            ResultSet rs=recorddao.getRecord();
            try {
	    while(rs.next()){
		Vector v=new Vector();
                v.add(rs.getString("id"));
                 v.add(rs.getString("type"));
		v.add(rs.getString("record_type"));
                v.add(rs.getString("account_type"));
                 v.add(rs.getString("member"));
		v.add(rs.getString("remark"));
                v.add(rs.getString("sum"));
                 v.add(rs.getString("rdate"));
		dtm.addRow(v);
		}
	    } catch (SQLException ext) {
	        ext.printStackTrace();
		 }
            }
            }); 


    }
    }

 