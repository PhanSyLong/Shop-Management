package vn.depro.storemanagement.sale;

import java.util.Scanner;

import vn.depro.storemanagement.saleorder.SaleOrderManagement;
import vn.depro.storemanagement.update.customer.Customer;
import vn.depro.storemanagement.update.customer.CustomerManagement;

public class CartManagement { // Phien giao dich cua khach mua hang
	// Nhan mot gio hang moi -> Khoi tao gio hang
	// Khac se thuc hien cac thao tac
	// + Hien thi thong tin gio hang
	// + Dua hang vao gio
	// + Chon so luong hang can mua
	// + Xoa hanng ra khoi gio
	// + Thanh toan
	// + Huy gio hang
	static Scanner sc = new Scanner(System.in);
	public static int autoId = 1;
	public static void cartManagement() {

		Cart cart = new Cart(); // Khoi tao gio hang moi
		System.out.println("Welcome to Supper Store");
		do {
			System.out.println("HAY CHON TAO TAC VOI GIO HANG CUA BAN");
			System.out.println("\t1.Hien thi thong tin gio hang.");
			System.out.println("\t2.Dua hang vao gio.");
			System.out.println("\t3.Sua thong tin gio hang.");
			System.out.println("\t4.Xoa hang ra khoi gio.");
			System.out.println("\t5.Huy gio hang");
			System.out.println("\t6.Thanh toan");
			System.out.println("\t0.Thoat");

			System.out.println("LUA CHON CUA QUY KHACH LA:");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				cart.display();
				break;
			case 2:
				cart.add();
				break;
			case 3:
				cart.update();
				break;
			case 4:
				cart.remove();
				break;
			case 5:
				cart = new Cart(); // Huy gio hang
				System.out.println("Da huy gio hang cua ban");
				break;
			case 6:
				if(payment(cart)) {; // Thanh toan(Order) thanh cong
				cart = new Cart();
				}
				break;
			case 0:
				return;
			default:
				System.err.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static boolean payment(Cart cart) {		// Thanh toan (order) gio hang
		if(cart == null || cart.getList().size() <= 0) {// Gio chua co hang
			System.out.println("Gio hang khong co hang:");
			return false;
		}
		
		System.out.println("===========THANH TOAN GIO HANG==========");
		// Cap nhat thong tin khach hang
		System.out.println("Nhap ma(id) khach hang:");
		int customerId = Integer.parseInt(sc.nextLine());
		
		// Kiem tra khach hang da co trong danh sach hay chua
		int index = CustomerManagement.indexOfCustomer(customerId);
		String customerName = null;
		
		if(index == -1) {//Khach hang chua co trong danh sach
		System.out.println("Nhap ho ten khach hang: ");
		customerName = sc.nextLine();
		if(customerName.trim().length() <= 0) {
			System.out.println("Tên khách hàng không được để trống");
			return false;
			}
		
		//Them khach hang vao danh sach
		customerId = CustomerManagement.autoId;
		CustomerManagement.getList().add(new Customer(customerId, customerName));
		}
		else {//Khach hang da co trong danh sach
			customerName = CustomerManagement.getList().get(index).getName();
		}
		
		// Cap nhat thong tin cho gio hang
		cart.setId(autoId++);
		cart.setCustomerId(customerId);
		
		//Hien thi lai gio hang cho khach xem
		cart.display();
		
		//Luu gio hang vao danh sach
		SaleOrderManagement.getCarts().add(cart);
		
		//Xoa gio hang
		System.out.println("Thanh toan gio hang thanh cong");
		return true;
	}
}
