package com.example.demo.getworkday;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetWorkDay {
    public List GetWorkDay(String startDate, String endDate) {
        List list = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
        Date dBegin = dateFormat.parse(startDate);
        Date dEnd = dateFormat.parse(endDate);
        List<Date> IDate = findDates(dBegin, dEnd);

    }

    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List IDate = new ArrayList();
        IDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while ((dEnd.after(calBegin.getTime()))) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            IDate.add(calBegin.getTime());
        }
        return IDate;
    }
}
