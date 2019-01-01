//package calendar.template;
//
//import calendar.Calendar;
//import calendar.Main;
//import calendar.PanelVo;
//
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.LinkedList;
//import java.util.List;
//
//public class AlgoVisualizer {
//
//    // TODO: 创建自己的数据
//    private PanelVo data;        // 数据
//    private AlgoFrame frame;    // 视图
//    private List<List<PanelVo>> panelList;
//
//    public AlgoVisualizer(int sceneWidth, int sceneHeight){
//
//        // 初始化数据
//        // TODO: 初始化数据
//        List<Calendar> calendarList = Main.getCalendar();
//        panelList = new LinkedList<>();
//
//        for (Calendar c : calendarList) {
//            List<PanelVo> week = new LinkedList<>();
//            if (c.getWeekday() != 1) {
//                PanelVo panelVo = new PanelVo();
//                String m, d;
//                if (c.getMonth() < 10) {
//                    m = "0" + c.getMonth();
//                } else {
//                    m = String.valueOf(c.getMonth());
//                }
//                if (c.getDay() < 10) {
//                    d = "0" + c.getDay();
//                } else {
//                    d = String.valueOf(c.getDay());
//                }
//
//                panelVo.setDate(m + "-" + d);
//                panelVo.setWeekday(c.getWeekday());
//                panelVo.setDateMap(c.getWeekday(), m + "-" + d);
//
//                week.add(panelVo);
//            } else {
//                panelList.add(week);
//            }
//        }
//
//
//        // 初始化视图
//        EventQueue.invokeLater(() -> {
//            frame = new AlgoFrame("Coding", sceneWidth, sceneHeight);
//            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
//            frame.addKeyListener(new AlgoKeyListener());
//            frame.addMouseListener(new AlgoMouseListener());
//            new Thread(() -> {
//                run();
//            }).start();
//        });
//    }
//
//    // 动画逻辑
//    private void run(){
//        PanelVo d = new PanelVo("01", "02", 3);
//        setData(d);
//    }
//
//    private void setData(PanelVo data) {
//        frame.render(data);
//    }
//
//    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
//    private class AlgoKeyListener extends KeyAdapter{
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            if (e.getKeyCode() == 39) {
//
//                run();
//            }
//        }
//    }
//
//    private class AlgoMouseListener extends MouseAdapter{ }
//
//    public static void main(String[] args) {
//
//        int sceneWidth = 500;
//        int sceneHeight = 500;
//
//        // TODO: 根据需要设置其他参数，初始化visualizer
//        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
//    }
//}
