package pojo;

public class Keshi  {
	
	private int keID;
	private String keName;
	
	public int getkeID(){
		return keID;
	}
	
	public String getkeName() {
		return keName;
	}
	
	public void setkeID(int keID){
		this.keID = keID;
	}
	
	public void setkeName(String keName) {
		this.keName = keName;
	}
	
	@Override
	public String toString() {
		return keName;
	}

	
}
