package pipedetails;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fitting {
    private String name;
    private String designation;
    private String vendor;
    private double quantity;

    @Override
    public String toString() {
        return String.format("%s\nТипорозмір %s , кількістю %s шт. вирбник %s\n",
                name, designation, quantity, vendor);
    }
}