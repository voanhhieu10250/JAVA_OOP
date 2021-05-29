package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class CongTy {
	private String ten;
	private String maSoThue;
	private double doanhThuThang;
	
	public void nhapThongTin(Scanner sc) {
		System.out.println("===NHẬP THÔNG TIN===");
		System.out.print("Mã số: ");
		this.ten = sc.nextLine();
		System.out.print("Họ tên: ");
		this.maSoThue = sc.nextLine();
		System.out.print("So dien thoai: ");
		this.doanhThuThang = Double.parseDouble(sc.nextLine());
	}
	
	public void xuatThongTin() {
		System.out.println("===XUẤT THÔNG TIN===");
		System.out.printf("Tên công ty: %d\n", ten);
		System.out.printf("Mã số thuế: %s\n", maSoThue);
		System.out.printf("Doanh thu tháng: %s\n",doanhThuThang);
	}
}
