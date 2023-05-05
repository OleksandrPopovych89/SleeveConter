package pipedetails;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Sleeve {
    private double diameter16 = 0;
    private double diameter20 = 0;
    private double diameter25 = 0;
    private double diameter32 = 0;

    private static final String units = "шт.";
    @Override
    public String toString() {
        return "Гільзи діаметром 16 - " + diameter16 + " " + units + "\n"
                + "Гільзи діаметром 20 - " + diameter20 + " " + units + "\n"
                + "Гільзи діаметром 25 - " + diameter25 + " " + units + "\n"
                + "Гільзи діаметром 32 - " + diameter32 + " " + units + "\n";
    }
}
