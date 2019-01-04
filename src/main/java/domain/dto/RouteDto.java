package domain.dto;

import java.sql.Date;

public class RouteDto {

	
	
	private int  route;
	private int  routetracking;
    private Date trndate;
    private int  storage;
    private int  truck;
    private double latitude;
    private double longtitude;
    private String State ;
    public RouteDto() {
    }
    
    
    
    public RouteDto(int route,int routetracking, Date trndate, int storage ,int truck , float latitude, float longtitude ,String State  ) {
    	this.route   = route;
    	this.routetracking=routetracking;
    	this.trndate = trndate;
        this.storage = storage;
        this.truck   = truck;
        this.latitude= latitude;
        this.longtitude = longtitude;
        this.State =State;
    	
    	
    }
    
    public RouteDto(int routetracking, Date trndate, int storage ,int truck , float latitude, float longtitude, String State  ) {
    	this.routetracking=routetracking;
        this.trndate = trndate;
        this.storage = storage;
        this.truck   = truck;
        this.latitude= latitude;
        this.longtitude = longtitude;
        this.State =State;
       
    	
    	
    }
    

    public String getState() {
		return State;
	}



	public void setState(String state) {
		State = state;
	}



	public int getRoutetracking() {
		return routetracking;
	}



	public void setRoutetracking(int routetracking) {
		this.routetracking = routetracking;
	}
    
    
	public int getRoute() {
		return route;
	}

	public void setRoute(int route) {
		this.route = route;
	}

	public Date getTrndate() {
		return trndate;
	}

	public void setTrndate(Date trndate) {
		this.trndate = trndate;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}




}
