package sammer_baja;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Sales {
	    private static List<Product> stock = new ArrayList<>();

	    public static void main(String[] args) {
	        while (true) {
	            String choice = JOptionPane.showInputDialog(
	                    "Choose an option:\n" +
	                            "1) Add Stock\n" +
	                            "2) Purchase\n" +
	                            "3) Exit");

	            if (choice == null) {
	                break; // User clicked cancel or closed the dialog
	            }

	            try {
	                int option = Integer.parseInt(choice);
	                switch (option) {
	                    case 1:
	                        addStock();
	                        break;
	                    case 2:
	                        purchase();
	                        break;
	                    case 3:
	                        JOptionPane.showMessageDialog(null, "Exiting the application.");
	                        return;
	                    default:
	                        JOptionPane.showMessageDialog(null, "Invalid choice. Please choose again.");
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid option.");
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
	            }
	        }
	    }

	    private static void addStock() {
	        try {
	            String productId = JOptionPane.showInputDialog("Enter product id:");
	            String productName = JOptionPane.showInputDialog("Enter product name:");
	            float unitPrice = Float.parseFloat(JOptionPane.showInputDialog("Enter unit price:"));
	            int productQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter product quantity:"));
	            int discount = Integer.parseInt(JOptionPane.showInputDialog("Enter discount:"));

	            Product product = new Product(productId, productName, unitPrice, productQuantity);
	            product.setDiscount(discount);
	            stock.add(product);
	            JOptionPane.showMessageDialog(null, "Product added successfully.");
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
	        }
	    }

	    private static void purchase() {
	        if (stock.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No products available in stock.");
	            return;
	        }

	        try {
	            String productId = JOptionPane.showInputDialog("Enter product id to purchase:");
	            Product productToPurchase = null;

	            for (Product product : stock) {
	                if (product.getProductId().equals(productId)) {
	                    productToPurchase = product;
	                    break;
	                }
	            }

	            if (productToPurchase == null) {
	                throw new Exception("Product not found.");
	            }

	            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity to purchase:"));
	            productToPurchase.purchase(quantity);

	            // Display purchase information
	            StringBuilder purchaseInfo = new StringBuilder();
	            purchaseInfo.append("Purchase Successful!\n");
	            purchaseInfo.append("Product ID: ").append(productToPurchase.getProductId()).append("\n");
	            purchaseInfo.append("Product Name: ").append(productToPurchase.getProductName()).append("\n");
	            purchaseInfo.append("Unit Price: ").append(productToPurchase.getUnitPrice()).append("\n");
	            purchaseInfo.append("Quantity Purchased: ").append(quantity).append("\n");
	            purchaseInfo.append("Discount (%): ").append(productToPurchase.getDiscount()).append("\n");
	            purchaseInfo.append("Total Amount Paid: Php ").append(productToPurchase.getUnitPrice() * quantity).append("\n");
	            purchaseInfo.append("Remaining Stock: ").append(productToPurchase.getProductQuantity()).append("\n");
	            purchaseInfo.append("Total Sales for Product: Php ").append(productToPurchase.getTotalSales()).append("\n");

	            JOptionPane.showMessageDialog(null, purchaseInfo.toString());
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid quantity.");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
	        }
	    }
	}