package vn.depro.storemanagement.update.product;

import vn.depro.storemanagement.update.category.CategoryManagement;

public class Product {
	public int id;
	public int categoryId;
	public String name;
	public double price;
	public double amount;

	public  void display() {
		System.out.printf("%6d %-25s %-25s %,15.2f %,12.2f%n",
				this.id, CategoryManagement.getNameById(categoryId),
				this.name,this.price,this.amount);
	}
		public void update() {
			
		}
	public Product() {
		super();
	}

	public Product(int id, int categoryId, String name, double price, double amount) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return categoryId;
	}

	public void setCategory(int category) {
		this.categoryId = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
