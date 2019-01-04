package domain.dto;


import java.io.Serializable;

public class StorageDto {
	
	private int storage;
	private String name;
	private float weight;
	private float volume;
	

	public StorageDto() {

	}
	
	public StorageDto(String name,float weight,float volume) {
		
      
        this.name    = name;      
        this.weight  = weight;
        this.volume  = volume;
       
	}
	
	public StorageDto(int Storage,String name,float weight,float volume) {
		this.storage=  storage;
        this.name    = name;
        this.weight  = weight;
        this.volume  = volume;
       
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	
	
	
	
}
