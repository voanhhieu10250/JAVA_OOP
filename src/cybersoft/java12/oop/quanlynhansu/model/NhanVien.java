package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class NhanVien extends NhanSu {
	private String truongPhong;
	
	
	@Override
	public void nhapThongTin(Scanner sc) {
		System.out.println("Phuong thuc nhap thong tin o lop NhanVien");
		super.nhapThongTin(sc);
		System.out.print("Ten truong phong: ");
		this.truongPhong = sc.nextLine();
	}
	
	@Override
	public void xuatThongTin() {
		System.out.println("Phuong thuc xuat thong tin o lop NhanVien");
		super.xuatThongTin();
		System.out.printf("Ten truong phong: %s\n", truongPhong);
	}
	
	@Override
	public String getChucVu() {
		return "Nhan Vien";
	}
}
