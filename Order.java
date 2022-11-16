public class Order {
    private String KH;
    private String Mon;
    private int SL;
    private double Tien;

    public Order(String KH, String Mon, int SL, double Tien) {
        this.KH = KH;
        this.Mon = Mon;
        this.SL = SL;
        this.Tien = Tien;
    }

    void Show() {
        System.out.printf("\n %10s %10s %5d %10f", getKH(), getMon(), getSL(), getTien());
        System.out.println("");
    }

    public String getKH() {
        return KH;
    }
    public void setKH(String KH) {
        this.KH = KH;
    }
    public String getMon(){
        return Mon;
    }
    public void setMon (String Mon){
        this.Mon = Mon;
    }
    public int getSL (){
        return SL;
    }
    public void setSL (int SL){
        this.SL = SL;
    }
    public double getTien (){
        return Tien;
    }
    public void setTien (double Tien){
        this.Tien = Tien;
    }
}
