package vn.depro.storemanagement.update.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.depro.storemanagement.update.category.CategoryManagement;

public class ProductManagement {

	private static List<Product> list = new ArrayList<Product>();

	public static List<Product> getList() {
		return list;
	}

	public static void setList(List<Product> list) {
		ProductManagement.list = list;
	}

	public static int autoId = 1;

	public static void init() {
		list.add(new Product(autoId++, 0001, "Tivi Sony", 5000000, 20));
		list.add(new Product(autoId++, 0002, "Quan kaki lao nam", 200000, 19));
		list.add(new Product(autoId++, 0003, "Bep dien nhap khau nhat", 20000000, 32));
		list.add(new Product(autoId++, 0004, "Ao nu sakura nhat", 4000000, 15));
		list.add(new Product(autoId++, 0005, "Cap sach kako mi", 6000000, 27));

	}

	static Scanner sc = new Scanner(System.in);

	public static void productUpdate() {
		do {
			System.out.println("\n---------------CẬP NHẬT THÔNG TIN HÀNG HÓA-----------------");
			System.out.println("Cac chuc nang cap nhat");
			System.out.println("\t1.Xem danh sách hàng hoa");
			System.out.println("\t2.Thêm một hàng hóa mới vào danh sách");
			System.out.println("\t3.Sửa thông tin hàng hóa");
			System.out.println("\t4.Xóa một hàng hóa trong danh sách");
			System.out.print("Lua chon chuc nang quan li:");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				edit();
				break;
			case 4:
				remove();
				break;
			case 0:
				System.out.println("Da Dong chuong trinh");
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void display() {
		System.out.printf("\n\t------------------DANH SACH HANG HOA-----------------");
		System.out.printf("%6s %-25s %-25s %-15s %-12s%n", "Id", "Ten loai hang", "Ten hang hoa", "Don gia",
				"So luong");
		for (Product product : list) {
			product.display();
			System.out.println();
		}
	}

	private static void remove() {
		System.out.println("=============DANH SACH HANG HOA=============");
		System.out.println("\tNhap id hang hoa");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfProduct(id);
		if (index == -1) {
			System.out.println("\t.Mat hang khong ton tai trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa hang hoa thanh cong");
	}

	private static void edit() {
		System.out.println("=============DANH SACH HANG HOA=============");
		System.out.println("\tNhap id hang hoa");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfProduct(id);
		if (index == -1) {
			System.out.println("\t.Mat hang khong ton tai trong danh sach");
			return;
		}
		do {
			System.out.println("\n-----------SUA THONG TIN HANG HOA-------------");
			System.out.println("\tchon thong tin hang hoa can sua");
			System.out.println("\t1.Sua ma(id) hang hoa:");
			System.out.println("\t2.Sua ten hang hoa:");
			System.out.println("\t3.Sua gia hang hoa:");
			System.out.println("\t3.Sua so luong hang hóa");
			System.out.println("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				System.out.println("\tchon category");
				int categoryId = Integer.parseInt(sc.nextLine());
				// Kiem tra category cua nhap co trong danh sach khong
				if (CategoryManagement.indexOfCategory(categoryId) == -1) {
					System.out.println("\tChon categoryId khong hop le");
					return;
				}
				list.get(index).setCategory(categoryId);
				System.out.println("Sua id hang hoa thanh cong");
				break;
			case 2:
				System.out.println("\t Nhap ten hang hoa: ");
				String name = sc.nextLine();
				if (name == null || name.trim().length() == 0) {
					System.out.println("\t Ten hang hoa khong duoc de trung");
					return;
				}
				list.get(index).setName(name);
				System.out.println("Sua ten hang hoa thanh cong");
				break;
			case 3:
				System.out.println("\tNhap don gia: ");
				double price = Double.parseDouble(sc.nextLine());
				if (price < 0) {
					System.out.println("\t Don gia khong duoc la so am");
					return;
				}
				list.get(index).setPrice(price);
				System.out.println("Sua don gia hang hoa thanh cong");
				break;
			case 4:
				System.out.println("\tNhap so luong hang: ");
				double amount = Double.parseDouble(sc.nextLine());
				if (amount < 0) {
					System.out.println("\t So luong khong duoc la so am");
					return;
				}
				list.get(index).setAmount(amount);
				System.out.println("Sua so luong hang hoa thanh cong");
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void add() {
		System.out.println("\n-------------THEM HANG HOA MOI VAO DANH SACH DANH HOA---------------");
		System.out.println("\tchon category");
		int categoryId = Integer.parseInt(sc.nextLine());
		// Kiem tra category cua nhap co trong danh sach khong
		if (CategoryManagement.indexOfCategory(categoryId) == -1) {
			System.out.println("\tChon categoryId khong hop le");
			return;
		}
		System.out.println("\t Nhap ten hang hoa: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\t Ten hang hoa khong duoc de trung");
			return;
		}

		System.out.println("\tNhap don gia: ");
		double price = Double.parseDouble(sc.nextLine());
		if (price < 0) {
			System.out.println("\t Don gia khong duoc la so am");
			return;
		}
		System.out.println("\tNhap so luong hang: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount < 0) {
			System.out.println("\t So luong khong duoc la so am");
			return;
		}
		list.add(new Product(autoId++, categoryId, name, price, amount));
		System.out.println("\tThem hang hoa moi thanh cong");
	}

	public static int indexOfProduct(int id){
			for(int index = 0; index < list.size(); index++) {
				if(list.get(index).getId() == id)
					return index;
			}
				return -1;
		}
	public static Product getProductById(int id) {
		for(Product p : list) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
}
