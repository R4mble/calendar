package calendar.service;

import calendar.model.PanelVo;
import calendar.util.CalendarHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import static calendar.gui.Controller.panelList;
import static calendar.gui.Controller.plList;
import static calendar.gui.Controller.setData;

public class PanelService {

    public static int counter;

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

        Random r = new Random();
        int randomPl = r.nextInt(plList.size());
        pd.setPl(plList.get(randomPl));

        setData(pd);
    }

    public static void paint(int i) {
        PanelVo pd = panelList.get(counter);
        pd.setWeekday(i);

        Random r = new Random();
        int randomPl = r.nextInt(plList.size());
        pd.setPl(plList.get(randomPl));

        setData(pd);
    }

}
