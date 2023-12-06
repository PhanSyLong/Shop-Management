package vn.depro.storemanagement.update.category;

public class Category {
	protected int id;
	protected String name;
	
	public  void display() {
	System.out.printf("%-5d %-30s",this.id, this.name);
}

	public Category() {
		super();
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
