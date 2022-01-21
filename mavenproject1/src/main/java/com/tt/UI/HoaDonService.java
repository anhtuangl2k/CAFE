/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import com.tt.pojo.HoaDon;
import com.tt.pojo.ThucAn;
import com.tt.pojo.ThucUong;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author anhtu
 */
public class HoaDonService {

    private static ArrayList<HoaDon> listHoaDon = new ArrayList<>();
    
    public static void addHoaDon() throws ParseException{
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        listHoaDon.add(new HoaDon(ThucPhamService.getListThucAn(), ThucPhamService.getListThucUong(), 600.00, d.parse("20/1/2022")));
        listHoaDon.add(new HoaDon(ThucPhamService.getListThucAn(), ThucPhamService.getListThucUong(), 700.00, d.parse("24/12/2021")));
        listHoaDon.add(new HoaDon(ThucPhamService.getListThucAn(), ThucPhamService.getListThucUong(), 800.00, d.parse("31/12/2021")));
        listHoaDon.add(new HoaDon(ThucPhamService.getListThucAn(), ThucPhamService.getListThucUong(), 900.00, d.parse("15/1/2022")));

    }

    public static void chonBan() {

        BanService.layBanTrong();
        System.out.println("0. Thoat");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chon ma ban: ");

        boolean flag = true;

        String maBan = scanner.nextLine();

        for (int i = 0; i < BanService.getListBan().size(); i++) {
            System.out.println(BanService.getListBan().get(i).getTinhTrang() + BanService.getListBan().get(i).getMaBan());
            if (BanService.getListBan().get(i).getTinhTrang().equals("trong")
                    && BanService.getListBan().get(i).getMaBan().equals(maBan)) {
                flag = false;
                break;
            }
        }

        if (flag == false) {
            ThucPhamService.danhSachThucAn();
            System.out.println("0. Thoat");
        } else {
            System.out.println("Ma ban khong phu hop");
        }
        ArrayList<ThucAn> listThucAn = new ArrayList<ThucAn>();

        int slm;
        System.out.println("Chon so luong mon");
        slm = scanner.nextInt();

        double tongTien = 0;
        int soLuong = 0;

        while (listThucAn.size() < slm) {
            System.out.println("Vui long chon ma mon");
            int mon = scanner.nextInt();
            listThucAn.add(ThucPhamService.getMonAn(mon));
            soLuong++;
            tongTien += ThucPhamService.getMonAn(mon).getGiaBan();
        }

        int sln;
        System.out.println("Chon so luong nuoc");
        sln = scanner.nextInt();
        ArrayList<ThucUong> listThucUong = new ArrayList<ThucUong>();
        while (listThucUong.size() < sln) {
            System.out.println("Vui long chon ma nuoc");
            int nuoc = scanner.nextInt();
            listThucUong.add(ThucPhamService.getThucUong(nuoc));
            soLuong++;
            tongTien += ThucPhamService.getThucUong(nuoc).getGiaBan();
        }

        System.out.println("So luong mon: " + soLuong);
        System.out.println("Tong tien: " + tongTien);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayTao = new Date();
        HoaDon d = new HoaDon(listThucAn, listThucUong, tongTien, ngayTao);

        listHoaDon.add(d);
    }

    /**
     * @return the listHoaDon
     */
    public static ArrayList<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    /**
     * @param listHoaDon the listHoaDon to set
     */
    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

}
