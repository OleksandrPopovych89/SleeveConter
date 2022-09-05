package services;

import pipedetails.Fitting;

import java.util.ArrayList;
import java.util.List;

public class ESorter {

    public static List<Fitting> sortLineExcel(List<Fitting> oldList) {
        String nipple1 = "Перехідник прямий із зовнішньою різьбою.";
        String nipple2 = "Перехідник прямий із зовнішнім різьбленням.";
        String threadInternal1 = "Перехідник прямий із внутрішньою різьбою.";
        String threadInternal2 = "Перехідник прямий із внутрішнім різьбленням.";
        String euroCones = "Гвинтове з'єднання 3/4\" (євроконус) з прес з'єднанням.";
        String elbow = "Кутник з‘єднувальний 90°, латунь.";
        String nippleElbow = "Кутник із зовнішньою різьбою.";
        String threadInternalElbow = "Кутник із внутрішньою різьбою.";
        String wallThreadInternalElbow = "Кутник настінний із внутрішньою різьбою.";
        String wallThreadInternalElbowLong = "Кутник настінний із внутрішньою різьбою, довгий.";
        String tee = "Трійник рівнопрохідний/редукційний, латунь.";
        String clutch = "Муфта з'єднувальна пряма/перехідна, латунь.";
        String copperPipe = "Мідна нікельована трубка 300 мм.";


        List<Fitting> newList = new ArrayList<>();
        for (Fitting fitting : oldList) {
            if (fitting.getName().equals(nipple1)
                    || fitting.getName().equals(nipple2)
                    || fitting.getName().equals(threadInternal1)
                    || fitting.getName().equals(threadInternal2)
                    || fitting.getName().equals(euroCones)
                    || fitting.getName().equals(elbow)
                    || fitting.getName().equals(nippleElbow)
                    || fitting.getName().equals(threadInternalElbow)
                    || fitting.getName().equals(wallThreadInternalElbow)
                    || fitting.getName().equals(wallThreadInternalElbowLong)
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
