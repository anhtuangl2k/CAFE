/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author anhtu
 */
public class HoaDon {
    
    private static int MA_HOA_DON = 0;
    
    private int maHoaDon;
    private ArrayList<ThucAn> listThucAnHoaDon = new ArrayList<ThucAn>();
    private ArrayList<ThucUong> listThucUongHoaDon = new ArrayList<ThucUong>();
    private Double tongTien;
    private Date ngayTao;

    public HoaDon(ArrayList<ThucAn> listThucAn, ArrayList<ThucUong> listThucUong, Double tongTien, Date ngayTao) {
        MA_HOA_DON++;
        this.maHoaDon = MA_HOA_DON;
        this.listThucAnHoaDon = listThucAn;
        this.listThucUongHoaDon = listThucUong;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
    }
    
    

    /**
     * @return the maHoaDon
     */
    public int getMaHoaDon() {
        return maHoaDon;
    }

    /**
     * @param maHoaDon the maHoaDon to set
     */
    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    /**
     * @return the listThucAnHoaDon
     */
    public ArrayList<ThucAn> getListThucAnHoaDon() {
        return listThucAnHoaDon;
    }

    /**
     * @param listThucAnHoaDon the listThucAnHoaDon to set
     */
    public void setListThucAnHoaDon(ArrayList<ThucAn> listThucAnHoaDon) {
        this.listThucAnHoaDon = listThucAnHoaDon;
    }

    /**
     * @return the listThucUongHoaDon
     */
    public ArrayList<ThucUong> getListThucUongHoaDon() {
        return listThucUongHoaDon;
    }

    /**
     * @param listThucUongHoaDon the listThucUongHoaDon to set
     */
    public void setListThucUongHoaDon(ArrayList<ThucUong> listThucUongHoaDon) {
        this.listThucUongHoaDon = listThucUongHoaDon;
    }

    /**
     * @return the tongTien
     */
    public Double getTongTien() {
        return tongTien;
    }

    /**
     * @param tongTien the tongTien to set
     */
    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    /**
     * @return the ngayTao
     */
    public Date getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
     
     
}
