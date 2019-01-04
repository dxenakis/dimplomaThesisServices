package domain.dto;

public class TruckDto {
	
	
	private int Truck;
	private String Name;
	private String Varchar01;
	private String Varchar02;
	private float  Weight;
	private float volume;
	
	
	
	
	public TruckDto() {
	
	}
	
	public TruckDto(String Name, String Varchar01,String Varchar02, float Weight ,float volume) {
		
		 	this.Name	    = Name;      
	        this.Varchar01  = Varchar01;
	        this.Varchar02  = Varchar01;
	        this.Weight     = Weight;
	        this.volume     =volume;
		}
	
	public TruckDto(int Truck,String Name, String Varchar01,String Varchar02, float Weight ,float volume) {
		this.Truck 		= Truck;
	 	this.Name	    = Name;      
        this.Varchar01  = Varchar01;
        this.Varchar02  = Varchar01;
        this.Weight     = Weight;
        this.volume     = volume;
	}
	
	public float getWeight() {
		return Weight;
	}

	public void setWeight(float weight) {
		Weight = weight;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public int getTruck() {
		return Truck;
	}

	public void setTruck(int truck) {
		Truck = truck;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getVarchar01() {
		return Varchar01;
	}

	public void setVarchar01(String varchar01) {
		Varchar01 = varchar01;
	}

	public String getVarchar02() {
		return Varchar02;
	}

	public void setVarchar02(String varchar02) {
		Varchar02 = varchar02;
	}
	
	
	
	
}
