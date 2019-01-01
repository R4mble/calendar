package calendar;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {




        List<Calendar> calendarList = Main.getCalendar();

        List<PanelVo> panelVoList = new LinkedList<>();


        HashMap<Integer, String> map = new HashMap<>();

        for (Calendar c : calendarList) {

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

            if (c.getWeekday() != 1) {
                map.put(c.getWeekday(), m + "-" + d);
            } else {
                panelVoList.add(new PanelVo(1, map));
                map = new HashMap<>();
                map.put(c.getWeekday(), m + "-" + d);
            }
        }
        panelVoList.add(new PanelVo(1, map));

//        for (PanelVo p : panelVoList) {
//            System.out.println(p.getWeekMap());
//            System.out.println("==============");
//        }

        String str = (new SimpleDateFormat("MM-dd")).format(new Date());
        str = "09-12";
        for (PanelVo p : panelVoList) {
            if (p.getWeekMap().containsValue(str)) {
                System.out.println(p);
            }
        }
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
