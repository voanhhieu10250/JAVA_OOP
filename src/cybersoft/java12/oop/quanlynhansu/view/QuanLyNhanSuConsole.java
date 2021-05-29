package cybersoft.java12.oop.quanlynhansu.view;

import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.controller.QuanLyNhanSu;
import cybersoft.java12.oop.quanlynhansu.model.CongTy;
import cybersoft.java12.oop.quanlynhansu.model.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.model.NhanSu;
import cybersoft.java12.oop.quanlynhansu.model.NhanVien;
import cybersoft.java12.oop.quanlynhansu.model.TruongPhong;

public class QuanLyNhanSuConsole {
	/* properties */
	private static QuanLyNhanSu quanLyNhanSu;
	private static CongTy congTy;
	
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
			// show menu
			showMenu();
		
			// get user's choice
			choice = Integer.parseInt(scanner.nextLine());
		
			// process the function which has chosen
			processOption(choice, scanner);
			scanner.nextLine();
		} while(choice != 0); // show menu again
		
	}
	
	public static void showMenu() {
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
	public static void processOption(int choice, Scanner sc) {
		switch(choice) {
			case 1: // Nhập thông tin công ty
				congTy.nhapThongTin(sc);
				break;
			case 2:
				
				break;
			case 3:
				NhanSu newNhanSu;
				int loaiNhanSu = -1;
				
				System.out.println("Bạn muốn thêm: ");
				System.out.println("1. Nhan vien");
				System.out.println("2. Truong phong");
				System.out.println("3. Giam doc");
				System.out.println("0. Khong them nua");
				System.out.print("Lua chon");
				
				loaiNhanSu = Integer.parseInt(sc.nextLine());
				
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
				
				if(quanLyNhanSu.themNhanSu(newNhanSu))
					System.out.println("Đã thêm nhân sự thành công");
				else
					System.out.println("Thêm nhận sự thất bại");
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 11:
				
				break;
			case 0:
				
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ");
				break;
		}
	}
}
