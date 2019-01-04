package domain.dto;

import java.io.Serializable;

public class ProductsDto {
		
		private int product;
		private String code;
		private String name;
		private float price;
		private float weight;
		private float volume;
		

		public ProductsDto() {
	
		}
		public ProductsDto(String code,String name,float price,float weight,float volume) {
			
	        this.code    = code;
	        this.name    = name;
	        this.price   = price;
	        this.weight  = weight;
	        this.volume  = volume;
	       
		}
		
		public ProductsDto(int product ,String code,String name,float price,float weight,float volume) {
			this.product = product;
	        this.code    = code;
	        this.name    = name;
	        this.price   = price;
	        this.weight  = weight;
	        this.volume  = volume;
	       
		}
		
		
		
		
		public int getProduct() {
			return product;
		}


		public void setProduct(int product) {
			this.product = product;
		}


		public String getCode() {
			return code;
		}


		public void setCode(String code) {
			this.code = code;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public float getPrice() {
			return price;
		}


		public void setPrice(float price) {
			this.price = price;
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