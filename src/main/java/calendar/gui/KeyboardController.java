package calendar.gui;

import calendar.model.Operation;
import calendar.model.PanelVo;
import calendar.service.KeyboardWarrior;
import calendar.service.PanelService;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static calendar.Application.panelList;
import static calendar.state.GlobalState.counter;
import static calendar.service.PanelService.paint;
import static calendar.util.CalendarHelper.getDateCounter;

public class KeyboardController extends KeyAdapter {

    private List<KeyboardWarrior> keyboardWarriors;

    public void keyboardMapping(int keycode, Operation op) {
        keyboardWarriors.add(e -> {
            if (e == keycode) {
                op.op();
            }
        });
    }

    public KeyboardController() {
        keyboardWarriors = new ArrayList<>();

        //home
        keyboardMapping(36, PanelService::home);

        //end
        keyboardMapping(35, () -> PanelService.turnPage(() -> panelList.size() - 1));

        //right
        keyboardMapping(39, () ->
                PanelService.turnPage(
                        () -> (counter < panelList.size() - 1) ?
                                ++counter :
                                counter));

        //left
        keyboardMapping(37, () ->
                PanelService.turnPage(
                        () -> (counter > 0) ?
                        --counter:
                        counter));


//        keyboardWarriors.add(e -> {
//              if (e == 40000) { //down
//
//                PanelVo vo = panelList.get(counter);
//                int curMon = Integer.valueOf(vo.getWeekMap().get(6).substring(0, 2));
//                if (curMon < 12) {
//                    String date;
//                    if (curMon + 1 < 10) {
//                        date = "0" + (curMon + 1) + "-01";
//                    } else {
//                        date = curMon + 1 + "-01";
//                    }
//                    counter = getDateCounter(panelList, date);
//                    vo = panelList.get(counter);
//
//                    int week = 1;
//                    for (Map.Entry<Integer, String> day : vo.getWeekMap().entrySet()) {
//                        String tem = day.getValue().substring(3, 5);
//                        if (tem.equals("01")) {
//                            week = day.getKey();
//                            break;
//                        }
//                    }
//                    paint(week);
//                }
//            }
//        });


    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyboardWarriors.forEach(k -> k.criticize(e.getKeyCode()));
        System.out.println(e.getKeyCode());
    }
}
