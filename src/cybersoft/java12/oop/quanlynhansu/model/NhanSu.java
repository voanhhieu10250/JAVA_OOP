package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class NhanSu {
	private String maSo;
	private String hoTen;
	private String soDienThoai;
	private float soNgayLam;
	private float luongMotNgay;
	
	public float tinhLuong() {
		return soNgayLam * luongMotNgay;
	}
	public void nhapThongTin(Scanner sc) {
		
	}
}
