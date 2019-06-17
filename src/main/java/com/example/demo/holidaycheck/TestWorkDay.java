package com.example.demo.holidaycheck;

import com.example.demo.readexcel.ReadExcel;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestWorkDay {
    private static List<Calendar> holidayList = new ArrayList<>();
    private static List<Calendar> weekendList = new ArrayList<>();

    public void JudgmentDate(String path, String truething, String falsething) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            Calendar ca = Calendar.getInstance();
            TestWorkDay testWorkDay = new TestWorkDay();
            Date date = dateFormat.parse(dateFormat.format(new Date()));//获取当前系统时间
            System.out.println("今天是" + dateFormat.format(new Date()));
            ca.setTime(date);//设定当前时间
            ReadExcel readExcel = new ReadExcel(); //建立读取Excel数据
            File file = new File(path);//设置路径
            //File file=new File("D:holidayList.xls");
            List excelList = readExcel.readExcel(file);//将读取到的数据放入list中
            for (int i = 0; i < excelList.size(); i++) {
                List list = (List) excelList.get(i);//将每一条信息提取出来进入另一个list中
                for (int j = 0; j < list.size(); j++) {
                    testWorkDay.initWeekendList(list.get(j).toString());//将节假日信息放入判断库中
                }
            }
            testWorkDay.initWeekendList("2019-06-17");
            boolean k = checkHoliday(ca);//进行判断
            boolean l = checkWeekend(ca);
            System.out.println(k);
            if (k == true || l == true) {
                System.out.println(falsething);
            } else
                System.out.println(truething);
        } catch (Exception e) {
            System.out.println(e.getClass());
            e.printStackTrace();
        }
    }


    /**
     * 验证日期是否是节假日
     *
     * @param calendar 传入需要验证的日期
     * @return return boolean    返回类型  返回true是节假日，返回false不是节假日
     * throws
     */
    public static boolean checkWeekend(Calendar calendar) throws Exception {

        //判断日期是否是周六周日
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

            for (Calendar ca : weekendList) {
                if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                        ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
                        ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHoliday(Calendar calendar) throws Exception {
        //判断日期是否是节假日
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

            for (Calendar ca : holidayList) {
                if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                        ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
                        ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 把所有节假日放入list
     *
     * @param date 从数据库查 查出来的格式2016-05-09
     *             return void    返回类型
     *             throws
     */
    public void initHolidayList(String date) {

        String[] da = date.split("-");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
        calendar.set(Calendar.MONTH, Integer.valueOf(da[1]) - 1);//月份比正常小1,0代表一月
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
        holidayList.add(calendar);
    }

    /**
     * 初始化周末被调整为工作日的数据
     */
    public void initWeekendList(String date) {
        String[] da = date.split("-");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
        calendar.set(Calendar.MONTH, Integer.valueOf(da[1]) - 1);//月份比正常小1,0代表一月
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
        weekendList.add(calendar);
    }


}
