package cybersoft.java12.oop.quanlynhansu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.model.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.model.NhanSu;
import cybersoft.java12.oop.quanlynhansu.model.NhanVien;
import cybersoft.java12.oop.quanlynhansu.model.TruongPhong;
import cybersoft.java12.oop.quanlynhansu.view.util.PrintFormat;

public class QuanLyNhanSu {
	/* properties */
	private List<NhanSu> dsNhanSu;

	/* constructors */
	public QuanLyNhanSu() {
		dsNhanSu = new LinkedList<NhanSu>();
		
		dsNhanSu.add(new NhanVien("Tuấn", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Vương", "114", 20, 200));
		dsNhanSu.add(new NhanVien("Thiên", "115", 20, 200));
		dsNhanSu.add(new NhanVien("Nhất", "116", 20, 200));
		dsNhanSu.add(new NhanVien("Trịnh", "117", 20, 200));
		dsNhanSu.add(new NhanVien("Duy", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Đồng", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Nguyễn Thành Bảo", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Triệu", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Hâm", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Hâm", "113", 20, 200));
		
		dsNhanSu.add(new TruongPhong("Hoàn", "113", 20, 300));
		dsNhanSu.add(new TruongPhong("Khoa", "113", 20, 300));
		
		dsNhanSu.add(new GiamDoc("Phúc", "225", 20, 500));
	}

	/* methods */
	public boolean themNhanSu(NhanSu nhanSu) {
		if(nhanSu == null)
			return false;
		
		if(nhanSu.getMaSo() == 0) {
			System.out.println("Mã số không hợp lệ");
			return false;
		}
			
		for(NhanSu ns : dsNhanSu) {
			if(ns.getMaSo() == nhanSu.getMaSo()) {
				System.out.println("Mã số đã tồn tại");
				return false;
			}
		}
		return dsNhanSu.add(nhanSu);
	}
	
	public boolean xoaNhanSu(int maSo, Scanner sc) {
		int luaChon;
		
		for(int i = 0; i < dsNhanSu.size(); i++) {
			if(dsNhanSu.get(i).getMaSo() == maSo) {
				System.out.println("Bạn có chắc chắn muốn xóa nhân sự này ra khỏi công ty ko?");
				System.out.println("");
				System.out.println("1. Chắc chắn");
				System.out.println("0. Hủy");
				System.out.println("");
				System.out.print("Lựa chọn: ");
				luaChon = Integer.parseInt(sc.nextLine());
				if(luaChon == 1) {
					// check nếu là nhân viên giảm số lượng nhân viên dưới quyền của Trưởng phòng quản lý nhân viên này
					if(dsNhanSu.get(i) instanceof NhanVien) {
						for (NhanSu ns : dsNhanSu) {
							if(ns.getHoTen() == ((NhanVien) dsNhanSu.get(i)).getTruongPhong())
								((TruongPhong) ns).giamSoNhanVien();
						}
					}
					
					// check nếu là trưởng phòng xóa tất cả nhân viên dưới quyền của trưởng phòng này
					if(dsNhanSu.get(i) instanceof TruongPhong) {
						for (NhanSu ns : dsNhanSu) {
							if(ns instanceof NhanVien) 
								if(((NhanVien) ns).getTruongPhong() == dsNhanSu.get(i).getHoTen())
									((NhanVien) ns).setTruongPhong(null);
						}
					}
					dsNhanSu.remove(i);
					return true;
				} else return false;
			}
		}
		System.out.println("Không tìm thấy nhân sự cần xóa.");
		return false;
	}
	
	public void phanDoNhanVien(Scanner sc) {
		List<NhanVien> dsNhanVienChuaPhanBo = new ArrayList<NhanVien>();
		List<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
		int luaChon = -1;
		/*
		 * Trính xuất danh sách nhân viên chưa đc phân bổ và danh sách trưởng phòng từ danh sách nhân sự
		 * from 15:35 -> 15:45
		 * */
		
		for (NhanSu ns : dsNhanSu) {
			if(ns instanceof NhanVien) {
				if(((NhanVien) ns).getTruongPhong() == null)
					dsNhanVienChuaPhanBo.add((NhanVien)ns);
			}
			if(ns instanceof TruongPhong)
				dsTruongPhong.add((TruongPhong) ns);
		}

		System.out.println("");
		System.out.println("==== PHÂN BỔ NHÂN VIÊN ===");
		// cho người dùng phân bổ từng nhân viên
		for(NhanVien nv : dsNhanVienChuaPhanBo) {
			System.out.println("");
			System.out.printf("==== NHÂN VIÊN %d ===\n", nv.getMaSo());
			nv.xuatThongTin();
			drawLine(20);
			System.out.println("Chọn trưởng phòng để phân bổ");
			for(int i = 0; i < dsTruongPhong.size(); i++) {
				TruongPhong tp = dsTruongPhong.get(i);
				System.out.printf("%d. %20s %5d\n", i+1, tp.getHoTen(), tp.getMaSo());
			}
			drawLine(20);
			System.out.println("0. Không phân bổ");
			System.out.println("-1. Thoát chức năng phân bổ");
			drawLine(20);
			System.out.print("Lựa chọn: ");
			luaChon = Integer.parseInt(sc.nextLine());
			
			if(luaChon == 0)
				continue;
			if(luaChon > 0 && luaChon <= dsTruongPhong.size()) {
				nv.setTruongPhong(dsTruongPhong.get(luaChon - 1).getHoTen());
				dsTruongPhong.get(luaChon - 1).tangSoNhanVien();
			} else {
				System.out.println("Lựa chọn không hợp lệ. Vui lòng tiến hành phân bổ lần sau.");
			}
		}
		System.out.println("=== Phân bổ hoàn tất ===");
		xuatDanhSachNhanSu();
	}	
	
	public float tinhTongLuong() {
		float tongLuong = 0;
		
		for (NhanSu nhanSu : dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}
		
		return tongLuong;
	}
	
	public void timNhanVienLuongCaoNhat() {
		List<NhanVien> dsNhanVienThuong = new ArrayList<NhanVien>();
		NhanSu nvLuongCaoNhat;
		
		for(NhanSu ns : dsNhanSu) {
			if(ns instanceof NhanVien) dsNhanVienThuong.add((NhanVien) ns);
		}
		nvLuongCaoNhat = dsNhanVienThuong.get(0);
		for(NhanVien nv: dsNhanVienThuong) {
			if(nv.tinhLuong() > nvLuongCaoNhat.tinhLuong()) 
				nvLuongCaoNhat = nv;
		}
		drawLine(20);
		System.out.printf("Nhân viên thường có lương cao nhất là %s, với mức lương là %.2f/tháng\n",nvLuongCaoNhat.getHoTen(), nvLuongCaoNhat.tinhLuong());
		drawLine(20);
	}
	
	public void timTruongPhongCoNhieuNhatNhanVien() {
		List<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
		TruongPhong truongPhongNhieuNvNhat;
		
		for(NhanSu ns : dsNhanSu) {
			if(ns instanceof TruongPhong) dsTruongPhong.add((TruongPhong) ns);
		}
		truongPhongNhieuNvNhat = dsTruongPhong.get(0);
		for(TruongPhong tp: dsTruongPhong) {
			if(tp.getSoNhanVien() > truongPhongNhieuNvNhat.getSoNhanVien()) 
				truongPhongNhieuNvNhat = tp;
		}
		drawLine(20);
		System.out.printf("Trưởng phòng có số lượng nhân viên dưới quyền cao nhất là %s, tổng cộng %d nhân viên\n",truongPhongNhieuNvNhat.getHoTen(), truongPhongNhieuNvNhat.getSoNhanVien());
		drawLine(20);
	}
	
	public void xuatDanhSachNhanSu() {
		int width = 160;
		// in header
		drawLine(width);
		System.out.printf(PrintFormat.HEADER_FORMAT
				,"STT", "Mã số", "Họ tên", "Số điện thoại", "Số ngày làm"
				,"Lương một ngày", "Lương", "Chức vụ", "Trưởng phòng/Số nhân viên/Cổ phần");
		drawLine(width);
		// in body
		for (int i = 0; i < dsNhanSu.size(); i++) {
			NhanSu ns = dsNhanSu.get(i);
			System.out.printf(PrintFormat.BODY_FORMAT
					, i+1, ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai()
					, ns.getSoNgayLam(), ns.getLuongMotNgay(), ns.tinhLuong()
					, ns.getChucVu(), ns.getThongTinThem());
		}
		// in bottom
		drawLine(width);
		System.out.printf(PrintFormat.BOTTOM_FORMAT, "Tổng lương"
				, this.tinhTongLuong(), "");
		drawLine(width);
	}
	
	public void sortDsNsTheoTen() {
		List<NhanSu> dsNhanSuDaSort = new ArrayList<NhanSu>();
		String[] dsTenToanCTy = new String[dsNhanSu.size()];
		int temp = 0;
		
		for(int i = 0; i < dsNhanSu.size(); i++) {
			dsTenToanCTy[i] = dsNhanSu.get(i).getHoTen();
		}
		
		Arrays.sort(dsTenToanCTy);
		drawLine(20);
		System.out.println(Arrays.toString(dsTenToanCTy));
		drawLine(20);
		
	
//		for(int i = 0; i < dsNhanSu.size(); i++) {
//			temp = 0;
//			do {
//				if(dsNhanSu.get(temp).getHoTen() == dsTenToanCTy[i]) {
//					dsNhanSuDaSort.add(dsNhanSu.get(i));
//					temp = 0;
//				} else {
//					temp++;
//				}
//			} while (temp != 0);
//		}
	}
	
	public void sortDescendingTheoluong() {
		int width = 160;
		NhanSu[] dsNhanSuDaSort = new NhanSu[dsNhanSu.size()];
		
		for(int i = 0; i < dsNhanSu.size(); i++) {
			dsNhanSuDaSort[i] = dsNhanSu.get(i);
		}
		
		NhanSu temp = dsNhanSuDaSort[0];
        for (int i = 0 ; i < dsNhanSu.size() - 1; i++) {
            for (int j = i + 1; j < dsNhanSu.size(); j++) {
                if (dsNhanSu.get(i).tinhLuong() < dsNhanSu.get(j).tinhLuong()) {
                    temp = dsNhanSuDaSort[j];
                    dsNhanSuDaSort[j] = dsNhanSuDaSort[i];
                    dsNhanSuDaSort[i] = temp;
                }
            }
        }
        
        drawLine(width);
		System.out.printf(PrintFormat.HEADER_FORMAT
				,"STT", "Mã số", "Họ tên", "Số điện thoại", "Số ngày làm"
				,"Lương một ngày", "Lương", "Chức vụ", "Trưởng phòng/Số nhân viên/Cổ phần");
		drawLine(width);
		// in body
		for (int i = 0; i < dsNhanSu.size(); i++) {
			NhanSu ns = dsNhanSuDaSort[i];
			System.out.printf(PrintFormat.BODY_FORMAT
					, i+1, ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai()
					, ns.getSoNgayLam(), ns.getLuongMotNgay(), ns.tinhLuong()
					, ns.getChucVu(), ns.getThongTinThem());
		}
		// in bottom
		drawLine(width);
	}
	
	private void drawLine(int length) {
		for(int i = 0; i < length; i++)
			System.out.print("-");
		System.out.println();
	}
}
