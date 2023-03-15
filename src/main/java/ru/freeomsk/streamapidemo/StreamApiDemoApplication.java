package ru.freeomsk.streamapidemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.freeomsk.streamapidemo.model.Specialist;
import ru.freeomsk.streamapidemo.model.Speciality;
import ru.freeomsk.streamapidemo.util.StreamAPIUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class StreamApiDemoApplication {

    public static void main(String[] args) {
        List<Specialist> specialists = StreamAPIUtil.getSpecialists();

        // Filter
        List<Specialist> engineers = StreamAPIUtil.filterBySpeciality(specialists, Speciality.ENGINEER);
        System.out.println("Поиск по специальности");
        StreamAPIUtil.printSpecialists(engineers);

        // Sorting
        List<Specialist> sortedSpecialistAsc = StreamAPIUtil.sortSpecialistsByNameAsc(specialists);
        System.out.println("Сортировка по имени по возрастанию");
        StreamAPIUtil.printSpecialists(sortedSpecialistAsc);
        List<Specialist> sortedSpecialistDesc = StreamAPIUtil.sortSpecialistsByNameDesc(specialists);
        System.out.println("Сортировка по имени по убыванию");
        StreamAPIUtil.printSpecialists(sortedSpecialistDesc);

        // Max salary
        Specialist withMaxSalary = StreamAPIUtil.findWithMaxSalary(specialists);
        System.out.println("Поиск специалиста с максимальной зарплатой");
        System.out.println(withMaxSalary);
        System.out.println("-----------------");

        // Min salary
        Specialist withMinSalary = StreamAPIUtil.findWithMinSalary(specialists);
        System.out.println("Поиск специалиста с минимальной зарплатой");
        System.out.println(withMinSalary);
        System.out.println("-----------------");

        // Grouping
        Map<Speciality, List<Specialist>> groupBySpeciality = StreamAPIUtil.groupBySpeciality(specialists);
        System.out.println("Группировка специалистов по специальности");
        System.out.println(groupBySpeciality);
        System.out.println("-----------------");

        // All engineers
        boolean allEngineers = StreamAPIUtil.matchAllEngineers(specialists);
        System.out.println("Проверка - все ли инженеры?");
        System.out.println(allEngineers);
        System.out.println("-----------------");

        // Any engineers
        boolean anyEngineers = StreamAPIUtil.matchAnyEngineers(specialists);
        System.out.println("Проверка - есть ли инженеры?");
        System.out.println(anyEngineers);
        System.out.println("-----------------");

        // All salary more then
        boolean allSalaryMoreThen0 = StreamAPIUtil.matchAllSalaryMoreThen(specialists, new BigDecimal(0));
        System.out.println("Проверка - все ли имеют зарплату выше указанной (0)");
        System.out.println(allSalaryMoreThen0);
        System.out.println("-----------------");

        // No one with salary more then
        boolean matchNoneSalaryMoreThen = StreamAPIUtil.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println("Проверка - никто не имеет зарплату выше указанной (10000)");
        System.out.println(matchNoneSalaryMoreThen);
    }

}
