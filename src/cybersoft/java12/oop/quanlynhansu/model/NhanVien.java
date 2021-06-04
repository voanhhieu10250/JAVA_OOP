package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class NhanVien extends NhanSu {
	private String truongPhong;
	
	
	public NhanVien(String hoTen, String soDienThoai
			, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
	}

	public NhanVien() {
		super();
	}
	
	public String getTruongPhong() {
		return truongPhong;
	}
	
	public void setTruongPhong(String truongPhong) {
		this.truongPhong = truongPhong;
	}
	
	@Override
	public void nhapThongTin(Scanner sc) {
		super.nhapThongTin(sc);
		System.out.print("Tên trưởng phòng trên quyền: ");
		this.truongPhong = sc.nextLine();
	}
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.printf("Ten truong phong: %s\n", truongPhong);
	}
	
	@Override
	public String getChucVu() {
		return "Nhan Vien";
	}
	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.truongPhong);
	}
}
