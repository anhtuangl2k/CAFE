/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import com.tt.pojo.BoPhan;
import com.tt.pojo.NhanVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author anhtu
 */
public class NhanVienService {
    
    private static ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
    
    public static void addNhanVien() throws ParseException{
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        listNhanVien.add(new NhanVien("Tuan", "Nam", d.parse("20/1/2000"), "Gia Lai", d.parse("20/1/2021"), BoPhanService.getBoPhan(1)));
    }
        
        
    
    public static void menuNhanVien(Scanner scanner) throws ParseException{

        int chooseBoPhan;
        boolean flag = true;

        System.out.println("1. Them nhan vien");
        System.out.println("2. Xoa  nhan vien");
        System.out.println("3. Sua nhan vien ");
        System.out.println("4. Danh sách nhan vien ");
        System.out.println("0. Thoat");

        do{
            do{
                System.out.println("Nhap chuc nang: ");
                chooseBoPhan = scanner.nextInt();       
            }while (chooseBoPhan < 0 || chooseBoPhan > 4);
            // xét case
            switch(chooseBoPhan){
                case 1:
                    themNhanVien();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    danhSachNhanVien();
                    break;
                default:

                    flag = false;
                    break;
            }
        }while(flag);                  
    }

    public static void themNhanVien() throws ParseException{
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);        
        System.out.println("Nhap ten nhan vien: ");
        String tenNhanVien = scanner.nextLine();
        System.out.println("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhap ngay sinh: ");
        Date ngaySinh = d.parse(scanner.nextLine());
        System.out.println("Nhap que quan: ");
        String queQuan = scanner.nextLine();
        System.out.println("Nhap ngay vao lam: ");
        Date ngayVaoLam = d.parse(scanner.nextLine());

        BoPhan b =  null;
        while(b == null){
            System.out.println("Nhap ma bo phan: ");
            Integer maBoPhan = scanner.nextInt();
            if ( BoPhanService.getBoPhan(maBoPhan) != null){
                b = BoPhanService.getBoPhan(maBoPhan);
            }else{
                 System.out.println("Ma bo phan khong hop le");
            }
        }            
        getListNhanVien().add(new NhanVien(tenNhanVien, gioiTinh, ngaySinh, queQuan, ngayVaoLam, b));            
    }

    public static void danhSachNhanVien(){
        for (int i = 0; i < getListNhanVien().size(); i++){
            System.out.println(getListNhanVien().get(i).getMaNhanVien() + "\t" + 
                    getListNhanVien().get(i).getHoTen()+ "\t" + 
                    getListNhanVien().get(i).getGioiTinh() + "\t" + 
                    getListNhanVien().get(i).getNgaySinh() + "\t" + 
                    getListNhanVien().get(i).getQueQuan() + "\t" + 
                    getListNhanVien().get(i).getNgayVaoLam() + "\t" +
                    getListNhanVien().get(i).getBoPhan().getTenBoPhan()
                    );
        }
    }

    public static void xoaNhanVien(){
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Nhap ma nhan vien can xoa: ");
        Integer maNhanVien = scanner.nextInt();
        for (int i = 0; i < getListNhanVien().size(); i++){
            if(getListNhanVien().get(i).getMaNhanVien() == maNhanVien){
                listNhanVien.remove(i);
                System.out.println("Xoa thanh cong");
                checkMa = false;
                break;
            }
        }
        if(checkMa){
            System.out.println("Ma nhan vien khong phu hop");
        }
    }

    public static void suaNhanVien() throws ParseException{
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Nhap ma nhan vien can sua: ");
        Integer maNhanVien = scanner.nextInt();
        for (int i = 0; i < getListNhanVien().size(); i++){
            if(getListNhanVien().get(i).getMaNhanVien() == maNhanVien){

                System.out.println("Nhap ten nhan vien: ");
                String tenNhanVien = scanner.nextLine();
                System.out.println("Nhap gioi tinh: ");
                String gioiTinh = scanner.nextLine();
                System.out.println("Nhap ngay sinh: ");
                Date ngaySinh = d.parse(scanner.nextLine());
                System.out.println("Nhap que quan: ");
                String queQuan = scanner.nextLine();
                System.out.println("Nhap ngay vao lam: ");
                Date ngayVaoLam = d.parse(scanner.nextLine());

                BoPhan b =  null;
                while(b == null){
                    System.out.println("Nhap ma bo phan: ");
                    Integer maBoPhan = scanner.nextInt();
                    if ( BoPhanService.getBoPhan(maBoPhan) != null){
                        b = BoPhanService.getBoPhan(maBoPhan);
                    }else{
                         System.out.println("Ma bo phan khong hop le");
                    }
                } 
                getListNhanVien().set(listNhanVien.indexOf(i),new NhanVien(tenNhanVien, gioiTinh, ngaySinh, queQuan, ngayVaoLam, b));
                System.out.println("Sua thanh cong");
                checkMa = false;
                break;
            }
        }
        if(checkMa){
            System.out.println("Ma bo phan khong phu hop");
        }
    }
        
        
    public static void danhSachSinhNhat(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1;
        
        for (int i = 0; i < getListNhanVien().size(); i++){
            if((getListNhanVien().get(i).getNgaySinh().getMonth() + 1) == month){
                System.out.println(getListNhanVien().get(i).getMaNhanVien() + "\t" + 
                    getListNhanVien().get(i).getHoTen()+ "\t" + 
                    getListNhanVien().get(i).getGioiTinh() + "\t" + 
                    getListNhanVien().get(i).getNgaySinh() + "\t"
                    );
            }
        }
    }
        

    /**
     * @return the listNhanVien
     */
    public static ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    /**
     * @param aListNhanVien the listNhanVien to set
     */
    public static void setListNhanVien(ArrayList<NhanVien> aListNhanVien) {
        listNhanVien = aListNhanVien;
    }
        
        
   
}
