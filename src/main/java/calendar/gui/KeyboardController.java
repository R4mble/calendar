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
        keyboardMapping(10, () -> PanelService.showTodoList());
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
