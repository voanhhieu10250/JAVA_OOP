package cybersoft.java12.oop.quanlynhansu.controller;

import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.oop.quanlynhansu.model.NhanSu;

public class QuanLyNhanSu {
	/* properties */
	private List<NhanSu> dsNhanSu;

	/* constructors */
	public QuanLyNhanSu() {
		dsNhanSu = new LinkedList<NhanSu>();
	}

	/* methods */
	public boolean themNhanSu(NhanSu nhanSu) {
		if(nhanSu == null)
			return false;
		
		if(nhanSu.getMaSo() == 0) 
			return false;
		
		for(NhanSu ns : dsNhanSu) {
			if(ns.getMaSo() == nhanSu.getMaSo())
				return false;
		}
		return dsNhanSu.add(nhanSu);
	}
	
	public boolean xoaNhanSu(int maSo) {
		return true;
	}
}
