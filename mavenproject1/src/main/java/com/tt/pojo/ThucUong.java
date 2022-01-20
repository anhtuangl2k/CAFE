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
public class ThucUong extends ThucPham{
    
    private static int MA_THUC_UONG = 0;
    
    private int maThucUong;
    private String da;
    
    public ThucUong(String ten, double giaBan, String tinhTrang, String da){
        super(ten, giaBan, tinhTrang);
        MA_THUC_UONG++;
        this.maThucUong = MA_THUC_UONG;
        this.da = da;
    }

    /**
     * @return the maThucUong
     */
    public int getMaThucUong() {
        return maThucUong;
    }

    /**
     * @param maThucUong the maThucUong to set
     */
    public void setMaThucUong(int maThucUong) {
        this.maThucUong = maThucUong;
    }

    /**
     * @return the da
     */
    public String getDa() {
        return da;
    }

    /**
     * @param da the da to set
     */
    public void setDa(String da) {
        this.da = da;
    }

    
    
    
}
