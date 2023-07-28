package services;

import pipedetails.Fitting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ESorter {
    private ESorter() {
    }

    public static List<Fitting> sortLineExcel(List<Fitting> oldList) {
        List<String> fittingNamesToInclude = Arrays.asList(
                "Перехідник прямий із зовнішньою різьбою.",
                "Перехідник прямий із зовнішнім різьбленням.",
                "Перехідник прямий із внутрішньою різьбою.",
                "Перехідник прямий із внутрішнім різьбленням.",
                "Гвинтове з'єднання 3/4\" (євроконус) з прес з'єднанням.",
                "Кутник з'єднувальний 90°, латунь.",
                "Кутник із зовнішньою різьбою.",
                "Кутник із внутрішньою різьбою.",
                "Кутник настінний із внутрішньою різьбою.",
                "Кутник настінний із внутрішньою різьбою, довгий.",
                "Трійник рівнопрохідний/редукційний, латунь.",
                "Трійник різьбовий редукційний, латунь.",
                "Муфта з'єднувальна пряма/перехідна, латунь.",
                "Мідна нікельована трубка 300 мм.",
                "Мідна нікельована трубка 770 мм."
        );

        return oldList.stream()
                .filter(fitting -> fittingNamesToInclude.contains(fitting.getName()))
                .collect(Collectors.toList());
    }
}
