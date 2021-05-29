package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public abstract class NhanSu {
	/* Properties */
	protected int maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected float soNgayLam;
	protected float luongMotNgay;
	
	/* constructors */
	
	/* getters/setters */
	
	public int getMaSo() {
		return maSo;
	}
	
	/* Methods */
	public float tinhLuong() {
		return soNgayLam * luongMotNgay;
	}
	public void nhapThongTin(Scanner sc) {
		System.out.println("===NHẬP THÔNG TIN===");
		System.out.print("Mã số: ");
		this.maSo = Integer.parseInt(sc.nextLine());
		System.out.print("Họ tên: ");
		this.hoTen = sc.nextLine();
		System.out.print("So dien thoai: ");
		this.soDienThoai = sc.nextLine();
		System.out.print("So ngay lam: ");
		this.soNgayLam = Float.parseFloat(sc.nextLine());
		System.out.print("Luong mot ngay: ");
		this.luongMotNgay = Float.parseFloat(sc.nextLine());
	}
	
	public void xuatThongTin() {
		System.out.println("===XUẤT THÔNG TIN===");
		System.out.printf("Mã số: %d\n", maSo);
		System.out.printf("Họ tên: %s\n", hoTen);
		System.out.printf("Chức vụ: %s\n", getChucVu());
		System.out.printf("Số điện thoại: %s\n", soDienThoai);
		System.out.printf("Số ngày làm: %.2f\n", soNgayLam);
		System.out.printf("Lương một ngày: %.2f\n", luongMotNgay);
	}
	
	public abstract String getChucVu();
}
