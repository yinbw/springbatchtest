package com.ybw.batch;

import java.io.Serializable;  

public class TestBean implements Serializable{  

	private String day;  
    private String msisdn;  
    private String remark;  

    public TestBean() {

    }

    public TestBean(String day, String msisdn,String remark) {
        this.day = day;
        this.msisdn = msisdn;
        this.remark = remark;
    }
    
    public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
      
	
	@Override
    public String toString() {
        return "day: " + day + ", msisdn: " + msisdn+ ", remark: " + remark;
    }
}  