package pojo;

public class Qu {
	
	private int quID;
	private String quName;
	
	public int getquID(){
		return quID;
	}
	
	public String getquName() {
		return quName;
	}
	
	public void setquID(int quID){
		this.quID = quID;
	}
	
	public void setquName(String quName) {
		this.quName = quName;
	}
	
	@Override
	public String toString() {
		return quName;
	}

	
}

