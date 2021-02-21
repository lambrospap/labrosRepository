package com.example.demo.model;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="products")
public class Product {
	 	
	 	private int id;
		private String ProductName;
		private String Price;
		private String ProductCode;
		private String ProductExpirationDate;
		private String ProductAvailabilityDate;
		
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
		
		public Product(){
	        super();
	    }
		public Product(int id, String productName, String price, String productCode, String productExpirationDate,
				String productAvailabilityDate) {
			super();
			this.id = id;
			ProductName = productName;
			Price = price;
			ProductCode = productCode;
			ProductExpirationDate = productExpirationDate;
			ProductAvailabilityDate = productAvailabilityDate;
		}


		/*
		public Product(String productName, @NotBlank String price, @NotBlank String productCode,
				String productExpirationDate, @NotBlank String productAvailabilityDate) {
			super();
			ProductName = productName;
			Price = price;
			ProductCode = productCode;
			ProductExpirationDate = productExpirationDate;
			ProductAvailabilityDate = productAvailabilityDate;
		}*/

		@Column(name="ProductName")
		public String getProductName() {
			return ProductName;
		}
		public void setProductName(String productName) {
			ProductName = productName;
		}
		@Column(name = "Price")
		public String getPrice() {
			return Price;
		}
		public void setPrice(String price) {
			Price = price;
		}
		@Column(name = "ProductCode")
		public String getProductCode() {
			return ProductCode;
		}
		public void setProductCode(String productCode) {
			ProductCode = productCode;
		}
		@Column(name = "ProductExpirationDate")
		public String getProductExpirationDate() {
			return ProductExpirationDate;
		}
		public void setProductExpirationDate(String productExpirationDate) {
			ProductExpirationDate = productExpirationDate;
		}
		@Column(name = "ProductAvailabilityDate")
		public String getProductAvailabilityDate() {
			return ProductAvailabilityDate;
		}
		public void setProductAvailabilityDate(String productAvailabilityDate) {
			ProductAvailabilityDate = productAvailabilityDate;
		}



}
