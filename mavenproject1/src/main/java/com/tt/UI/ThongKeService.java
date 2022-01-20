/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import static com.tt.UI.Menu.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class ThongKeService {

    public void menuthongKe(Scanner scanner) throws ParseException {
        int chooseBoPhan;
        boolean flag = true;

        System.out.println("1. Thong ke theo thang");
        System.out.println("2. Thong ke theo thoi gian");
        System.out.println("0. Thoat");

        do {
            do {
                System.out.println("Nhap chuc nang: ");
                chooseBoPhan = scanner.nextInt();
            } while (chooseBoPhan < 0 || chooseBoPhan > 4);
            // xét case
            switch (chooseBoPhan) {
                case 1:
                    thongKeThang();
                    break;
                case 2:
//                    xoaBoPhan();
                    break;
                default:
                    Menu(scanner);
                    flag = false;
                    break;
            }
        } while (flag);
    }

    public static void thongKeThang() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thang ban muon thong ke: ");
        int thang = scanner.nextInt();
        double tongTienThang = 0;
        int slMon = 0, slNuoc = 0;

        for (int i = 0; i < HoaDonService.getListHoaDon().size(); i++) {
            if (HoaDonService.getListHoaDon().get(i).getNgayTao().getMonth() + 1 == thang) {
                tongTienThang += HoaDonService.getListHoaDon().get(i).getTongTien();
                slMon += HoaDonService.getListHoaDon().get(i).getListThucAnHoaDon().size();
                slNuoc += HoaDonService.getListHoaDon().get(i).getListThucUongHoaDon().size();
            }
        }
        System.out.println(String.format("So hoa theo thang la: %d\n So tong tien "
                + "theo thang la: %f\n So luong nuoc ban la: %d\n So luong mon an ban la: %d",
                HoaDonService.getListHoaDon().size(), tongTienThang, slNuoc, slMon));
    }

    public static void thongKeTheoThoiGian() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ngay bat dau: ");
        String begin = scanner.nextLine();
        System.out.println("Nhap ngay ket thuc: ");
        String end = scanner.nextLine();
        int thang = scanner.nextInt();
        double tongTienThang = 0;
        int slMon = 0, slNuoc = 0;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date beginDate = sdf.parse(begin);
        Date endDate = sdf.parse(end);

        for (int i = 0; i < HoaDonService.getListHoaDon().size(); i++) {
            if (HoaDonService.getListHoaDon().get(i).getNgayTao().compareTo(endDate) < 0 &&
                   HoaDonService.getListHoaDon().get(i).getNgayTao().compareTo(beginDate) > 0 ) {
                tongTienThang += HoaDonService.getListHoaDon().get(i).getTongTien();
                slMon += HoaDonService.getListHoaDon().get(i).getListThucAnHoaDon().size();
                slNuoc += HoaDonService.getListHoaDon().get(i).getListThucUongHoaDon().size();
            }
        }
        
        System.out.println(String.format("So hoa theo thang la: %d\n So tong tien "
                + "theo thang la: %f\n So luong nuoc ban la: %d\n So luong mon an ban la: %d",
                HoaDonService.getListHoaDon().size(), tongTienThang, slNuoc, slMon));
    }
}
