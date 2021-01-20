package pojo;

public class Yisheng {

	private int yishengID;
	private String yishengName;
	
	public int getyishengID(){
		return yishengID;
	}
	
	public String getyishengName() {
		return yishengName;
	}
	
	public void setyishengID(int yishengID){
		this.yishengID = yishengID;
	}
	
	public void setyishengName(String yishengName) {
		this.yishengName = yishengName;
	}
	
	@Override
	public String toString() {
		return yishengName;
	}

}
