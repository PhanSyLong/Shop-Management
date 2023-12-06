package vn.depro.storemanagement.update.customer;

import java.util.ArrayList;
import java.util.Scanner;


public class CustomerManagement {

	private static ArrayList<Customer> list = new ArrayList<Customer>();

	public static ArrayList<Customer> getList() {
		return list;
	}

	public static void seList(ArrayList<Customer> list) {
		CustomerManagement.list = list;
	}

	public static int autoId = 1; // auto increasement

	public static void init() { // Để test các chức năng tránh phải nhập nhiều
		list.add(new Customer(autoId++, "Quach Tinh"));
		list.add(new Customer(autoId++, "Hoang Dung"));
		list.add(new Customer(autoId++, "Phan Long"));
		list.add(new Customer(autoId++, "Nguyen Hue"));
		list.add(new Customer(autoId++, "Thich Nhat"));
	}

	static Scanner sc = new Scanner(System.in);

	public static void customerUpdate() {
		do {
			System.out.println("\n---------------CẬP NHẬT THÔNG TIN KHÁCH HÀNG");
			System.out.println("Cac chuc nang cap nhat");
			System.out.println("\t1.Xem danh sách khách hàng");
			System.out.println("\t2.Thêm một khách hàng mới vào danh sách");
			System.out.println("\t3.Sửa thông tin khách hàng hóa");
			System.out.println("\t4.Xóa một khách hàng trong danh sách");
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

	public static void display() {
		System.out.printf("\n\t DANH SACH KHACH HANG");
		System.out.printf("%-5s %-30s%n", "Id", "name");
		for (Customer Customer : list) {
			Customer.display();
			System.out.println();
		}
	}

	private static void add() {
		System.out.println("\n---------THEM MOT KHACH HANG MOI VAO DANH SACH");
		System.out.println("\t Nhap ten KHACH HANG: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\t Ten hang hoa khong duoc de trống");
			return;
		}
		if (nameIsExist(name)) {
			System.out.println("\tTen nay da ton tai trong danh sach");
			return;
		}
		Customer newCustomer = new Customer(autoId++, name);
		list.add(newCustomer);
		System.out.println("\t Them KHACH HANG moi thanh cong");
	}

// Kiem tra ten KHACH HANG moi khong trung voi ten KHACH HANG da co
	private static boolean nameIsExist(String name) {
		for (Customer customer : list) {
			if (customer.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	private static void remove() {
		System.out.println("=============");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCustomer(id);
		if (index == -1) {
			System.out.println("\t.Khach hang khong ton tai trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("Xoa KHACH HANG thanh cong");
	}

	private static void edit() {
		System.out.println("=============");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCustomer(id);
		if (index == -1) {
			System.out.println("\t.Khách hàng khong ton tai trong danh sach");
			return;
		}
		System.out.println("\t Nhap ten KHACH HANG: ");
		String name = sc.nextLine();
		if (nameIsExist(name)) {
			System.out.println("\tTen nay da ton tai trong danh sach");
			return;
		}
		list.get(index).setName(name);
		System.out.println("\t Sua ten KHACH HANG thanh cong");
	}

	public static int indexOfCustomer(int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id)
				return index;
		}
		return -1;
	}

	public static String getNameById(int id) {
		for (Customer customer : list) {
			if (customer.getId() == id) {
				return customer.getName();
			}
		}
		return null;
	}
}
