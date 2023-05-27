package Practik_29_04_23_Dz;

public class Kassa {
    private float a1 = 0.0f; //цена +
    double b = 0.0d;// сумма +

    private String produkt; // продукт +

    private String Karta; // карта +



    //создан конструктор  цены и продукта
    public Kassa(float a1, String produkt) {
        this.a1 = a1;
        this.produkt = produkt;
    }

    //создан конструктор суммы
    public Kassa(double b) {
        this.b = b;
    }

    //создан консруктор карта
    public Kassa(String karta) {
        Karta = karta;
    }

    //создан коснруктор кошелек


    public Kassa() {

    }


    //создаться гет
    public double getA() {
        return a1;
    }

    public double getB() {
        return b;
    }

    public String getprodukt() {
        return produkt;
    }

    public String getKarta() {
        return Karta;
    }



    //создаються сет

    public void setA(float a) {
        this.a1 = a1;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setprodukt(String produkt) {
        this.produkt = produkt;
    }

    public void setKarta(String karta) {
        Karta = karta;
    }



    @Override
    public String toString() {
        return "Kassa{" +
                "a=" + a1 +
                '}';
    }
}




