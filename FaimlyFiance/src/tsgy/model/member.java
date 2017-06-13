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
public class member {
    private int id;
    private String name;
    private String sex;

   public member(String name,String sex){
       this.name=name;
       this.sex=sex;  
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
        public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}
}
