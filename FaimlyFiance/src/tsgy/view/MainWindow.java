/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class MainWindow extends JFrame implements ActionListener{
    JMenuBar menuBar;
    JMenu menu1,menu2,menu3,menu4,menu5;
    JMenuItem m11,m12,m13;
     JMenuItem m21,m22,m23,m24;
      JMenuItem m31,m32;
       JMenuItem m41,m42;
       JMenuItem m51,m52,m53,m54,m55;
       JToolBar toolBar;
       JButton b1,b2,b3;
       public MainWindow(){
           add(new tsgy.view.PicPanel("2.jpeg"),BorderLayout.CENTER);
           createMenu();
           setTitle("家庭财务管理系统");
           setSize(600,400);
                 Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();   
          Dimension   framesize   =   this.getSize();
          int   x   =   (int)screensize.getWidth()/2   -   (int)framesize.getWidth()/2;   
          int   y   =   (int)screensize.getHeight()/2   -   (int)framesize.getHeight()/2;   
          this.setLocation(x,y);   
          this.setVisible(true);   
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setVisible(true);
           this.setExtendedState(JFrame.MAXIMIZED_BOTH);
           
         
       }
       private void createMenu(){
           menuBar=new JMenuBar();
           menu1=new JMenu("分类管理");
           m11=new JMenuItem("分类管理列表");
           m12=new JMenuItem("收入分类管理");
           m13=new JMenuItem("支出管理列表");
           menu1.add(m11);
           menu1.add(m12);
           menu1.add(m13);
           menu2=new JMenu("账户管理");
           m21=new JMenuItem("账户列表");
           m22=new JMenuItem("添加账户");
           m23=new JMenuItem("删除账户");
           m24=new JMenuItem("修改账户");
           menu2.add(m21);
           menu2.add(m22);
           menu2.add(m23);
            menu2.add(m24);
            menu3=new JMenu("预算管理");
           m31=new JMenuItem("显示预算");
           m32=new JMenuItem("修改预算");         
           menu3.add(m31);
           menu3.add(m32);
           menu4=new JMenu("成员管理");
           m41=new JMenuItem("添加成员");
           m42=new JMenuItem("成员列表");         
           menu4.add(m41);
           menu4.add(m42);
           menu5=new JMenu("账务管理");
           m51=new JMenuItem("添加账务");
           m52=new JMenuItem("查询账务");
           m53=new JMenuItem("删除账务");
           m54=new JMenuItem("修改账务");
           m55=new JMenuItem("账务列表");
           menu5.add(m51);
           menu5.add(m52);
           menu5.add(m53);
           menu5.add(m54);
           menu5.add(m55);
           m11.addActionListener(this);
           m12.addActionListener(this);
           m13.addActionListener(this);
           m21.addActionListener(this);
           m22.addActionListener(this);
           m23.addActionListener(this);
           m24.addActionListener(this);
           m31.addActionListener(this);
           m32.addActionListener(this);
           m41.addActionListener(this);
           m42.addActionListener(this);
           m51.addActionListener(this);
           m52.addActionListener(this);
           m53.addActionListener(this);
           m54.addActionListener(this);
           m55.addActionListener(this);
           menuBar.add(menu1);
           menuBar.add(menu2);
           menuBar.add(menu3);
           menuBar.add(menu4);
           menuBar.add(menu5);
           this.setJMenuBar(menuBar);
               m11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m11){
                tsgy.view.Record_type m1=new tsgy.view.Record_type();
                m1.setTitle("分类管理");
                m1.setVisible(true);   
            }
            }
        });
          m12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m12){
               tsgy.view.Record_type m1=new tsgy.view.Record_type();
                m1.setTitle("分类管理");
                m1.setVisible(true);   
            }
            }
        });
               m31.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m31){
                tsgy.view.Budget m1=new tsgy.view.Budget();
                m1.setTitle("预算管理");
                m1.setVisible(true);   
            }
            }
        });
          m32.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m32){
              tsgy.view.Budget m1=new tsgy.view.Budget();
                m1.setTitle("预算管理");
                m1.setVisible(true);   
            }
            }
        });
         m41.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m41){
                tsgy.view.Mem1 m1=new tsgy.view.Mem1();
                m1.setTitle("成员管理");
                m1.setVisible(true);   
            }
            }
        });
          m42.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m42){
                tsgy.view.Mem1 m1=new tsgy.view.Mem1();
                m1.setTitle("成员管理");
                m1.setVisible(true);   
            }
            }
        });
             m21.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m21){
                tsgy.view.account m2=new tsgy.view.account();
                m2.setTitle("账户列表");
                m2.setVisible(true);   
            }
            }
        });
      
     m22.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m22){
                tsgy.view.account m2=new tsgy.view.account();
                m2.setTitle("账户列表");
                m2.setVisible(true);   
            }
            }
        });
      m23.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m23){
                tsgy.view.account m2=new tsgy.view.account();
                m2.setTitle("账户列表");
                m2.setVisible(true);   
            }
            }
        });
       m24.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m24){
                tsgy.view.account m2=new tsgy.view.account();
                m2.setTitle("账户列表");
                m2.setVisible(true);   
            }
            }
        });
         m51.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m51){
                tsgy.view.Record m2=new tsgy.view.Record();
                m2.setTitle("账务管理");
                m2.setVisible(true);   
            }
            }
        });
      
     m52.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m52){
                tsgy.view.Record m2=new tsgy.view.Record();
                m2.setTitle("账务管理");
                m2.setVisible(true);   
            }
            }
        });
      m53.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m53){
                tsgy.view.Record m2=new tsgy.view.Record();
                m2.setTitle("账务管理");
                m2.setVisible(true);   
            }
            }
        });
       m54.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m54){
                tsgy.view.Record m2=new tsgy.view.Record();
                m2.setTitle("账务管理");
                m2.setVisible(true);   
            }
            }
        });
        m55.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            //通过getSource()方法可获取事件源对象
            if(e.getSource()==m55){
                tsgy.view.Record m2=new tsgy.view.Record();
                m2.setTitle("账务管理");
                m2.setVisible(true);   
            }
            }
        });
        
       }
       
      

    @Override
    public void actionPerformed(ActionEvent ae) {
     
    }
    public static void main(String args[]){  
       // new MainWindow();
        new Login();
     
       
    }
}

   