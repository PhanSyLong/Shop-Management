package vn.depro.storemanagement;

import java.util.Scanner;

import vn.depro.storemanagement.sale.CartManagement;
import vn.depro.storemanagement.saleorder.SaleOrderManagement;
import vn.depro.storemanagement.update.SystemInformationManagement;
import vn.depro.storemanagement.update.category.CategoryManagement;
import vn.depro.storemanagement.update.customer.CustomerManagement;
import vn.depro.storemanagement.update.product.ProductManagement;

public class StoreManagement {
	public static void main(String[] args) {
		CategoryManagement.init();
		ProductManagement.init();
		CustomerManagement.init();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n===========CHUONG TRINH QUAN LI CUA HANG===============");
			System.out.println("Cac chuc nang chinh");
			System.out.println("\t1.Cap nhat thong tin he thong");
			System.out.println("\t2.Quan ly ban hang");
			System.out.println("\t3.Quan ly don hang");
			System.out.println("\t0.Thoat");

			System.out.print("Lua chon chuc nang quan li:");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:SystemInformationManagement.excute();
				break;
			case 2:CartManagement.cartManagement();
				break;
			case 3:SaleOrderManagement.saleOrderManagement();
				break;
			case 0:
				System.out.println("Đã đóng chương trình");
				System.exit(0);
			default: System.out.println("Lua chon khong hop le");
			}
		} 
		while (true);
	}
}
