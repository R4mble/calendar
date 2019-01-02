package calendar.gui;

import calendar.model.PanelVo;
import calendar.service.KeyboardListener;
import calendar.service.MouseActionListener;
import calendar.service.PanelService;
import calendar.util.CalendarHelper;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private PanelVo data;        // 数据
    private static View frame;    // 视图
    public static List<PanelVo> panelList;
    public static List<String> plList;

    public Controller(int sceneWidth, int sceneHeight){

        // 初始化数据
        panelList = CalendarHelper.getCalendar();
        plList = CalendarHelper.getPLList();

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new View("Calendar", sceneWidth, sceneHeight);
            frame.addKeyListener(new KeyboardListener());
            frame.addMouseListener(new MouseActionListener());
            new Thread(PanelService::home).start();
        });
    }

    public static void setData(PanelVo data) {
        frame.render(data);
    }

    public static void main(String[] args) {
        int sceneWidth = 500;
        int sceneHeight = 500;
        Controller controller = new Controller(sceneWidth, sceneHeight);
    }
}
