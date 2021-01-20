package pojo;

public class Shi {
	
	private int shiID;
	private String shiName;
	
	public int getshiID(){
		return shiID;
	}
	
	public String getshiName() {
		return shiName;
	}
	
	public void setshiID(int shiID){
		this.shiID = shiID;
	}
	
	public void setshiName(String shiName) {
		this.shiName = shiName;
	}
	
	@Override
	public String toString() {
		return shiName;
	}

	
}

