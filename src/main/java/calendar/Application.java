package calendar;

import calendar.gui.View;
import calendar.model.PanelVo;
import calendar.gui.KeyboardController;
import calendar.service.MouseActionListener;
import calendar.service.PanelService;
import calendar.util.CalendarHelper;

import javax.swing.SwingUtilities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Application {

    private static View frame;    // 视图
    public static List<PanelVo> panelList;
    public static List<String> plList;

    public Application(int sceneWidth, int sceneHeight){

        // 初始化数据
        panelList = CalendarHelper.getCalendar();
        plList = CalendarHelper.getPLList();

        // 初始化视图
        frame = new View("Calendar", sceneWidth, sceneHeight);
        frame.addKeyListener(new KeyboardController());
        frame.addMouseListener(new MouseActionListener());

        SwingUtilities.invokeLater(PanelService::home);

    }

    public static void setData(PanelVo data) {
        frame.render(data);
    }

    public static void setTime() {
        new Thread( () ->
        {
            while (true)
            {
                String time = new SimpleDateFormat("hh:mm:ss").format(new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                frame.render(time);
            }
        }
        ).start();
    }

    public static void main(String[] args) {
        int sceneWidth = 500;
        int sceneHeight = 500;
        new Application(sceneWidth, sceneHeight);

        setTime();
    }
}
