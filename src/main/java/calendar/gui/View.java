package calendar.gui;

import calendar.model.PanelVo;
import calendar.model.Todo;
import calendar.util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static calendar.Application.panelList;

public class View extends JFrame{

    private int canvasWidth;
    private int canvasHeight;
    private PanelVo data;
    private String time = "";
    private boolean cmd;

    private HashMap<Integer, String> weekdayMap;

    public View(String title, int canvasWidth, int canvasHeight){

        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();

        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        weekdayMap = new HashMap<>();
        weekdayMap.put(1, "Mon");
        weekdayMap.put(2, "Tue");
        weekdayMap.put(3, "Wed");
        weekdayMap.put(4, "Thu");
        weekdayMap.put(5, "Fri");
        weekdayMap.put(6, "Sat");
        weekdayMap.put(7, "Sun");
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}


    public void render(PanelVo data){
        this.data = data;
        repaint();
    }

    public void render(String time){
        this.time = time;
        repaint(0, 330, 160, 250, 50);
    }

    public void render(boolean cmd) {
        this.cmd = cmd;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            paintPanel(g2d);
            paintTime(g2d);
            paintWeek(g2d);
            paintTodo();

            if (cmd) {
                paintCmd();
            }
        }

        private void paintCmd() {
            JTextField textField = new JTextField();
            textField.setBounds(new Rectangle(10, 450, 450, 20));
            this.add(textField, null);
        }

        private void paintTime(Graphics2D g2d) {
            ViewHelper.drawText(g2d, time, 400, 160);
        }

        private void paintPanel(Graphics2D g2d) {
            ViewHelper.drawText(g2d, data.getPl(), 50, 50);
            ViewHelper.drawText(g2d, "2019-" + data.getWeekMap().get(data.getWeekday())
                    , 400, 80);
            ViewHelper.drawText(g2d, weekdayMap.get(data.getWeekday()), 400, 120);
        }

        private void paintWeek(Graphics2D g2d) {
            Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                    0f);
            g2d.setStroke(dash);

            for (int i = 0; i < 7; i++) {

                if (i + 1 == data.getWeekday()) {
                    ViewHelper.setColor(g2d, ViewHelper.Red);
                } else {
                    ViewHelper.setColor(g2d, ViewHelper.Black);
                }

                ViewHelper.fillRectangle(g2d, 10 + 70 * i, 400, 70, 80);

                if (i == 0) {
                    ViewHelper.drawText(g2d, weekdayMap.get(i + 1), 45 + 70 * i, 417);
                } else {
                    ViewHelper.drawText(g2d, weekdayMap.get(i + 1), 40 + 70 * i, 420);
                }

                if (data.getWeekMap().get(i + 1) == null) {

                } else {
                    ViewHelper.drawText(g2d, data.getWeekMap().get(i + 1), 20, 60 + 70 * i, 450);
                }
            }
        }

        private void paintTodo() {
            if (data.getWeekToDo() != null && data.getWeekToDo().size() == 0) {

                JTextField textField = new JTextField();
                textField.setBounds(new Rectangle(10, 150, 250, 40));


                textField.addActionListener(e -> {
                    Todo todo = new Todo();
                    todo.setContent(e.getActionCommand());
                    todo.setCreateTime(new Date(e.getWhen()));
                    if (data.getWeekToDo().get(data.getWeekday()) == null) {
                        ArrayList<Todo> list = new ArrayList<>();
                        list.add(todo);
                        data.getWeekToDo().put(data.getWeekday(), list);
                    } else {
                        data.getWeekToDo().get(data.getWeekday()).add(todo);
                    }
                    this.remove(textField);
                    repaint();
                });

                this.add(textField, null);
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


