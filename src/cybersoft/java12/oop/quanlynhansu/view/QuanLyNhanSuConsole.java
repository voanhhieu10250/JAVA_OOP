package cybersoft.java12.oop.quanlynhansu.view;

import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.controller.QuanLyNhanSu;
import cybersoft.java12.oop.quanlynhansu.model.CongTy;
import cybersoft.java12.oop.quanlynhansu.model.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.model.NhanSu;
import cybersoft.java12.oop.quanlynhansu.model.NhanVien;
import cybersoft.java12.oop.quanlynhansu.model.TruongPhong;
import cybersoft.java12.oop.quanlynhansu.view.util.CheckNumeric;

public class QuanLyNhanSuConsole {
	/* properties */
	private QuanLyNhanSu quanLyNhanSu;
	private CongTy congTy;
	
	/* contructors */
	public QuanLyNhanSuConsole() {
		quanLyNhanSu = new QuanLyNhanSu();
		congTy = new CongTy();
	}
	
	/* main to run program */
	public void start() {
		// main program
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		
		do {
			congTy.xuatThongTin();
			quanLyNhanSu.xuatDanhSachNhanSu();
			// show menu
			showMenu();
		
			// get user's choice
			choice = Integer.parseInt(scanner.nextLine());
		
			// process the function which has chosen
			processOption(choice, scanner);
			scanner.nextLine();
			if(choice == 0) System.out.println("Bye!!!!!");
		} while(choice != 0); // show menu again
		
	}
	
	public static void showMenu() {
		System.out.println("");
		System.out.println("=== QUẢN LÝ NHÂN SỰ ===");
		System.out.println("1. Nhập thông tin công ty");
		System.out.println("2. Phân bổ Nhân viên vào Trưởng phòng");
		System.out.println("3. Thêm thông tin một nhân sự (có thể là Nhân viên, trưởng phòng hoặc giám đốc)");
		System.out.println("4. Xóa thông tin một nhân sự");
		System.out.println("5. Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("6. Tính và xuất tổng lương cho toàn công ty");
		System.out.println("7. Tìm Nhân viên thường có lương cao nhất");
		System.out.println("8. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("9. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("11. Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("12. Tính và Xuất tổng THU NHẬP của từng Giám Đốc");
		System.out.println("0. Kết thúc chương trình");
		System.out.print("Lựa chọn: ");
	}
	public void processOption(int choice, Scanner sc) {
		switch (choice) {
			case 1: // nhập thông tin công ty
				congTy.nhapThongTin(sc);
				break;
			case 2: // Phân bổ nhân viên
				quanLyNhanSu.phanDoNhanVien(sc);
				break;
			case 3: // Thêm nhân sự
				themNhanSu(sc);
				break;
			case 4: // Xóa nhân sự
				xoaNhanSu(sc);
				break;
			case 5: // Xuất danh sách nhân sự
				quanLyNhanSu.xuatDanhSachNhanSu();
				break;
			case 6: // Tính và xuất tổng lương
				float tongLuong = quanLyNhanSu.tinhTongLuong();
				System.out.println("-----------------------------");
				System.out.printf("Tổng lương của toàn công ty trong 1 tháng là: %.2f\n", tongLuong);
				System.out.println("-----------------------------");
				break;
			case 7: // Tìm nhân viên thường có mức lương cao nhất
				quanLyNhanSu.timNhanVienLuongCaoNhat();
				break;
			case 8: // Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất
				quanLyNhanSu.timTruongPhongCoNhieuNhatNhanVien();
				break;
			case 9: // Sắp xếp nhân viên toàn công ty theo thứ tự abc
				quanLyNhanSu.sortDsNsTheoTen();
				break;
			case 10: // Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần
				quanLyNhanSu.sortDescendingTheoluong();
				break;
			case 11: // Tìm Giám Đốc có số lượng cổ phần nhiều nhất
				quanLyNhanSu.giamDocCoCoPhanCaoNhat();
				break;
			case 12: // Tính và Xuất tổng THU NHẬP của từng Giám Đốc
				quanLyNhanSu.thuNhapCuaTungGiamDoc(congTy.getDoanhThuThang());
				break;
			case 0:
				System.out.println("Thank you.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ.");
				break;
		}
	}

	private void themNhanSu(Scanner sc) {
		NhanSu newNhanSu;
		int loaiNhanSu = 0;
		
		System.out.println("");
		System.out.println("=== THÊM NHÂN SỰ === ");
		System.out.println("");
		System.out.println("Bạn muốn thêm: ");
		System.out.println("1. Nhân viên.");
		System.out.println("2. Trưởng phòng.");
		System.out.println("3. Giám đốc.");
		System.out.println("0. Không thêm nữa.");
		System.out.print("Lựa chọn: ");

		loaiNhanSu = Integer.parseInt(sc.nextLine());
		System.out.println("");

		switch (loaiNhanSu) {
			case 1:
				newNhanSu = new NhanVien();
				break;
			case 2:
				newNhanSu = new TruongPhong();
				break;
			case 3:
				newNhanSu = new GiamDoc();
				break;
			default:
				return;
		}

		newNhanSu.nhapThongTin(sc);

		if (quanLyNhanSu.themNhanSu(newNhanSu))
			System.out.println("Đã thêm nhân sự thành công.");
		else
			System.out.println("Thêm nhân sự thất bại.");
	}
	
	private void xoaNhanSu(Scanner sc) {
		String msNV;
		
		System.out.println("");
		System.out.println("=== XÓA NHÂN SỰ === ");
		System.out.println("");
		System.out.print("Nhập mã số của nhân sự muốn xóa: ");
		
		msNV = sc.nextLine();
		if(!CheckNumeric.isNumeric(msNV)) {
			System.out.println("Mã số không hợp lệ!");
			System.out.println("Xóa nhân sự thất bại.");
			return;
		}
			
		System.out.println("");

		if (quanLyNhanSu.xoaNhanSu(Integer.parseInt(msNV), sc))
			System.out.println("Đã xóa nhân sự thành công.");
		else
			System.out.println("Xóa nhân sự thất bại.");
	}
}
