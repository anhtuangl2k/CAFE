/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.UI;

import static com.tt.UI.Menu.Menu;
import com.tt.pojo.Ban;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anhtu
 */
public class BanService {

	private static ArrayList<Ban> listBan = new ArrayList<Ban>();
        
        public static void addBan(){
            listBan.add(new Ban("S0001", "5", "trong"));
        }

	public static void menuBan(Scanner scanner) throws ParseException {
		int chooseBoPhan;
		boolean flag = true;

		System.out.println("1. Them ban");
		System.out.println("2. Xoa ban");
		System.out.println("3. Sua ban");
		System.out.println("4. Danh sach ban trong");
		System.out.println("5. Danh sach ban theo suc chua");
		System.out.println("0. Thoat");
                System.out.println("===============================================");
		do {
			do {
				System.out.println("Nhap chuc nang: ");
				chooseBoPhan = scanner.nextInt();
			} while (chooseBoPhan < 0 || chooseBoPhan > 5);
			// xét case
			switch (chooseBoPhan) {
			case 1:
				themBan();
				break;
			case 2:
				xoaBan();
				break;
			case 3:
				capNhatThongTinBan();
				break;
			case 4:
				layBanTrong();
				break;
			case 5:
				timBanTheoSucChua();
				break;
			default:
				Menu(scanner);
				flag = false;
				break;
			}
		} while (flag);

	}

	public static void themBan() {
		Scanner scanner = new Scanner(System.in);
		Ban b = new Ban();
		b.setMaBan(String.format("B%03d", b.ma));
		System.out.println("Nhap suc chua cua ban: ");
		String sucChua = scanner.nextLine();
		b.setSucChua(sucChua);
		b.setTinhTrang("trong");

		getListBan().add(b);
	}

	public static void capNhatThongTinBan() {
            boolean flag = false;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhap ma ban can tim: ");
            String maBan = scanner.nextLine();

            for (int i = 0; i < getListBan().size(); i++) {
                if (getListBan().get(i).getMaBan().equals(maBan)) {
                        System.out.println("Nhap suc chua: ");
                        String sucChua = scanner.nextLine();
                        getListBan().get(i).setSucChua(sucChua);
                        System.out.println("Nhap tinh trang: ");
                        String tinhtrang = scanner.nextLine();
                        getListBan().get(i).setTinhTrang(tinhtrang);
                        System.out.println("Cap nhat thanh cong! ");
                        flag = true;
                        break;
                }

            }
            if (!flag)
                    System.out.println("Ma ban khong ton tai! Thu lai sau ");
	}

	public static void xoaBan() {
            boolean flag = false;
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Nhap ma ban can tim: ");
            String maBan = scanner.nextLine();

            for (int i = 0; i < getListBan().size(); i++) {
                    if (getListBan().get(i).getMaBan().equals(maBan)) {
                            getListBan().remove(i);
                            System.out.println("Cap nhat thanh cong! ");
                            break;
                    }
            }
            if (!flag)
                    System.out.println("Ma ban khong ton tai! Thu lai sau ");
	}

	public static void layBanTrong() {
            for (int i = 0; i < getListBan().size(); i++) {
                    if (getListBan().get(i).getTinhTrang().equals("trong"))
                            System.out.println("Ma Ban: " + getListBan().get(i).getMaBan());
                    System.out.println("Suc Chua: " + getListBan().get(i).getSucChua());
                    System.out.println("==========================================");
            }
	}

	public static void timBanTheoSucChua() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap suc chua cua ban: ");
		String sucChua = scanner.nextLine();

		for (int i = 0; i < getListBan().size(); i++) {
			if (getListBan().get(i).getSucChua().equals(sucChua))
				System.out.println("Ma Ban: " + getListBan().get(i).getMaBan());
			System.out.println("Tinh Trang: " + getListBan().get(i).getTinhTrang());
			System.out.println("==========================================");
		}
	}

    /**
     * @return the listBan
     */
    public static ArrayList<Ban> getListBan() {
        return listBan;
    }

    /**
     * @param aListBan the listBan to set
     */
    public static void setListBan(ArrayList<Ban> aListBan) {
        listBan = aListBan;
    }
        

}
