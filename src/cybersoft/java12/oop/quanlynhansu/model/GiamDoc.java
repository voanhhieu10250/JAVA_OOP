package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
	private float coPhan;
	
	@Override
	public void nhapThongTin(Scanner sc) {
		System.out.println("Phuong thuc nhap thong tin o lop GiamDoc");
		super.nhapThongTin(sc);
		System.out.print("So co phan: ");
		this.coPhan = Float.parseFloat(sc.nextLine());
	}
	
	@Override
	public void xuatThongTin() {
		System.out.println("Phuong thuc xuat thong tin o lop GiamDoc");
		super.xuatThongTin();
		System.out.printf("So co phan: %s\n", coPhan);
	}
	
	@Override
	public String getChucVu() {
		return "Giam Doc";
	}
}
