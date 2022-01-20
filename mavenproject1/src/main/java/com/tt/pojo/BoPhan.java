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
public class BoPhan {
    
    private static int MA_BO_PHAN = 0;
    
    private int maBoPhan;
    private String tenBoPhan;
    
    public BoPhan(String tenBoPhan){
        MA_BO_PHAN++;
        this.maBoPhan = MA_BO_PHAN;
        this.tenBoPhan = tenBoPhan;
    }

    /**
     * @return the maBoPhan
     */
    public int getMaBoPhan() {
        return maBoPhan;
    }

    /**
     * @param maBoPhan the maBoPhan to set
     */
    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    /**
     * @return the tenBoPhan
     */
    public String getTenBoPhan() {
        return tenBoPhan;
    }

    /**
     * @param tenBoPhan the tenBoPhan to set
     */
    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
    
    
}
