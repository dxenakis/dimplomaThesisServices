package domain.dto;

import java.sql.Date;

public class RouteLinesDto {

	private int  routelines;
	private int  routetracking;
    private int  storage;
    private int  product;
    private float qty;
    private float price;
    private float value;
    
    
    public RouteLinesDto() {
    }
    
    
    
    public RouteLinesDto(int routelines,int routetracking, int storage ,int product , float qty, float price, float value  ) {
    	this.routelines   = routelines;
    	this.routetracking=routetracking;
        this.storage = storage;
        this.qty= qty;
        this.price = price;
        this.value = value;
    	
    }
    
    public RouteLinesDto(int routetracking, int storage ,int product , float qty, float price, float value  ) {
    	this.routetracking=routetracking;
        this.storage = storage;
        this.qty= qty;
        this.price = price;
        this.value = value;
    	
    }
    
    public int getRoutelines() {
		return routelines;
	}



	public void setRoutelines(int routelines) {
		this.routelines = routelines;
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



	public int getProduct() {
		return product;
	}



	public void setProduct(int product) {
		this.product = product;
	}



	public float getQty() {
		return qty;
	}



	public void setQty(float qty) {
		this.qty = qty;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public float getValue() {
		return value;
	}



	public void setValue(float value) {
		this.value = value;
	}
	
	
}
