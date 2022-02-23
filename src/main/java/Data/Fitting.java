package Data;

public class Fitting {
    private String name;
    private String designation;
    private double quantity;


    public Fitting() {
    }

    public Fitting(String name, String designation, double quantity) {
        this.name = name;
        this.designation = designation;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s\nТипорозмір %s , кількістю %s  шт.\n", name, designation, quantity);
    }
}