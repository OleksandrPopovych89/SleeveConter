package services;

import pipedetails.Fitting;
import pipedetails.Sleeve;

import java.util.List;

public class SleeveCounting {
    private SleeveCounting() {
    }

    public static Sleeve tooCount(List<Fitting> list) {
        Sleeve sleeve = new Sleeve();
        String delimiter = "-";
        for (Fitting fitting : list) {
            String[] substring;
            substring = fitting.getDesignation().split(delimiter);

            for (String s : substring) {
                if ("16".equals(s)
                        || (" " + 16 + " ").equals(s)
                        || (" " + 16 + "").equals(s)
                        || ("" + 16 + " ").equals(s)) {
                    sleeve.setDiameter16(sleeve.getDiameter16() + fitting.getQuantity());

                } else if ("20".equals(s)
                        || (" " + 20 + " ").equals(s)
                        || (" " + 20 + "").equals(s)
                        || ("" + 20 + " ").equals(s)) {
                    sleeve.setDiameter20(sleeve.getDiameter20() + fitting.getQuantity());

                } else if ("25".equals(s)
                        || (" " + 25 + " ").equals(s)
                        || (" " + 25 + "").equals(s)
                        || ("" + 25 + " ").equals(s)) {
                    sleeve.setDiameter25(sleeve.getDiameter25() + fitting.getQuantity());

                } else if ("32".equals(s)
                        || (" " + 32 + " ").equals(s)
                        || (" " + 32 + "").equals(s)
                        || ("" + 32 + " ").equals(s)) {
                    sleeve.setDiameter32(sleeve.getDiameter32() + fitting.getQuantity());
                }
            }
        }
        return sleeve;
    }
}
