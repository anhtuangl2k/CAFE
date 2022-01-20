/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojo;

/**
 *
 * @author anhtu
 */
public class Ban {

	private static int ma = 0;

	private String maBan;
	private String sucChua;
	private String tinhTrang;

	// Nothing special
	
	public Ban(String maBan, String sucChua, String tinhTrang) {
		this.maBan = maBan;
		this.sucChua = sucChua;
		this.tinhTrang = tinhTrang;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}

	public String getSucChua() {
		return sucChua;
	}

	public void setSucChua(String sucChua) {
		this.sucChua = sucChua;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
