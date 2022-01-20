/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import com.tt.pojo.ThucAn;
import com.tt.pojo.ThucUong;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anhtu
 */
public class HoaDonService {
    
    
    
    public static void chonBan(){
        
        BanService.layBanTrong();
        System.out.println("0. Thoat");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chon ma ban: ");
        
        
        boolean flag = true;
        
        String maBan = scanner.nextLine();
        
        for (int i = 0; i < BanService.getListBan().size(); i++){
            System.out.println(BanService.getListBan().get(i).getTinhTrang() + BanService.getListBan().get(i).getMaBan());
            if(BanService.getListBan().get(i).getTinhTrang().equals("trong") && 
                    BanService.getListBan().get(i).getMaBan().equals(maBan)){  
                flag = false;
                break;
            }
        }
        
        if(flag == false){
           ThucPhamService.danhSachThucAn();
           System.out.println("0. Thoat");
        }else{
            System.out.println("Ma ban khong phu hop");
        }
        List<ThucAn> listThucAn = new ArrayList<ThucAn>();
        
        int slm;
        System.out.println("Chon so luong mon");
        slm = scanner.nextInt();
        
        double tongTien = 0;
        int soLuong = 0;
        
        while(listThucAn.size() < slm){
            System.out.println("Vui long chon ma mon");
            int mon = scanner.nextInt();
            listThucAn.add(ThucPhamService.getMonAn(mon));
            soLuong++;
            tongTien += ThucPhamService.getMonAn(mon).getGiaBan();
        }
        
        int sln;
        System.out.println("Chon so luong nuoc");
        sln = scanner.nextInt();
        List<ThucUong> listThucUong = new ArrayList<ThucUong>();
        while(listThucUong.size() < sln){
            System.out.println("Vui long chon ma nuoc");
            int nuoc = scanner.nextInt();
            listThucUong.add(ThucPhamService.getThucUong(nuoc));
            soLuong++;
            tongTien += ThucPhamService.getThucUong(nuoc).getGiaBan();
        }
        
        System.out.println("So luong mon: " + soLuong);
        System.out.println("Tong tien: " + tongTien);
        
        
        
        
    }
    
    
    
}
