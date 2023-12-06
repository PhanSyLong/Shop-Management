package vn.depro.storemanagement.update;

import java.util.Scanner;

import vn.depro.storemanagement.update.category.CategoryManagement;
import vn.depro.storemanagement.update.customer.CustomerManagement;
import vn.depro.storemanagement.update.product.ProductManagement;

public class SystemInformationManagement {
	public static void excute() {

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n===========CAP NHAT THONG TIN HE THONG===============");
			System.out.println("Cac chuc nang ");
			System.out.println("\t1.Cap nhat thong tin loai hang");
			System.out.println("\t2.Cap nhat thong tin hang hoa");
			System.out.println("\t3.cap nhat thong tin khach hang");
			System.out.println("\t0.Quay lai");

			System.out.print("Lua chon chuc nang quan li:");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:CategoryManagement.categoryUpdate();
				break;
			case 2: ProductManagement.productUpdate();
				break;
			case 3:	CustomerManagement.customerUpdate();
				break;
			case 0:
				System.out.println("Da Dong chuong trinh");
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}
}