package calendar.gui;

import calendar.model.PanelVo;
import calendar.service.KeyboardListener;
import calendar.service.MouseActionListener;
import calendar.service.PanelService;
import calendar.util.CalendarHelper;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Controller {

    private static View frame;    // 视图
    public static List<PanelVo> panelList;
    public static List<String> plList;

    public Controller(int sceneWidth, int sceneHeight){

        // 初始化数据
        panelList = CalendarHelper.getCalendar();
        plList = CalendarHelper.getPLList();

        ;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new View("Calendar", sceneWidth, sceneHeight);
            frame.addKeyListener(new KeyboardListener());
            frame.addMouseListener(new MouseActionListener());
            new Thread(PanelService::home).start();
        });


//        new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            setTime(new SimpleDateFormat("hh:mm:ss").format(new Date()));
//        });
    }

    public static void setData(PanelVo data) {
        frame.render(data);
    }

    public static void setTime(String time) {
        frame.render(time);
    }

    public static void main(String[] args) {
        int sceneWidth = 500;
        int sceneHeight = 500;
        Controller controller = new Controller(sceneWidth, sceneHeight);


    }
}
