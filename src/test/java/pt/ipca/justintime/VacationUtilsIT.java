package pt.ipca.justintime;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pt.ipca.justintime.domain.Vacation;
import pt.ipca.justintime.utils.VacationUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VacationUtilsIT {

    @Autowired
    private VacationUtils vacationUtils;

    @Test
    public void getDaysBetweenDates_nowPlusOneDay_notEmpty() {
        List<Vacation> vacationList = new ArrayList<>();
        Vacation vacation = new Vacation();
        vacation.setVacationStartDay(LocalDate.now());
        vacation.setVacationEndDay(LocalDate.now().plusDays(1));
        vacationList.add(vacation);
        List<LocalDate> result = vacationUtils.getDaysBetweenDates(vacationList);
        Assert.assertTrue(!result.isEmpty());
    }

    @Test
    public void getDaysBetweenDates_nowPlusOneDay_returnListSingleValue() {
        List<Vacation> vacationList = new ArrayList<>();
        Vacation vacation = new Vacation();
        vacation.setVacationStartDay(LocalDate.now());
        vacation.setVacationEndDay(LocalDate.now().plusDays(1));
        vacationList.add(vacation);
        List<LocalDate> result = vacationUtils.getDaysBetweenDates(vacationList);
        Assert.assertTrue(result.size() == 2);
    }

    @Test
    public void getVacationDaysForMonth_returnDaysList() {

        List<Vacation> vacationList = new ArrayList<>();
        int month = LocalDate.now().getMonth().getValue();
        Vacation vacation = new Vacation();
        vacation.setVacationStartDay(LocalDate.now());
        vacation.setVacationEndDay(LocalDate.now().plusDays(6));
        vacationList.add(vacation);
        List<LocalDate> result = vacationUtils.getDaysOfVacationByMonth(vacationList, month);
        Assert.assertTrue(result.size() == 7);

    }

    @Test
    public void getDaysBetweenDates_recieving_a_list_of_vacations() {
        List<Vacation> vacationList = new ArrayList<>();
        Vacation a = new Vacation();
        a.setVacationStartDay(LocalDate.now());
        a.setVacationEndDay(LocalDate.now().plusDays(6));
        Vacation b = new Vacation();
        b.setVacationStartDay(LocalDate.now().minusYears(1));
        b.setVacationEndDay(b.getVacationStartDay().plusDays(6));
        Vacation c = new Vacation();
        c.setVacationStartDay(LocalDate.now().plusMonths(1));
        c.setVacationEndDay(c.getVacationStartDay().plusDays(6));
        vacationList.add(a);
        vacationList.add(b);
        vacationList.add(c);
        List<LocalDate> vacationByDaysList = vacationUtils.getDaysBetweenDates(vacationList);
        Assert.assertTrue(vacationByDaysList.size() == 21);
    }
}
