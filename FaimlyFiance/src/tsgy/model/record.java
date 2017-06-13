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
public class record {
    private int id;
    private String type;
    private String record_type;
    private String account_type;
    private String member;
    private String remark;
    private String sum;
    private String rdate;

    public record(String type, String record_type, String account_type, String member, String remark, String sum, String rdate) {
        this.type = type;
        this.record_type = record_type;
        this.account_type = account_type;
        this.member = member;
        this.remark = remark;
        this.sum = sum;
        this.rdate = rdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
    
}
