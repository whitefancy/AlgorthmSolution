package OJSolution.application.maths;

import java.time.LocalDate;
import java.time.Period;

/**
 * 一年中的第几天
 */
public class WitchDay {
    public int ordinalOfDate(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8, 10));
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalDate from = LocalDate.of(year, 01, 01);
        Period period = Period.between(from, localDate);
        long days = localDate.toEpochDay() - from.toEpochDay() + 1;
        return (int) days;
    }
}
