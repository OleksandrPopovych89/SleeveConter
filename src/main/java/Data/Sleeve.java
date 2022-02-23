package Data;

public class Sleeve {
    private double diameter16 = 0;
    private double diameter20 = 0;
    private double diameter25 = 0;
    private double diameter32 = 0;

    public Sleeve(double diameter16, double diameter20, double diameter25, double diameter32) {
        this.diameter16 = diameter16;
        this.diameter20 = diameter20;
        this.diameter25 = diameter25;
        this.diameter32 = diameter32;
    }

    public Sleeve() {
    }

    public double getDiameter16() {
        return diameter16;
    }

    public void setDiameter16(double diameter16) {
        this.diameter16 = diameter16;
    }

    public double getDiameter20() {
        return diameter20;
    }

    public void setDiameter20(double diameter20) {
        this.diameter20 = diameter20;
    }

    public double getDiameter25() {
        return diameter25;
    }

    public void setDiameter25(double diameter25) {
        this.diameter25 = diameter25;
    }

    public double getDiameter32() {
        return diameter32;
    }

    public void setDiameter32(double diameter32) {
        this.diameter32 = diameter32;
    }

    @Override
    public String toString() {
        return "Гільзи діаметром 16 - " + diameter16 + " шт.\n"
                + "Гільзи діаметром 20 - " + diameter20 + " шт.\n"
                + "Гільзи діаметром 25 - " + diameter25 + " шт.\n"
                + "Гільзи діаметром 32 - " + diameter32 + " шт.\n";
    }
}
