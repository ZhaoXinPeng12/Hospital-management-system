package pojo;

public class Bin {
	
	private int binID;
	private String binName;
	
	public int getbinID(){
		return binID;
	}
	
	public String getbinName() {
		return binName;
	}
	
	public void setbinID(int binID){
		this.binID = binID;
	}
	
	public void setbinName(String binName) {
		this.binName = binName;
	}
	
	@Override
	public String toString() {
		return binName;
	}

	
}

