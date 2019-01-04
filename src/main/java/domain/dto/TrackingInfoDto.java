package domain.dto;


public class TrackingInfoDto {

	
	private int routetracking;
	private int truck; 
	private float truckweight; 
	private float truckvolume;
	private float stovolume;
	private float stoweight;
	private float freeweight;
	private float freevolume;
	
	public TrackingInfoDto() {	       
	}
	

	public TrackingInfoDto(int routetracking,int truck, float truckweight, float truckvolume, float stovolume, float stoweight, float freeweight, float freevolume    ) {

		this.routetracking = routetracking;
        this.truck = truck;    	
    	this.truckweight = truckweight;
    	this.truckvolume = truckvolume;
    	this.stoweight = stoweight;
    	this.stovolume = stovolume;
    	this.freeweight = freeweight;
    	this.freevolume = freevolume;
                
	}
	
	public int getRoutetracking() {
		return routetracking;
	}


	public void setRoutetracking(int routetracking) {
		this.routetracking = routetracking;
	}


	public int getTruck() {
		return truck;
	}


	public void setTruck(int truck) {
		this.truck = truck;
	}


	public float getTruckweight() {
		return truckweight;
	}


	public void setTruckweight(float truckweight) {
		this.truckweight = truckweight;
	}


	public float getTruckvolume() {
		return truckvolume;
	}


	public void setTruckvolume(float truckvolume) {
		this.truckvolume = truckvolume;
	}


	public float getStovolume() {
		return stovolume;
	}


	public void setStovolume(float stovolume) {
		this.stovolume = stovolume;
	}


	public float getStoweight() {
		return stoweight;
	}


	public void setStoweight(float stoweight) {
		this.stoweight = stoweight;
	}


	public float getFreeweight() {
		return freeweight;
	}


	public void setFreeweight(float freeweight) {
		this.freeweight = freeweight;
	}


	public float getFreevolume() {
		return freevolume;
	}


	public void setFreevolume(float freevolume) {
		this.freevolume = freevolume;
	}
	
	
	
	
}
