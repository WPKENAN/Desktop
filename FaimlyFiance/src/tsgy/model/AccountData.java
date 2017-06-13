/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgy.model;

/**
 *
 * @author 15CR-1528LL
 */
public class AccountData {
    private int id;
    private String name;
    private String balance;
    private String remark;
   public AccountData(String name,String balance,String remark){
       this.name=name;
       this.balance=balance; 
       this.remark=remark;
        
    }

   
       	public int getId() {
		return id;
	}
       public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
        public String getbalance() {
		return balance;
	}
	public void setbalance(String balance) {
		this.balance = balance;
	}
        public String getremark() {
		return remark;
	}
	public void setremark(String remark) {
		this.remark = remark;
	}
}

