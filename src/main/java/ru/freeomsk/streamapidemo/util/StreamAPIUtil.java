package ru.freeomsk.streamapidemo;

import ru.freeomsk.streamapidemo.model.Specialist;
import ru.freeomsk.streamapidemo.model.Speciality;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIUtil {
    // Получение начального списка специалистов
    public static List<Specialist> getSpecialists() {
        return List.of(
                new Specialist("Ivanov Ivan", new BigDecimal(5000), Speciality.ENGINEER),
                new Specialist("Alexander Alexandrov", new BigDecimal(4000), Speciality.ENGINEER),
                new Specialist("Sergej Sergeev", new BigDecimal(3000), Speciality.DEVOPS),
                new Specialist("Fedor Fedorov", new BigDecimal(2000), Speciality.DEVOPS),
                new Specialist("Kirill Kirillov", new BigDecimal(10000), Speciality.MANAGER),
                new Specialist("Petr Petrov", new BigDecimal(10000), Speciality.MANAGER)
        );
    }

    // Вывод в консоль
    public static void printSpecialists(List<Specialist> specialists) {
        specialists.forEach(System.out::println);
        System.out.println("-----------------");
    }

    // Поиск по специальности
    public static List<Specialist> filterBySpeciality(List<Specialist> specialists, Speciality speciality) {
        return specialists.stream()
            .filter(specialist -> specialist.getSpeciality().equals(speciality))
            .collect(Collectors.toList());
    }

    // Сортировка по имени по возрастанию
    public static List<Specialist> sortSpecialistsByNameAsc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName))
                .collect(Collectors.toList());
    }

    // Сортировка по имени по убыванию
    public static List<Specialist> sortSpecialistsByNameDesc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName).reversed())
                .collect(Collectors.toList());
    }

    // Поиск специалиста с максимальной зарплатой
    public static Specialist findWithMaxSalary(List<Specialist> specialists) {
        return specialists.stream()
                .max(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }
    // Поиск специалиста с минимальной зарплатой
    public static Specialist findWithMinSalary(List<Specialist> specialists) {
        return specialists.stream()
                .min(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }

    // Группировка специалистов по специальности
    public static Map<Speciality, List<Specialist>> groupBySpeciality(List<Specialist> specialists) {
        return specialists.stream()
                .collect(Collectors.groupingBy(Specialist::getSpeciality));
    }

    // Проверка - все ли инженеры?
    public static boolean matchAllEngineers(List<Specialist> specialists) {
        return specialists.stream()
                .allMatch(specialist -> specialist.getSpeciality().equals(Speciality.ENGINEER));
    }

    // Проверка - есть ли инженеры?
    public static boolean matchAnyEngineers(List<Specialist> specialists) {
        return specialists.stream()
                .anyMatch(specialist -> specialist.getSpeciality().equals(Speciality.ENGINEER));
    }

    // Проверка - все ли имеют зарплату выше указанной
    public static boolean matchAllSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream()
                .allMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Проверка - никто не имеет зарплату выше указанной?
    public static boolean matchNoneSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream()
                .noneMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }
}
