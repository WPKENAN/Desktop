/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.model;

import java.util.Date;

/**
 *
 * @author 15CR-1528LL
 */
public class budget {

  
    private int id;
    private String name;
    private String sum;
    private String bdate;
  public budget( String name, String sum,String bdate) {
   
        this.name = name;
        this.sum = sum;
        this.bdate = bdate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }
}
