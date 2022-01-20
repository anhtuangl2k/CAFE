/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author anhtu
 */
public class Menu {
    
    public static void Menu(Scanner scanner) throws ParseException{
        int choose;
        boolean flag = true;
        
        System.out.println("1. Quan ly bo phan");
        System.out.println("2. Quan ly nhan vien");
        System.out.println("3. Quan ly thong tin ban");
        System.out.println("4. Quan ly thuc an va thuc uong");
        System.out.println("5. Sinh nhat sinh vien trong thang");
        System.out.println("6. Dat ban");
        System.out.println("7. Thanh toan");
        System.out.println("8. Thong ke");
        System.out.println("0. Thoat");
        
        do{
            do {
                System.out.println("Nhap chuc nang: ");
                choose = scanner.nextInt();
            }while (choose < 0 || choose > 8);
            
            switch(choose){
                case 1:
                    BoPhanService.menuBoPhan(scanner);
                    break;
                case 2:
                    NhanVienService.menuNhanVien(scanner);
                case 3:
                    BanService.menuBan(scanner);
                case 4:
                    ThucPhamService.menuThucPham(scanner);
                    break;
                case 5:
                    NhanVienService.danhSachSinhNhat();
                    break;
                case 6:
                    HoaDonService.chonBan();
                    break;
                case 0:
                    flag = false;
                    break;                
            }
            
        }while (flag);
        
        
    }
    
    
    
    
}
