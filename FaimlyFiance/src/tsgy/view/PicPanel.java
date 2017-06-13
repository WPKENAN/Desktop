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
import java.awt.event.MouseAdapter;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PicPanel extends JPanel{
    Image image;
    public PicPanel(){
        
    }
public PicPanel(String filename){
    image=Toolkit.getDefaultToolkit().getImage(filename);
}
public void show(Image image){
    this.image=image;
    repaint();
}
public void show(String filename){
    image=Toolkit.getDefaultToolkit().getImage(filename);
     repaint();
}
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(),this);
    
}
}
