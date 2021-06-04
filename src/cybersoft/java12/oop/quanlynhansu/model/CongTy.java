package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class CongTy {
	private String ten;
	private String maSoThue;
	private double doanhThuThang;
	
	public void nhapThongTin(Scanner sc) {
		System.out.println("===NHẬP THÔNG TIN===");
		System.out.print("Mã số công ty: ");
		this.ten = sc.nextLine();
		System.out.print("Tên công ty: ");
		this.maSoThue = sc.nextLine();
		System.out.print("Số điện thoại: ");
		this.doanhThuThang = Double.parseDouble(sc.nextLine());
	}
	
	public void xuatThongTin() {
		System.out.println("===XUẤT THÔNG TIN CÔNG TY===");
		System.out.printf("Tên công ty: %s\n", ten);
		System.out.printf("Mã số thuế: %s\n", maSoThue);
		System.out.printf("Doanh thu tháng: %s\n",doanhThuThang);
	}
}
