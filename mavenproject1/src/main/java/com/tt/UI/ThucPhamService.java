/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import static com.tt.UI.Menu.Menu;
import com.tt.pojo.ThucAn;
import com.tt.pojo.ThucUong;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anhtu
 */
public class ThucPhamService {
    
    private static ArrayList<ThucAn> listThucAn = new ArrayList<ThucAn>();
    private static ArrayList<ThucUong> listThucUong = new ArrayList<ThucUong>();
    
    public static void addThucAn(){
        listThucAn.add(new ThucAn("com chien", 120000, " con hang", " khong phai thuc pham chay"));
        listThucAn.add(new ThucAn("mi xao", 80000, " con hang", " khong phai thuc pham chay"));
        listThucAn.add(new ThucAn("com chay", 50000, " con hang", " thuc pham chay"));
    }
    
    public static void addThucUong(){
        listThucUong.add(new ThucUong("coca", 200000, " con hang", "uong da"));
        listThucUong.add(new ThucUong("pepsi", 200000, " con hang", "uong da"));
        listThucUong.add(new ThucUong("7up", 200000, " con hang", "uong da"));

    }
    
    public static void menuThucPham(Scanner scanner) throws ParseException{

        int choose;
        boolean flag = true;
        
        System.out.println("1. Quan ly thuc an");
        System.out.println("2. Quan ly thuc uong");
        System.out.println("0. Thoat");
        System.out.println("===============================================");
        do{
            do{
                System.out.println("Nhap chuc nang: ");
                choose = scanner.nextInt();       
            }while (choose < 0 || choose > 2);
            // xét case
            switch(choose){
                case 1:
                    menuThucAn(scanner);
                    break;
                case 2:
                    menuThucUong(scanner);
                    break;
                default:
                    Menu(scanner);
                    flag = false;
                    break;
            }
        }while(flag);                  
    }
    
/*===========================================THUC AN================================================*/    
    public static void menuThucAn(Scanner scanner) throws ParseException{        
        int chooseBoPhan;
        boolean flag = true;

        System.out.println("1. Them mon an");
        System.out.println("2. Xoa mon an");
        System.out.println("3. Sua mon an");
        System.out.println("4. Danh sach mon an ");
        System.out.println("0. Thoat");
        System.out.println("===============================================");
        do{
            do{
                System.out.println("Nhap chuc nang: ");
                chooseBoPhan = scanner.nextInt();       
            }while (chooseBoPhan < 0 || chooseBoPhan > 4);
            // xét case
            switch(chooseBoPhan){
                case 1:
                    themMonAn();
                    break;
                case 2:
                    xoaThucAn();
                    break;
                case 3:
                    suaThucAn();
                    break;
                case 4:
                    danhSachThucAn();
                    break;
                default:
                    menuThucPham(scanner);
                    flag = false;
                    break;
            }
        }while(flag);                  
    }
     
     
    public static void themMonAn(){
        Scanner scanner = new Scanner(System.in);     
        
        System.out.println("Nhap ten mon an: ");
        String tenMonAn = scanner.nextLine();
        
        System.out.println("Nhap gia ban");
        Double giaBan = scanner.nextDouble();
        
        System.out.println("Nhap tinh trang");
        String tinhTrang = scanner.nextLine();
        
        System.out.println("Thuc pham chay: ");
        String chay = scanner.nextLine();
        
        listThucAn.add(new ThucAn(tenMonAn, giaBan, tinhTrang, chay));        
    }
    
    public static void xoaThucAn(){
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Nhap ma thuc an muon xoa: ");
        Integer maThucAn = scanner.nextInt();
        for (int i = 0; i < getListThucAn().size(); i++){
            if(getListThucAn().get(i).getMaThucAn() == maThucAn){
                listThucAn.remove(i);
                System.out.println("Xoa thanh cong");
                checkMa = false;
                break;
            }
        }
        if(checkMa){
            System.out.println("Ma thuc an khong phu hop");
        }
    }
    
    public static void suaThucAn(){
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Nhap ma thuc an can sua: ");
        Integer maThucAn = scanner.nextInt();
        // Lấy dấu enter cuối cùng
        String a = scanner.nextLine();
               
        for (int i = 0; i < getListThucAn().size(); i++){
            if(getListThucAn().get(i).getMaThucAn() == maThucAn){
                
                System.out.println("Nhap ten mon an: ");
                String tenMonAn = scanner.nextLine();

                System.out.println("Nhap gia ban");
                Double giaBan = scanner.nextDouble();

                System.out.println("Nhap tinh trang");
                String tinhTrang = scanner.nextLine();

                System.out.println("Thuc pham chay: ");
                String chay = scanner.nextLine();
                               
                getListThucAn().get(i).setTen(tenMonAn);
                getListThucAn().get(i).setGiaBan(giaBan);
                getListThucAn().get(i).setTinhTrang(tinhTrang);
                getListThucAn().get(i).setThucPhamChay(chay);
                System.out.println("Sua thanh cong");
                checkMa = false;
                break;
            }
        }
        if(checkMa){
            System.out.println("Ma bo phan khong phu hop");
        }
    }
        
    public static void danhSachThucAn(){
        for (int i = 0; i < getListThucAn().size(); i++){
            System.out.println(getListThucAn().get(i).getMaThucAn()+ "\t" + 
                        getListThucAn().get(i).getTen()+ "\t" + 
                        getListThucAn().get(i).getGiaBan()+ "\t" +
                        getListThucAn().get(i).getTinhTrang()+ "\t" +
                        getListThucAn().get(i).getThucPhamChay()
                    );
        }
    }

    /**
     * @return the listThucAn
     */
    public static ArrayList<ThucAn> getListThucAn() {
        return listThucAn;
    }

    /**
     * @param aListThucAn the listThucAn to set
     */
    public static void setListThucAn(ArrayList<ThucAn> aListThucAn) {
        listThucAn = aListThucAn;
    }
    
/*===========================================THUC UONG================================================*/   
     public static void menuThucUong(Scanner scanner) throws ParseException{        
        int chooseBoPhan;
        boolean flag = true;

        System.out.println("1. Them thuc uong");
        System.out.println("2. Xoa thuc uong");
        System.out.println("3. Sua thuc uong");
        System.out.println("4. Danh sach thuc uong ");
        System.out.println("0. Thoat");

        do{
            do{
                System.out.println("Nhap chuc nang: ");
                chooseBoPhan = scanner.nextInt();       
            }while (chooseBoPhan < 0 || chooseBoPhan > 4);
            // xét case
            switch(chooseBoPhan){
                case 1:
                    themThucUong();
                    break;
                case 2:
                    xoaThucUong();
                    break;
                case 3:
                    suaThucUong();
                    break;
                case 4:
                    danhSachThucUong();
                    break;
                default:
                    menuThucPham(scanner);
                    flag = false;
                    break;
            }
        }while(flag);                  
    }
    
    public static void themThucUong(){
        Scanner scanner = new Scanner(System.in);     
        
        System.out.println("Nhap ten thuc uong: ");
        String tenMonAn = scanner.nextLine();
        
        System.out.println("Nhap gia ban");
        Double giaBan = scanner.nextDouble();
        
        System.out.println("Nhap tinh trang");
        String tinhTrang = scanner.nextLine();
        
        System.out.println("Phan tram da: ");
        String da = scanner.nextLine();
        
        listThucUong.add(new ThucUong(tenMonAn, giaBan, tinhTrang, da));        
    }
    
    public static void danhSachThucUong(){
        for (int i = 0; i < getListThucUong().size(); i++){
            System.out.println(getListThucUong().get(i).getMaThucUong()+ "\t" + 
                        getListThucUong().get(i).getTen()+ "\t" + 
                        getListThucUong().get(i).getGiaBan()+ "\t" +
                        getListThucUong().get(i).getTinhTrang()+ "\t" +
                        getListThucUong().get(i).getDa()
                    );
        }
    }
    
    public static void xoaThucUong(){
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Nhap ma thuc uong muon xoa: ");
        Integer maThucUong = scanner.nextInt();
        for (int i = 0; i < getListThucUong().size(); i++){
            if(getListThucUong().get(i).getMaThucUong() == maThucUong){
                listThucUong.remove(i);
                System.out.println("Xoa thanh cong");
                checkMa = false;
                break;
            }
        }
        if(checkMa){
            System.out.println("Ma thuc uong khong phu hop");
        }
    }
    
        public static void suaThucUong(){
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Nhap ma thuc uong can sua: ");
        Integer maThucUong = scanner.nextInt();
        // Lấy dấu enter cuối cùng
        String a = scanner.nextLine();
        for (int i = 0; i < getListThucUong().size(); i++){
            if(getListThucUong().get(i).getMaThucUong() == maThucUong){
                
                System.out.println("Nhap ten thuc uong: ");
                String tenThucUong = scanner.nextLine();

                System.out.println("Nhap gia ban");
                Double giaBan = scanner.nextDouble();

                System.out.println("Nhap tinh trang");
                String tinhTrang = scanner.nextLine();

                System.out.println("Phan tram da: ");
                String da = scanner.nextLine();
                               
                getListThucUong().get(i).setTen(tenThucUong);
                getListThucUong().get(i).setGiaBan(giaBan);
                getListThucUong().get(i).setTinhTrang(tinhTrang);
                getListThucUong().get(i).setDa(da);
                System.out.println("Sua thanh cong");
                checkMa = false;
                break;
            }
        }
        if(checkMa){
            System.out.println("Ma thuc uong khong phu hop");
        }
    }
     
    
    /**
     * @return the listThucUong
     */
    public static ArrayList<ThucUong> getListThucUong() {
        return listThucUong;
    }

    /**
     * @param aListThucUong the listThucUong to set
     */
    public static void setListThucUong(ArrayList<ThucUong> aListThucUong) {
        listThucUong = aListThucUong;
    }
     
    
    public static ThucAn getMonAn(int ma){
         for (int i = 0; i < getListThucAn().size(); i++){
            if(getListThucAn().get(i).getMaThucAn() == ma){
               return getListThucAn().get(i);
            }
         }
        return null;
    }
    
    public static ThucUong getThucUong(int ma){
         for (int i = 0; i < getListThucUong().size(); i++){
            if(getListThucUong().get(i).getMaThucUong()== ma){
               return getListThucUong().get(i);
            }
         }
        return null;
    }
}
