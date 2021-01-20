package pojo;

public class Zhiye  {
	
	private int zhiID;
	private String zhiName;
	
	public int getzhiID(){
		return zhiID;
	}
	
	public String getzhiName() {
		return zhiName;
	}
	
	public void setzhiID(int zhiID){
		this.zhiID = zhiID;
	}
	
	public void setkeName(String zhiName) {
		this.zhiName = zhiName;
	}
	
	@Override
	public String toString() {
		return zhiName;
	}

	
}
