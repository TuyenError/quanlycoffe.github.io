import java.util.ArrayList;
import java.util.Scanner;

public class Quanlymenu {
    static ArrayList<HighlandsCoffee> monAn = new ArrayList<HighlandsCoffee>();
    static ArrayList<Order> order = new ArrayList<Order>();

    private static String Id;
    public static Scanner input = new Scanner(System.in);

    static void Sua() {
        String chon;
        int p = TimKiem();
        if (p >= 0) {
            while (true) {
                // Scanner input = new Scanner(System.in);
                System.out.print("Nhap 1 de doi ten, 2 de doi gia, 3 de doi loai, 4 de hoan tat: ");
                chon = input.next();
                if (chon.equals("4"))
                    break;
                switch (chon) {
                    case "1":
                        System.out.print("Nhap ten moi: ");
                        String newName = input.next();
                        monAn.get(p).setTen(newName);
                        break;
                    case "2":
                        System.out.print("Nhap gia moi: ");
                        int gia = input.nextInt();
                        monAn.get(p).setGia(gia);
                        break;
                    case "3":
                        System.out.print("Nhap loai moi: ");
                        String loai = input.next();
                        monAn.get(p).setLoai(loai);
                        break;
                }
                ;

            }
            ;
        } else
            System.out.println("Khong tim thay");
    }

    static void Them() {
        monAn.add(HighlandsCoffee.Nhap());
    };

    static int TimKiem() 
    {
        // Scanner input = new Scanner(System.in);
        System.out.print("Enter Id of drink: ");
        Id = input.next();
        for (HighlandsCoffee order : monAn) {
            if (order.getSTT().equals(Id))
                return monAn.indexOf(order);
        }
        return -1;
    }

    static void HienThi() {
        System.out.print("\n -----------------------------------------------------------------");
        System.out.printf("\n | %7s | %-30s | %9s | %10s |", " STT ", " TEN ", "  LOAI  ", "GIÁ");
        System.out.print("\n -----------------------------------------------------------------");
        // System.out.print("\n ---------------------Id------------------------");

        for (HighlandsCoffee order : monAn)
            System.out.printf("\n | %7s | %-30s | %-9s | %10.2f |", order.getSTT(), order.getTen(), order.getLoai(),
                    order.getGia());
        System.out.print("\n -----------------------------------------------------------------");

    }

    static void DatMon(int p1) {
        System.out.println("Nhan 1 de dat mon nay. Phim bat ky de huy");
        String xacnhan = input.next();
        if (xacnhan.equals("1")) {
            System.out.print("Nhap ten khach hang: ");
            String TenKH = input.next();
            System.out.print("Nhap so luong : ");
            int SoLuong = input.nextInt();
            Order datmon = new Order(TenKH, monAn.get(p1).getTen(), SoLuong, SoLuong * monAn.get(p1).getGia());
            order.add(datmon);
            System.out.println("Dat mon thanh cong");
            System.out.println("Hoa don cua ban la:");
            System.out.printf("\n | %20s | %15s | %9s | %10s |", " Ten khach hang ", " Ten mon ", "  So luong  ",
                    "Tong tien");
            System.out.print("\n -----------------------------------------------------------------");
            System.out.printf("\n | %20s | %15s | %-9d | %10.2f |", TenKH, monAn.get(p1).getTen(), SoLuong,
                    SoLuong * monAn.get(p1).getGia());
        }
    }

    static void DonDatHang() {
        System.out.print("\n -----------------------------------------------------------------");
        System.out.printf("\n | %20s | %25s | %-8s | %10s |", "  Ten khach hang  ", "         Ten mon         ", "So luong",
                "Tong tien");
        System.out.print("\n -----------------------------------------------------------------");
        // System.out.print("\n ---------------------Id------------------------");

        for (Order od : order)
            System.out.printf("\n | %20s | %25s | %-8d | %10.2f |", od.getKH(), od.getMon(), od.getSL(), od.getTien());
        System.out.print("\n -----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        while (true) {
            // Scanner input = new Scanner(System.in);
            MyMenu.menuShow();
            System.out.print("Chon do an thuc uong : ");
            String chon = input.next();
            if (chon.endsWith("0"))
                break; // end while
            switch (chon) {
                case "1":
                    monAn = DocGhiTep.readFile("D:/Documents/QUANLYQUANCAFE/Menu.txt");
                    break;
                case "2":
                    HienThi();
                    break;
                case "3":
                    Them();
                    break;
                case "4":
                    Sua();
                    break;
                case "5":
                    int p = TimKiem();
                    if (p >= 0) {
                        monAn.remove(p);
                        System.out.println("Đã xóa!!");
                    } else
                        System.out.println("Không tìm thấy");

                    break;
                case "6": sapxepTen(); HienThi(); break;
                case "7":
                    int p1 = TimKiem(); 
                    if (p1 >= 0) {
                        monAn.get(p1).Show();
                        DatMon(p1);
                    } else
                        System.out.println("Không tìm thấy");
                    break;
                case "8":
                    DonDatHang();
                    break;
            }
        }
        
    }

    static void sapxepTen() {
        for (int i = 0; i < monAn.size(); i++)
            for (int j = i + 1; j < monAn.size(); j++) {
                if (monAn.get(i).getTen().compareTo(monAn.get(j).getTen()) > 0){
                    HighlandsCoffee temp = monAn.get(i);
                    monAn.set(i, monAn.get(j));
                    monAn.set(j, temp);
                }
            }
    
        }
    }


