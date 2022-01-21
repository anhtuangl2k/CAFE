/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import static com.tt.UI.Menu.Menu;
import com.tt.pojo.BoPhan;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anhtu
 */
public class BoPhanService {

    private static ArrayList<BoPhan> listBoPhan = new ArrayList<BoPhan>();

    public static void addBoPhan() {
        listBoPhan.add(new BoPhan("pha che"));
        listBoPhan.add(new BoPhan("phuc vu"));
        listBoPhan.add(new BoPhan("tiep tan"));
    }

    public static void menuBoPhan(Scanner scanner) throws ParseException {
        int chooseBoPhan;
        boolean flag = true;

        System.out.println("1. Them bo phan");
        System.out.println("2. Xoa bo phan");
        System.out.println("3. Sua bo phan");
        System.out.println("4. Danh sach bo phan");
        System.out.println("0. Thoat");
        System.out.println("===============================================");
        do {
            do {
                System.out.println("Nhap chuc nang: ");
                chooseBoPhan = scanner.nextInt();
            } while (chooseBoPhan < 0 || chooseBoPhan > 4);
            // xét case
            switch (chooseBoPhan) {
                case 1:
                    themBoPhan();
                    break;
                case 2:
                    xoaBoPhan();
                    break;
                case 3:
                    suaBoPhan();
                    break;
                case 4:
                    danhSachBoPhan();
                    break;
                default:
                    Menu(scanner);
                    flag = false;
                    break;
            }
        } while (flag);
    }

    public static void themBoPhan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten bo phan: ");
        String tenBoPhan = scanner.nextLine();
        getListBoPhan().add(new BoPhan(tenBoPhan));
    }

    public static void danhSachBoPhan() {
        for (int i = 0; i < getListBoPhan().size(); i++) {
            System.out.println(getListBoPhan().get(i).getMaBoPhan() + "\t" + getListBoPhan().get(i).getTenBoPhan());
        }
    }

    public static void xoaBoPhan() {
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma bo phan: ");
        Integer maBoPhan = scanner.nextInt();
        for (int i = 0; i < getListBoPhan().size(); i++) {
            if (getListBoPhan().get(i).getMaBoPhan() == maBoPhan) {
                listBoPhan.remove(i);
                System.out.println("Xoa thanh cong");
                checkMa = false;
                break;
            }
        }
        if (checkMa) {
            System.out.println("Ma bo phan khong phu hop");
        }
    }

    public static void suaBoPhan() {
        boolean checkMa = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma bo phan: ");
        Integer maBoPhan = scanner.nextInt();
        for (int i = 0; i < getListBoPhan().size(); i++) {
            if (getListBoPhan().get(i).getMaBoPhan() == maBoPhan) {
                System.out.println("Nhap ten moi cua bo phan: ");
                String tenBoPhanMoi = scanner.nextLine();
                getListBoPhan().get(i).setTenBoPhan(tenBoPhanMoi);
                System.out.println("Sua thanh cong");
                checkMa = false;
                break;
            }
        }
        if (checkMa) {
            System.out.println("Ma bo phan khong phu hop");
        }
    }

    public static BoPhan getBoPhan(Integer maBoPhan) {
        for (int i = 0; i < getListBoPhan().size(); i++) {
            if (getListBoPhan().get(i).getMaBoPhan() == maBoPhan) {
                return getListBoPhan().get(i);
            }
        }
        return null;
    }

    /**
     * @return the listBoPhan
     */
    public static ArrayList<BoPhan> getListBoPhan() {
        return listBoPhan;
    }

    /**
     * @param aListBoPhan the listBoPhan to set
     */
    public static void setListBoPhan(ArrayList<BoPhan> aListBoPhan) {
        listBoPhan = aListBoPhan;
    }

}
