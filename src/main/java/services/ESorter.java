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
                "Перехідник",
                "Гвинтове",
                "Кутник",
                "Трійник",
                "Муфта",
                "Мідна"
        );

        return oldList.stream()
                .filter(fitting -> fitting.getQuantity() != 0 ||
                        !fitting.getVendor().equalsIgnoreCase("Tece"))
                .filter(fitting -> fittingNamesToInclude.
                        stream().anyMatch(s -> fitting.getName().contains(s)))
                .collect(Collectors.toList());
    }
}
