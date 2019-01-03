package calendar.gui;

import calendar.model.KeyCode;
import calendar.model.Operation;
import calendar.service.KeyboardWarrior;
import calendar.service.PanelService;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static calendar.Application.panelList;
import static calendar.state.GlobalState.counter;

public class KeyboardController extends KeyAdapter {

    private List<KeyboardWarrior> keyboardWarriors;

    private void keyboardMapping(int keycode, Operation op) {
        keyboardWarriors.add(e -> {
            if (e == keycode) {
                op.op();
            }
        });
    }

    public KeyboardController() {
        keyboardWarriors = new ArrayList<>();

        registerTurnDate();



        //enter
        keyboardMapping(10, () -> PanelService.turnPage(
                (counter > 0) ?
                        --counter :
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

    private void registerTurnDate() {

        //回到今天
        keyboardMapping(KeyCode.Home, PanelService::home);

        //去最后一个周
        keyboardMapping(KeyCode.End, () -> PanelService.turnPage(panelList.size() - 1));

        //去下个周
        keyboardMapping(KeyCode.Down, () -> PanelService.turnPage(
                (counter < panelList.size() - 1) ?
                        ++counter :
                        counter));

        //去上个周
        keyboardMapping(KeyCode.Up, () -> PanelService.turnPage(
                (counter > 0) ?
                        --counter :
                        counter));

        //去明天
        keyboardMapping(KeyCode.Right, () ->
                PanelService.paint(true));

        //去昨天
        keyboardMapping(KeyCode.Left, () ->
                PanelService.paint(false));

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyboardWarriors.forEach(k -> k.criticize(e.getKeyCode()));
        System.out.println(e.getKeyCode());
    }
}
