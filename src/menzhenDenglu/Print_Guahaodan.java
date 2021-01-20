package menzhenDenglu;

import pojo.Keshi;

public class Print_Guahaodan {

	private int binid;
	private String binname;
	private String bingender;
	
	private String binkeshi;
	private String binyisheng;
	
	public int getbinid(){
		return binid;
	}
	
	public String getbinname() {
		return binname;
	}
	
	public String getbingender() {
		return bingender;
	}
	
	public String getbinkeshi() {
		return binkeshi;
	}
	
	public String getbinyisheng() {
		return binyisheng;
	}
	
	public void setbinid(int binid){
		this.binid = binid;
	}
	
	public void setbingender(String bingender) {
		this.bingender = bingender;
	}
	
	public void setbinkeshi(String keshi) {
		this.binkeshi =keshi ;
	}
	
	public void setbinyisheng(String binyisheng) {
		this.binyisheng = binyisheng;
	}
	
	public void setbinname(String binname) {
		this.binname = binname;
	}
	
	@Override
	public String toString() {
		return binname;
	}

}
