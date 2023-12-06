package vn.depro.storemanagement.sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.depro.storemanagement.update.customer.CustomerManagement;
import vn.depro.storemanagement.update.product.ProductManagement;

public class Cart {

	private int id;
	private int customerId;
	private List<CartProduct> list = new ArrayList<CartProduct>();

	static Scanner sc = new Scanner(System.in);

	public void add() { // Them hang hoa vao gio
		System.out.println("\n---------THEM HANG HOA VAO GIO-----------");
		System.out.println("\t Nhap ma hang(id) muon mua: ");
		int productId = Integer.parseInt(sc.nextLine());

		// Kiem tra xem productId co trong danh sach hay khong
		int index = ProductManagement.indexOfProduct(productId);
		if (index == -1) {
			System.out.println("Hang hoa khong co trong danh sach, xin chon lai");
		}
		// Co thi nhap so luong can mua
		System.out.println("Nhap so luong muon mua");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua can phai lon hon 0");
			return;
		}
		// Tim xem hang dinh mua da co trong gio chua
		int cartIndex = indexOfCartProduct(productId);
		if (cartIndex != -1) // Hang da co trong gio
		{
			amount += list.get(cartIndex).getAmount();// Cong so luong trong gio voi so luong moi chon them
		}

		// Kiem tra tong so luong mua co vuot qua tong so luong dang co ban
		if (amount > ProductManagement.getList().get(index).getAmount()) {
			System.out.println("So luong vuot qua so luong hang ton tai trong kho, xin nhap lai");
			return;
		}

		// Them hang vao gio: 2 truong hop
		if (cartIndex != -1) {// Hang da co trong gio
			list.add(new CartProduct(productId, amount));// Set lai so luong moi
		} else {
			list.add(new CartProduct(productId, amount));// Them hang moi vao gio
		}
		System.out.println("Them hang moi thanh cong");
	}

	public void update() { // Sua thong tin hang hoa
		System.out.println("\n---------SUA THONG TIN HANG TRONG GIO-----------");
		System.out.println("\t Nhap ma hang(id) muon sua: ");
		int productId = Integer.parseInt(sc.nextLine());

		// Kiem tra hang co trong gio khong
		int cartIndex = indexOfCartProduct(productId);
		if (cartIndex == -1) // Hang da co trong gio
		{
			System.out.println("Hang khong co trong gio");
			return;
		}
		// Co
		System.out.println("Nhap so luong moi:");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua can phai lon hon 0");
			return;
		}
		// Kiem tra so luong ko vuot qua so luong ban
		int index = ProductManagement.indexOfProduct(productId);
		if (amount > ProductManagement.getList().get(index).getAmount()) {
			System.out.println("So luong vuot qua so luong hang ton tai trong kho, xin nhap lai");
			return;
		}
		// Thay so luong cu bang so luong moi
		list.get(index).setAmount(amount);
		System.out.println("Sua thong tin hang hoa thanh cong");
	}

	public void remove() { // Xoa hang khoi gio
		System.out.println("\n---------XOA HANG TRONG GIO-----------");
		System.out.println("\t Nhap ma hang(id) muon xoa: ");
		int productId = Integer.parseInt(sc.nextLine());

		// Kiem tra hang co trong gio khong
		int cartIndex = indexOfCartProduct(productId);
		if (cartIndex == -1) // Hang da co trong gio
		{
			System.out.println("Hang khong co trong gio");
			return;
		}
		list.remove(cartIndex);
		System.out.println("Xoa hang trong gio thanh cong");
	}

	public int indexOfCartProduct(int productId) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getProductId() == productId) {
				return index;
			}
		}
		return -1;
	}

	public double cartTotal() {
		double total = 0;
		for (CartProduct cp : list) {
			total += cp.total();
		}
		return total;
	}

	public void display() {
		System.out.println("\n-----------GIO HANG CUA BAN-----------");
		System.out.println("\tTen khach hang: " + CustomerManagement.getNameById(customerId));
		System.out.println("\tGio hang hoa gom " + list.size() + " loai hang hoa");
		System.out.printf("%3s %-30s %-15s %-12s %-15s%n", "STT", "Ten hang hoa", "Don gia", "So luong", "Thanh tien");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%3s", i + 1);
			list.get(i).display();
		}
		System.out.printf("\t\tTong thanh tien : %,.2f%n", cartTotal());
	}

	public Cart() {
		super();
	}

	public Cart(int id, int customerId, List<CartProduct> list) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<CartProduct> getList() {
		return list;
	}

	public void setList(List<CartProduct> list) {
		this.list = list;
	}

}
