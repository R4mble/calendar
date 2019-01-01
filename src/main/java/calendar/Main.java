package calendar;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String str = (new SimpleDateFormat("MM-dd- a E")).format(new Date());

        System.out.println(str);

        List<Calendar> calendarList = Main.getCalendar();
        List<List<PanelVo>> panelList;

        panelList = new LinkedList<>();

        for (Calendar c : calendarList) {
            List<PanelVo> week = new LinkedList<>();
            if (c.getWeekday() != 1) {
                PanelVo panelVo = new PanelVo();
                String m, d;
                if (c.getMonth() < 10) {
                    m = "0" + c.getMonth();
                } else {
                    m = String.valueOf(c.getMonth());
                }
                if (c.getDay() < 10) {
                    d = "0" + c.getDay();
                } else {
                    d = String.valueOf(c.getDay());
                }

                panelVo.setDate(m + "-" + d);
                panelVo.setWeekday(c.getWeekday());

                week.add(panelVo);
            } else {
                panelList.add(week);
            }
        }


        System.out.println(panelList);

    }

    public static List<Calendar> getCalendar() {
        List<Calendar> calendarList = new LinkedList<>();


        for (int m = 1; m <= 12; m++) {
            int day;
            if (m == 2) {
                day = 28;
            } else if (Arrays.asList(4, 6, 9, 11).contains(m)) {
                day = 30;
            } else {
                day = 31;
            }

            for (int d = 1; d <= day; d++) {
                calendarList.add(new Calendar(m, d, Weekday.get()));
            }
        }
        return calendarList;
    }
}
