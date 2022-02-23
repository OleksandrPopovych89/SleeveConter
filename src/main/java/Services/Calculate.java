package Services;

import Data.Fitting;
import Data.Sleeve;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Services.SleeveCounting.tooCount;


public class Calculate {

    public static String calculate(String way) {

        StringBuilder stringBuilder = new StringBuilder();
        List<Fitting> list = new ArrayList<>();
        //        way = FileChooser.fileChoose();
        Date date1 = new Date();
        for (
                int i = 0;
                i < 2; i++) {
            try {
                EReader.read(way, list, i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Date date2 = new Date();
            list = ESorter.sortLineExcel(list);
            int count = 1;
            for (Fitting fitting : list) {
                stringBuilder.append(count).append(") ").append(fitting).append("\n");
                count++;
            }
            Sleeve sleeves = tooCount(list);

            stringBuilder.append("Аркуш: ").append(i + 1).append("\n");
            System.out.println("Аркуш: " + (i + 1));
            System.out.println(sleeves);
            stringBuilder.append(sleeves).append("\n");

            System.out.println("Time run is " + (date2.getTime() - date1.getTime()) + " ms.");
            list.clear();
        }
        System.out.println("----------------------------");
        String request = stringBuilder.toString();
        System.out.println(request);
        File file = new File(way);
        file.delete();
        return request;
    }
}