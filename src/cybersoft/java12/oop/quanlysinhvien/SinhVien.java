package cybersoft.java12.oop.quanlysinhvien;

public class SinhVien {
	/* properties */
	private String maSo;
	private String ten;
	private float diemToan;
	private float diemLy;
	private float diemHoa;
	
	/* constructors */
	// [access-modifier] class-name (params){initial value}
	public SinhVien() {
		maSo = "MS01";
		ten = "Nguyen Van A";
		diemToan = 5;
		diemHoa = 5;
		diemLy = 5;
	}
	
	public SinhVien(String maSo, String ten, float diemToan, float diemLy,float diemHoa) {
		this.maSo = maSo;
		this.ten = ten;
		this.diemHoa = diemHoa;
		this.diemLy = diemLy;
		this.diemToan = diemToan;
//		this.diemHoa = 5;
//		this.diemLy = 5;
//		this.diemToan = 5;
	}
	/* getters / setters  *chỉ tạo đi cần thiết* */
	public String getTen() {
		return this.ten;
	}
	/* methods */
	public float tinhDiemTrungBinh() {
		return (diemToan + diemLy + diemHoa) / 3;
	}
	public String xepLoai() {
		float diemTb = this.tinhDiemTrungBinh();
		
		if(diemTb >= 9 && diemTb <=10) 
			return "Xuat sac";
		if(diemTb >= 8 && diemTb <=9) 
			return "Gioi";
		if(diemTb >= 7 && diemTb <=8) 
			return "Kha";
		if(diemTb >= 6 && diemTb <=7) 
			return "TB kha";
		if(diemTb >= 5 && diemTb <=6) 
			return "TB";
		if(diemTb <=5) 
			return "Yeu";
		return "";
	}
	public void xuatThongTinXepLoai() {
		System.out.printf("Tên: %s, ĐTB: %.2f, Xếp loại: %s\n", getTen(), tinhDiemTrungBinh(), xepLoai());
	}
}
