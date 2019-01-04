package calendar.service;

import calendar.model.PanelVo;
import calendar.util.CalendarHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import static calendar.Application.panelList;
import static calendar.Application.plList;
import static calendar.Application.setData;
import static calendar.state.GlobalState.counter;

public class PanelService {


    public static void home() {

        String date = (new SimpleDateFormat("MM-dd")).format(new Date());

        int p = CalendarHelper.getDateCounter(panelList, date);
        PanelVo pd = panelList.get(p);

        for (Map.Entry<Integer, String> day : pd.getWeekMap().entrySet()) {
            if (day.getValue().equals(date)) {
                pd.setWeekday(day.getKey());
                break;
            }
        }

        setRandomPl(pd);
        setData(pd);
    }

    public static void turnPage(int cout) {
        counter = cout;
        paint(1);
    }

    public static void paint(int weekday) {
        PanelVo pd = panelList.get(counter);
        pd.setWeekday(weekday);
        setRandomPl(pd);
        setData(pd);
    }

    public static void paint(boolean tomorrow) {
        PanelVo pd = panelList.get(counter);
        int weekday = pd.getWeekday();

        if (weekday == 1 && !tomorrow) {
            return;
        }

        if (weekday == 7 && tomorrow) {
            return;
        }

        if (tomorrow) {
            pd.setWeekday(weekday + 1);
        } else {
            pd.setWeekday(weekday - 1);
        }

        setRandomPl(pd);
        setData(pd);
    }

    public static void setRandomPl(PanelVo pd) {
        Random r = new Random();
        int randomPl = r.nextInt(plList.size());
        pd.setPl(plList.get(randomPl));
    }

    public static void showTodoList() {

    }
}
