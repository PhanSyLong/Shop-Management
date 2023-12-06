package vn.depro.storemanagement.saleorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.depro.storemanagement.sale.Cart;
import vn.depro.storemanagement.update.customer.CustomerManagement;

public class SaleOrderManagement {
	private static List<Cart> carts = new ArrayList<Cart>();

	public static List<Cart> getCarts() {
		return carts;
	}

	public static void setCarts(List<Cart> carts) {
		SaleOrderManagement.carts = carts;
	}

	static Scanner sc = new Scanner(System.in);
	// Hien thi danh sach cac gio hang (cac don hang)
	// Tinh tong doanh thu tu cac gio hang
	// Tim kiem gio hang, hien thi chi tiet gio hang neu tim thay

	public static void saleOrderManagement() {
		do {
			System.out.println("\n==============QUAN LI DON HANG==========");
			System.out.println("chon chuc nang quan li:");
			System.out.println("\t1.Hien thi danh sach don hang");
			System.out.println("\t2.Xem tong doanh thu don hang");
			System.out.println("\t3.Tim kiem don hang");
			System.out.println("\t0.Quay lai");

			System.out.println("Lua chon cua ban?:");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:	displayCarts();
				break;
			case 2:	displayTotalMoney();
				break;
			case 3:	searchCart();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void displayCarts() {
		System.out.println("---------DANH SACH CAC DON HANG----------");
		System.out.printf("%3s %11s %-30s %-15s%n","STT","MA DON HANG","TEN KHACH HANG","TONG TIEN DON HANG");
		int stt =1;
		for(Cart cart : carts) {
			System.out.printf("%3d %-11d %-30s %,15.2f%n",
			stt++,cart.getId(),CustomerManagement.getNameById(cart.getCustomerId()),cart.cartTotal());
		}
	}
	public static double totalMoney() {
		double total = 0;
		for(Cart cart : carts) {
			total += cart.cartTotal();
		}
		return total;
	}
	private static void displayTotalMoney() {
		System.out.printf("\nTong doanh thu: %,.2f%n", totalMoney());
		
	}

	private static void searchCart() {
			System.out.println("\n--------TIM KIEM DON HANG----------");
			System.out.println("Nhap ma don hang(id go hang)");
			int cartId = Integer.parseInt(sc.nextLine());
			boolean result = false;
			
			for (Cart cart : carts) {
				if(cart.getId() == cartId) {
					System.out.println("Chi tiet gio hang tim duoc");
					cart.display();
					result = true;
				}
			}
			
		if(result == false) {
			System.out.println("Khong tim thay ket qua nao");
		}
	}
}
