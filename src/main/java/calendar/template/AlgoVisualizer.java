package calendar.template;

import calendar.Calendar;
import calendar.Main;
import calendar.PanelVo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private PanelVo data;        // 数据
    private AlgoFrame frame;    // 视图
    private List<PanelVo> panelList;
    private int counter;
    private List<String> plList;

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        panelList = Main.getCalendar();
        plList = Arrays.asList("Java", "C", "C++", "Python", "Go", "Scala", "Clojure", "Groovy", "PHP", "Swift", "Lua",
                "C#", "Scheme", "JavaScript", "Ruby", "Assembly", "Perl", "HTML", "CSS", "Erlang", "Haskell", "Object-C");

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Calendar", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(this::home).start();
        });
    }

    // 动画逻辑
    private void home() {

        String str = (new SimpleDateFormat("MM-dd")).format(new Date());

        int p = getTodayCounter(str);
        PanelVo pd = panelList.get(p);

        for (Map.Entry<Integer, String> day : pd.getWeekMap().entrySet()) {
            if (day.getValue().equals(str)) {
                pd.setWeekday(day.getKey());
                break;
            }
        }

        Random r = new Random();
        int randomPl = r.nextInt(plList.size());
        pd.setPl(plList.get(randomPl));

        setData(pd);
    }

    private void paint(int i) {
        PanelVo pd = panelList.get(counter);
        pd.setWeekday(i);


        Random r = new Random();
        int randomPl = r.nextInt(plList.size());
        pd.setPl(plList.get(randomPl));

        setData(pd);
    }


    private int getTodayCounter(String today) {
        for (int i = 0; i < panelList.size(); i++) {
            if (panelList.get(i).getWeekMap().containsValue(today)) {
                counter = i;
                return i;
            }
        }
        return -1;
    }

    private void setData(PanelVo data) {
        frame.render(data);
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println(e.getKeyCode());
            if (e.getKeyCode() == 36) { //home
                home();
            } else if (e.getKeyCode() == 39) {  //right
                if (counter < panelList.size()) {
                    counter ++;
                }
                paint(1);
            } else if (e.getKeyCode() == 37) {  //left
                if (counter == 1) {
                    counter --;
                    paint(2);
                } else if (counter > 1) {
                    counter --;
                    paint(1);
                }
            } else if (e.getKeyCode() == 38) { //up

            } else if (e.getKeyCode() == 40) { //down

                PanelVo vo = panelList.get(counter);
                int curMon = Integer.valueOf(vo.getWeekMap().get(2).substring(0, 2));
                if (curMon < 12) {
                    String date;
                    if (curMon + 1 < 10) {
                        date = "0" + (curMon + 1) + "-01";
                    } else {
                        date = curMon + 1 + "-01";
                    }
                    counter = getTodayCounter(date);
                    vo = panelList.get(counter);

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



    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 500;
        int sceneHeight = 500;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
