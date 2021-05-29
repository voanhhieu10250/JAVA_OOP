package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class TruongPhong extends NhanSu {
	private int soNhanVien;
	
	public int getSoNhanVien() {
		return this.soNhanVien;
	}
	
	/* methods */
	
	// Override phương thức tinhLuong() ở lớp NhanSu
	@Override
	public float tinhLuong() {
		System.out.println("Phương thức tính lương ở lớp Trưởng Phòng");
		return super.tinhLuong() + soNhanVien * 100;
	}
	
	@Override
	public void nhapThongTin(Scanner sc) {
		System.out.println("Phuong thuc nhap thong tin o lop TruongPhong");
		super.nhapThongTin(sc);
		System.out.print("So nhan vien: ");
		this.soNhanVien = Integer.parseInt(sc.nextLine());
	}
	
	@Override
	public void xuatThongTin() {
		System.out.println("Phuong thuc xuat thong tin o lop TruongPhong");
		super.xuatThongTin();
		System.out.printf("So nhan vien: %s\n", soNhanVien);
	}
	
	@Override
	public String getChucVu() {
		return "Nhan Vien";
	}
}
