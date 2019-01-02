package calendar.service;

import calendar.model.PanelVo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

import static calendar.gui.Controller.panelList;
import static calendar.service.PanelService.home;
import static calendar.service.PanelService.paint;
import static calendar.util.CalendarHelper.getDateCounter;

public class KeyboardListener extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 36) { //home
            home();
        } else if (e.getKeyCode() == 39) {  //right
            if (PanelService.counter < panelList.size() - 1) {
                PanelService.counter ++;
            }
            paint(1);
        } else if (e.getKeyCode() == 37) {  //left
            if (PanelService.counter == 1) {
                PanelService.counter --;
                paint(2);
            } else if (PanelService.counter > 1) {
                PanelService.counter --;
                paint(1);
            }
        } else if (e.getKeyCode() == 38) { //up

        } else if (e.getKeyCode() == 40) { //down

            PanelVo vo = panelList.get(PanelService.counter);
            int curMon = Integer.valueOf(vo.getWeekMap().get(2).substring(0, 2));
            if (curMon < 12) {
                String date;
                if (curMon + 1 < 10) {
                    date = "0" + (curMon + 1) + "-01";
                } else {
                    date = curMon + 1 + "-01";
                }
                PanelService.counter = getDateCounter(panelList, date);
                vo = panelList.get(PanelService.counter);

                int week = 1;
                for (Map.Entry<Integer, String> day : vo.getWeekMap().entrySet()) {
                    String tem = day.getValue().substring(3, 5);
                    if (tem.equals("01")) {
                        week = day.getKey();
                        break;
                    }
                }
                paint(week);
            }
        }
    }
}
