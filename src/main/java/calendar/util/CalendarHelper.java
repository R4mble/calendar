package calendar.util;

import calendar.model.Calendar;
import calendar.model.PanelVo;
import calendar.model.Weekday;
import calendar.service.PanelService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CalendarHelper {

    public static List<PanelVo> getCalendar() {
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

        return panelVoList;
    }

    public static int getDateCounter(List<PanelVo> panelList, String date) {
        for (int i = 0; i < panelList.size(); i++) {
            if (panelList.get(i).getWeekMap().containsValue(date)) {
                PanelService.counter = i;
                return i;
            }
        }
        return -1;
    }


}
