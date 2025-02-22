package sammer_baja;

public class Product {
	    private String productId;
	    private String productName;
	    private float unitPrice;
	    private int productQuantity;
	    private int soldQuantity;
	    private double totalSales;
	    private int discount;

	    public Product(String productId, String productName, float unitPrice, int productQuantity) {
	        this.productId = productId;
	        this.productName = productName;
	        this.unitPrice = unitPrice;
	        this.productQuantity = productQuantity;
	        this.soldQuantity = 0;
	        this.totalSales = 0;
	        this.discount = 0;
	    }

	    public void purchase(int quantity) throws Exception {
	        if (quantity > productQuantity) {
	            throw new Exception("Not enough quantity available.");
	        }
	        soldQuantity += quantity;
	        productQuantity -= quantity;
	        totalSales += (unitPrice * quantity * (1 - (discount / 100.0)));
	    }

	    public String getProductId() {
	        return productId;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public float getUnitPrice() {
	        return unitPrice;
	    }

	    public int getProductQuantity() {
	        return productQuantity;
	    }

	    public int getSoldQuantity() {
	        return soldQuantity;
	    }

	    public double getTotalSales() {
	        return totalSales;
	    }

	    public int getDiscount() {
	        return discount;
	    }

	    public void setDiscount(int discount) {
	        this.discount = discount;
	    }
	}