package com.ideas2it.companymanagement.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {
    public static int getYearBetweenDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(date, currentDate).getYears();
    }
}
