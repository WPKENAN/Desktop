/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public final class Login extends JFrame {
    JButton b1,b2;
    JLabel c1,c2;
    JTextField d1,d2,t1;
    JPasswordField t2;
    JPanel contenPane;
    JMenuBar x1;
    JMenu x2;
    JMenuItem x3,x4;
    Image image;
    
    public Login(){
     super("登陆窗口");
     //添加背景图片
    contenPane =new JPanel(){
    public void paintComponent(Graphics g){
    image=new ImageIcon("1.jpg").getImage();
    g.drawImage(image,0, 0, this.getWidth(), this.getHeight(), this);
    }  };
        ImageIcon imageIcon = new ImageIcon("flower.jpg"); 
        
        
        b1=new JButton("确定"); 
        b2=new JButton("取消");
        t1=new JTextField(12);
        t2=new JPasswordField(12);
        c1=new JLabel("用户");
        c2=new JLabel("密码");
        x1=new JMenuBar();
        x2=new JMenu("选择");
        x3=new JMenuItem("打开");
        x4=new JMenuItem("关闭");
        x2.add(x3);
        x2.add(x4);
        x1.add(x2); 
        this.setJMenuBar(x1);//菜单容器与面板同一等级
        this.setContentPane(contenPane);
        this.contenPane.add(c1);
        this.contenPane.add(t1);
        this.contenPane.add(c2);
        this.contenPane.add(t2);
        this.contenPane.add(b1);
        this.contenPane.add(b2);
        this.setSize(400, 500);
         Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();   
          Dimension   framesize   =   this.getSize();
          int   x   =   (int)screensize.getWidth()/2   -   (int)framesize.getWidth()/2;   
          int   y   =   (int)screensize.getHeight()/2   -   (int)framesize.getHeight()/2;   
          this.setLocation(x,y);   
          this.setVisible(true);   
        this.setVisible(true);
        
    //监控按键，检查密码是否正确.b1取消，b2确定
    b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    t2.setText(null);t1.setText(null);  }
     } );  
     
    b1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    String name=t1.getText();
    String pws=new String(t2.getPassword());//getPassword为字符数组，需强制类型转换，然后新建
    boolean x=name.equals("root");
    boolean y=pws.equals("root");
    boolean z=(x&&y);
    if(z==true){
    JOptionPane.showInternalMessageDialog(b1, "输入正确"); 
    new MainWindow();
    dispose();}
    else{
    JOptionPane.showInternalMessageDialog(b1, "输入错误，请重新输入"); 
    t2.setText(null);t1.setText(null);  }      
    }  });          
                 
    }
}
         
             
            

  
      