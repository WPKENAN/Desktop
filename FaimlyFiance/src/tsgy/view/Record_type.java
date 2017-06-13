/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.view;

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
import tsgy.model.record_type;
import tsgy.util.Record_typeDao;

public class Record_type extends JFrame
{
    JPanel panel1,panel2;
    JButton b1=new JButton("添加");
    JButton b2=new JButton("删除");
    JButton b3=new JButton("分类管理");
    JButton b4=new JButton("查询");
    JButton b5=new JButton("修改");
    JLabel label1=new JLabel("账目名称");
    JLabel label2=new JLabel("账目类型");
    JTextField t1=new JTextField(20);
    JTextField t2=new JTextField(20);
    JTable table=null;
    ResultSet rs=null;
    Record_typeDao memberdao=new Record_typeDao();
        
    public Record_type() {
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
	String[] Names={"ID","AccountName","AccountType"};//创建表格中的横标题
        final DefaultTableModel dtm=new DefaultTableModel(playerInfo,Names);//创建一个默认的表格模型
	table=new JTable(dtm);//以模型中的数据为参数，创建一个表格
	table.setPreferredScrollableViewportSize(new Dimension(600,300));//  设置此表视口的首选大小
        JScrollPane scrollPane=new JScrollPane(table);//将表格加入到滚动条组件中
	
        panel1=new JPanel(new GridLayout(2,2));
        panel1.add(label1);
        panel1.add(t1);
        panel1.add(label2);
        panel1.add(t2);
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
            String fname=t1.getText();
            String fsex=t2.getText();
            record_type md = new record_type(fname,fsex);
            int result=memberdao.addRecord_type(md);
            JOptionPane.showMessageDialog(null,"添加成功!");
            t1.setText("");  
            t2.setText("");
            
            //显示成员列表
            dtm.setRowCount(0);
            ResultSet rs=memberdao.getRecord_type();
            try {
	    while(rs.next()){
	        Vector v=new Vector();
                v.add(rs.getString("id"));
		v.add(rs.getString("name"));
                v.add(rs.getString("type"));
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
                 record_type md = new record_type(s1,s2);
                 int result=memberdao.delRecord_type(md);
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
            ResultSet rs=memberdao.getRecord_type();
            try {
	    while(rs.next()){
                //Vector类可实现了一个动态数组
		Vector v=new Vector();
                v.add(rs.getString("id"));
		v.add(rs.getString("name"));
                v.add(rs.getString("type"));
		dtm.addRow(v);
		}
	    } catch (SQLException ext) {
	        ext.printStackTrace();
		 }
            }
            });
            
            b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String fname1=t1.getText();
            String fsex1=t2.getText();
            record_type md = new record_type(fname1,fsex1);
            t1.setText("");  
            t2.setText("");
            
            dtm.setRowCount(0);
            rs =memberdao.queryRecord_type(md);
            try {
	        while(rs.next()){
		Vector v=new Vector();
                v.add(rs.getString("id"));
		v.add(rs.getString("name"));
                v.add(rs.getString("type"));
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
            String s2=JOptionPane.showInputDialog(null, "请修改名称", null,JOptionPane.PLAIN_MESSAGE);
            String s3=JOptionPane.showInputDialog(null, "请修改类型", null,JOptionPane.PLAIN_MESSAGE);
            int result=memberdao.alterRecord_type(s1,s2,s3);
            JOptionPane.showMessageDialog(null,"修改成功!");
            
            dtm.setRowCount(0);
            ResultSet rs=memberdao.getRecord_type();
            try {
	    while(rs.next()){
		Vector v=new Vector();
                v.add(rs.getString("id"));
		v.add(rs.getString("name"));
                v.add(rs.getString("type"));
		dtm.addRow(v);
		}
	    } catch (SQLException ext) {
	        ext.printStackTrace();
		 }
            }
            }); 


    }
    }

 
