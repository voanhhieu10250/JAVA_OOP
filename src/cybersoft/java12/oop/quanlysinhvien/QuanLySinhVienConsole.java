package cybersoft.java12.oop.quanlysinhvien;

public class QuanLySinhVienConsole {
	public static void main(String[] args) {
		SinhVien SV01 = new SinhVien("SV01", "Vương Thiên Nhất",5,6,9);
		SinhVien SV02 = new SinhVien("SV02", "Trịnh Duy Đồng",7,8,9);
		SinhVien SV03 = new SinhVien("SV03", "Triệu Hâm Hâm",1,5,4);
		
		System.out.printf("Tên: %s, ĐTB: %.2f, Xếp loại: %s\n", SV01.getTen(), SV01.tinhDiemTrungBinh(), SV01.xepLoai());
		System.out.printf("Tên: %s, ĐTB: %.2f, Xếp loại: %s\n", SV02.getTen(), SV02.tinhDiemTrungBinh(), SV02.xepLoai());
		SV03.xuatThongTinXepLoai();
	}
}
