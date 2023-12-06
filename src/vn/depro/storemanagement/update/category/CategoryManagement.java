package vn.depro.storemanagement.update.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManagement {
	
	private static List<Category> list = new ArrayList<Category>();

	public static List<Category> getList() {
		return list;
	}

	public static void setList(List<Category> list) {
		CategoryManagement.list = list;
	}

	public static int autoId = 1; // auto increasement

	public static void init() {
		list.add(new Category(autoId++, "Dien Tu"));
		list.add(new Category(autoId++, "Quan nam Lao"));
		list.add(new Category(autoId++, "Do gia dung"));
		list.add(new Category(autoId++, "Ao nu Japan"));
		list.add(new Category(autoId++, "Cap sach nhap khau mi"));
	}

	static Scanner sc = new Scanner(System.in);

	public static void categoryUpdate() {
		do {
			System.out.println("\n---------------CẬP NHẬT THÔNG TIN LOAI HÀNG");
			System.out.println("Cac chuc nang cap nhat");
			System.out.println("\t1.Xem danh sách loại hàng");
			System.out.println("\t2.Thêm một loại hàng mới vào danh sách");
			System.out.println("\t3.Sửa thông tin loại hàng hóa");
			System.out.println("\t4.Xóa một loại hàng trong danh sách");
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
		System.out.printf("\n\t DANH SACH LOAI HANG");
		System.out.printf("%-5s %-30s%n", "Id", "name");
		for (Category category : list) {
			category.display();
			System.out.println();
		}
	}

	private static void add() {
		System.out.println("\n---------THEM MOT LOAI HANG MOI VAO DANH SACH-----------");
		System.out.println("\t Nhap ten loai hang: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\t Ten loai hang khong duoc de trung");
			return;
		}
		if (nameIsExist(name)) {
			System.out.println("\tTen nay da ton tai trong danh sach");
			return;
		}
		Category newCategory = new Category(autoId++, name);
		list.add(newCategory);
		System.out.println("\t Them loai hang moi thanh cong");
	}

	// Kiem tra ten loai hang moi khong trung voi ten loai hang da co
	private static boolean nameIsExist(String name) {
		for (Category category : list) {
			if (category.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	private static void remove() {
		System.out.println("=============");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCategory(id);
		if (index == -1) {
			System.out.println("\t.Mat hang khong ton tai trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("Xoa loai hang thanh cong");
	}

	private static void edit() {
		System.out.println("=============");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCategory(id);
		if (index == -1) {
			System.out.println("\t.Mat hang khong ton tai trong danh sach");
			return;
		}
		System.out.println("\t Nhap ten loai hang: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\t Ten loai hang khong duoc de trung");
			return;
		}
		if (nameIsExist(name)) {
			System.out.println("\tTen nay da ton tai trong danh sach");
			return;
		}
		list.get(index).setName(name);
		System.out.println("\t Sua ten loai hang thanh cong");
	}

	public static int indexOfCategory(int id){
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getId() == id)
				return index;
		}
			return -1;
	}
	public static String getNameById(int id) {
		for(Category category : list) {
			if(category.getId() == id) {
				return category.getName();
			}
		}
		return null;
	}
}
