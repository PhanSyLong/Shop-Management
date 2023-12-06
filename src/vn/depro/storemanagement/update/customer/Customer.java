package vn.depro.storemanagement.update.customer;

public class Customer {
	protected int id;
	protected String name;

	public void display() {
		System.out.printf("%-5d %-30s", this.id, this.name);
	}

	public Customer() {
		super();
	}

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
