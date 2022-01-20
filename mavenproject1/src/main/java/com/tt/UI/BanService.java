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
public class BanService {

	private static ArrayList<Ban> listBan = new ArrayList<Ban>();

	public static void menuBoPhan(Scanner scanner) throws ParseException {
		int chooseBoPhan;
		boolean flag = true;

		System.out.println("1. Them ban");
		System.out.println("2. Xoa ban");
		System.out.println("3. Sua ban");
		System.out.println("4. Danh sach ban trong");
		System.out.println("5. Danh sach ban theo suc chua");
		System.out.println("0. Thoat");

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
		b.setMaBan(String.format("B$03d", b.ma));
		System.out.println("Nhap suc chua cua ban: ");
		String sucChua = scanner.nextLine();
		b.setSucChua(sucChua);
		b.setTinhTrang("trong");

		listBan.add(b);
	}

	public static void capNhatThongTinBan() {
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);
		String maBan;

		System.out.println("Nhap ma ban can tim: ");
		String maBan = scanner.nextLine();

		for (int i = 0; i < listBan.size(); i++) {
			if (listBan.get(i).getMaBan().equals(maBan)) {
				System.out.println("Nhap suc chua: ");
				String sucChua = scanner.nextLine();
				listBan.get(i).setSucChua(sucChua);
				System.out.println("Nhap tinh trang: ");
				String tinhtrang = scanner.nextLine();
				listBan.get(i).setTinhTrang(tinhtrang);
				System.out.println("Cap nhat thanh cong! ");
				flag = true;
				break;
			}

		}
		if (!flag)
			System.out.println("Ma ban khong ton tai! Thu lai sau ");
	}

	public static void xoaBan() {
		Scanner scanner = new Scanner(System.in);
		String maBan;

		System.out.println("Nhap ma ban can tim: ");
		String maBan = scanner.nextLine();

		for (int i = 0; i < listBan.size(); i++) {
			if (listBan.get(i).getMaBan().equals(maBan)) {
				listBan.remove(i);
				System.out.println("Cap nhat thanh cong! ");
				break;
			}
		}
		if (!flag)
			System.out.println("Ma ban khong ton tai! Thu lai sau ");
	}

	public static void layBanTrong() {
		for (int i = 0; i < listBan.size(); i++) {
			if (listBan.get(i).getTinhTrang().equals("trong"))
				System.out.println("Ma Ban: " + listBan.get(i).getMaBan());
			System.out.println("Suc Chua: " + listBan.get(i).getSucChua());
			System.out.println("==========================================");
		}
	}

	public static void timBanTheoSucChua() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap suc chua cua ban: ");
		String sucChua = scanner.nextLine();

		for (int i = 0; i < listBan.size(); i++) {
			if (listBan.get(i).getSucChua().equals(sucChua))
				System.out.println("Ma Ban: " + listBan.get(i).getMaBan());
			System.out.println("Tinh Trang: " + listBan.get(i).getTinhTrang());
			System.out.println("==========================================");
		}
	}

}
