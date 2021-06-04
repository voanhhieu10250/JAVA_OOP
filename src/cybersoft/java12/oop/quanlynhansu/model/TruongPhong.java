package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class TruongPhong extends NhanSu {
	private int soNhanVien;
	
	public TruongPhong(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
		// TODO Auto-generated constructor stub
	}

	public TruongPhong() {
		super();
	}
	
	public int getSoNhanVien() {
		return this.soNhanVien;
	}
	
	/* methods */
	public void tangSoNhanVien() {
		this.soNhanVien += 1;
	}
	
	public void giamSoNhanVien() {
		this.soNhanVien -= 1;
	}
	
	// Override phương thức tinhLuong() ở lớp NhanSu
	@Override
	public float tinhLuong() {
		return super.tinhLuong() + soNhanVien * 100;
	}
	
	@Override
	public void nhapThongTin(Scanner sc) {
		super.nhapThongTin(sc);
		System.out.print("So nhan vien: ");
		this.soNhanVien = Integer.parseInt(sc.nextLine());
	}
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.printf("So nhan vien: %s\n", soNhanVien);
	}
	
	@Override
	public String getChucVu() {
		return "Truong Phong";
	}
	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.soNhanVien);
	}
}
