package Services;

import Data.Fitting;

import java.util.ArrayList;
import java.util.List;

public class ESorter {

    public static List<Fitting> sortLineExcel(List<Fitting> oldList) {
        String nipple = "Перехідник прямий із зовнішньою різьбою.";
        String threadInternal = "Перехідник прямий із внутрішньою різьбою.";
        String elbow = "Кутник з‘єднувальний 90°, латунь.";
        String nippleElbow = "Кутник із зовнішньою різьбою.";
        String threadInternalElbow = "Кутник із внутрішньою різьбою.";
        String wallThreadInternalElbow = "Кутник настінний із внутрішньою різьбою.";
        String tee = "Трійник рівнопрохідний/редукційний, латунь.";
        String clutch = "Муфта з'єднувальна пряма/перехідна.";
        String copperPipe = "Мідна нікельована трубка 300 мм.";


        List<Fitting> newList = new ArrayList<>();
        for (Fitting fitting : oldList) {
            if (fitting.getName().equals(nipple)
                    || fitting.getName().equals(threadInternal)
                    || fitting.getName().equals(elbow)
                    || fitting.getName().equals(nippleElbow)
                    || fitting.getName().equals(threadInternalElbow)
                    || fitting.getName().equals(wallThreadInternalElbow)
                    || fitting.getName().equals(tee)
                    || fitting.getName().equals(clutch)
                    || fitting.getName().equals(copperPipe)
            ) {
                newList.add(fitting);
            }
        }
        return newList;
    }

}
