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
public class ThucAn extends ThucPham{
    
    private static int MA_THUC_AN = 0;
    private int maThucAn;
    private String thucPhamChay;
   
    public ThucAn(String ten, double giaBan, String tinhTrang, String thucPhamChay){
        super(ten, giaBan, tinhTrang);
        MA_THUC_AN++;        
        this.maThucAn = MA_THUC_AN;
        this.thucPhamChay = thucPhamChay;
    }    

    /**
     * @return the maThucAn
     */
    public int getMaThucAn() {
        return maThucAn;
    }

    /**
     * @param maThucAn the maThucAn to set
     */
    public void setMaThucAn(int maThucAn) {
        this.maThucAn = maThucAn;
    }

    /**
     * @return the thucPhamChay
     */
    public String getThucPhamChay() {
        return thucPhamChay;
    }

    /**
     * @param thucPhamChay the thucPhamChay to set
     */
    public void setThucPhamChay(String thucPhamChay) {
        this.thucPhamChay = thucPhamChay;
    }

    
    
    
}
