package cybersoft.java12.oop.quanlynhansu.main;

import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.oop.quanlynhansu.model.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.model.NhanSu;
import cybersoft.java12.oop.quanlynhansu.model.NhanVien;
import cybersoft.java12.oop.quanlynhansu.model.TruongPhong;

public class MainProgram {
	public static void main(String[] args) {
		NhanSu nhanSu = new NhanSu();
		NhanVien nhanVien = new NhanVien();
		TruongPhong truongPhong = new TruongPhong();
		GiamDoc giamDoc = new GiamDoc();
		
		List<NhanVien> dsNhanVien;
		List<TruongPhong> dsTruongPhong;
		List<GiamDoc> dsGiamDoc;
		
		List<NhanSu> dsNhanSu = new LinkedList<NhanSu>();
		
		dsNhanSu.add(nhanVien);
		dsNhanSu.add(truongPhong);
		dsNhanSu.add(giamDoc);
		
//		System.out.println(nhanVien instanceof TruongPhong);
		System.out.println(nhanVien instanceof NhanSu);
		System.out.println(nhanSu instanceof NhanVien);
		
		System.out.println("Program has been ended");
	}
}
