package pojo;

public class Sheng {
	
	private int shengID;
	private String shengName;
	
	public int getshengID(){
		return shengID;
	}
	
	public String getshengName() {
		return shengName;
	}
	
	public void setshengID(int shengID){
		this.shengID = shengID;
	}
	
	public void setshengName(String shengName) {
		this.shengName = shengName;
	}
	
	@Override
	public String toString() {
		return shengName;
	}

	
}
