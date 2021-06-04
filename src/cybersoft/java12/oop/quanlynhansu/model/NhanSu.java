package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.view.util.CheckNumeric;

public abstract class NhanSu {
	/* Properties */
	private int maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected float soNgayLam;
	protected float luongMotNgay;
	private static int STT = 1;
	
	/* constructors */
	public NhanSu() {
		this.maSo = STT++;
	}
	
	public NhanSu(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		this.maSo = STT++;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLam = soNgayLam;
		this.luongMotNgay = luongMotNgay;
	}
	
	/* getters/setters */
	
	public int getMaSo() {
		return maSo;
	}
	
	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public float getSoNgayLam() {
		return soNgayLam;
	}


	public void setSoNgayLam(float soNgayLam) {
		this.soNgayLam = soNgayLam;
	}


	public float getLuongMotNgay() {
		return luongMotNgay;
	}


	public void setLuongMotNgay(float luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}


	public static int getSTT() {
		return STT;
	}


	public static void setSTT(int sTT) {
		STT = sTT;
	}


	public void setMaSo(int maSo) {
		this.maSo = maSo;
	}


	/* Methods */
	public float tinhLuong() {
		return soNgayLam * luongMotNgay;
	}
	public void nhapThongTin(Scanner sc) {
		boolean error = false;
		
		System.out.println("===NHẬP THÔNG TIN===");
		
		do {
			try {
				System.out.print("Mã số: ");
				this.maSo = Integer.parseInt(sc.nextLine());
				error = false;
			} catch (Exception e) {
				error = true;
				System.out.println("Mã số không hợp lệ vui lòng nhập lại (only số)");
			}
		} while (error);
		
		System.out.print("Họ tên: ");
		this.hoTen = sc.nextLine();
		System.out.print("So dien thoai: ");
		this.soDienThoai = sc.nextLine();
		do {
			try {
				System.out.print("Số ngày làm: ");
				this.soNgayLam = Float.parseFloat(sc.nextLine());
				error = false;
			} catch (Exception e) {
				error = true;
				System.out.println("Số ngày làm không hợp lệ vui lòng nhập lại (only số)");
			}
		} while (error);
		
		do {
			try {
				System.out.print("Lương một ngày: ");
				this.luongMotNgay = Float.parseFloat(sc.nextLine());
				error = false;
			} catch (Exception e) {
				error = true;
				System.out.println("Lương một ngày không hợp lệ vui lòng nhập lại (only số)");
			}
		} while (error);
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
	public abstract String getThongTinThem();
}
