package pojo;

public class Yaopin  {
	
	private int yaoID;
	private String yaoName;
	
	public int getyaoID(){
		return yaoID;
	}
	
	public String getyaoName() {
		return yaoName;
	}
	
	public void setyaoID(int yaoID){
		this.yaoID = yaoID;
	}
	
	public void setyaoName(String yaoName) {
		this.yaoName = yaoName;
	}
	
	@Override
	public String toString() {
		return yaoName;
	}

	
}