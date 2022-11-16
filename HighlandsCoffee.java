import java.util.Scanner;

public class HighlandsCoffee extends Tenmon {
    private String STT;
    private double Gia = -1;
    public static Scanner input = new Scanner(System.in);

    // public HighlandsCoffe() {

    // }
    static HighlandsCoffee Nhap() {
        // Scanner input = new Scanner(System.in);
        System.out.print("Nhap STT: ");
        String STT = input.nextLine();
        System.out.print("Nhap Ten : ");
        String Ten = input.nextLine();
        System.out.print("Nhap Loai : ");
        String Loai = input.nextLine();
        System.out.print("Nhap Gia : ");
        int Gia = input.nextInt();

        return new HighlandsCoffee(STT, Ten, Loai,Gia);
    }

    void Show() {
        System.out.printf("\n %10s %10s %5s %5.2f", getSTT(), getTen(), getLoai(), getGia());
        System.out.println("");
    }

    public HighlandsCoffee(String STT, String Ten, String Loai) {
        super(Ten, Loai);
        this.STT = STT;
    }

    public HighlandsCoffee(String STT, String Ten, String Loai, double Gia) {
        super(Ten, Loai);
        this.STT = STT;
        this.Gia = Gia;
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

}
