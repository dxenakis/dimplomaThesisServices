package domain.dto;

import java.sql.Date;

public class TrackingLinesDto {

	private int  TrackingLines;
	private int  routetracking;
    private int  storage;
    private int  truck;
    
    
    public TrackingLinesDto() {
    }
    
    
    
    public TrackingLinesDto(int TrackingLines,int routetracking, int storage ,int truck  ) {
    	this.TrackingLines   = TrackingLines;
    	this.routetracking=routetracking;
        this.storage = storage;
        this.truck   = truck;    	
    }
    
    public TrackingLinesDto(int routetracking, int storage ,int truck  ) {
    	this.routetracking=routetracking;
        this.storage = storage;
        this.truck   = truck;
    	
    }
    
    public int getTrackingLines() {
		return TrackingLines;
	}



	public void setTrackingLines(int trackingLines) {
		TrackingLines = trackingLines;
	}



	public int getRoutetracking() {
		return routetracking;
	}



	public void setRoutetracking(int routetracking) {
		this.routetracking = routetracking;
	}



	public int getStorage() {
		return storage;
	}



	public void setStorage(int storage) {
		this.storage = storage;
	}



	public int getTruck() {
		return truck;
	}



	public void setTruck(int truck) {
		this.truck = truck;
	}
    
    
    
}
