package calendar.template;

import calendar.Calendar;
import calendar.Main;
import calendar.PanelVo;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    private HashMap<Integer, String> weekdayMap;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

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

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // TODO: 设置自己的数据
    private PanelVo data;
    public void render(PanelVo data){
        this.data = data;
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

            // 具体绘制
            // TODO： 绘制自己的数据data


            AlgoVisHelper.drawText(g2d, "Java", 50, 50);

            AlgoVisHelper.drawText(g2d, "2019-" + data.getWeekMap().get(data.getWeekday())
                    , 400, 80);

            AlgoVisHelper.drawText(g2d, weekdayMap.get(data.getWeekday()), 400, 120);

            Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                    0f);
            g2d.setStroke(dash);

            for (int i = 0; i < 7; i++) {
                AlgoVisHelper.fillRectangle(g2d, 10 + 70 * i, 400, 70, 80);
                if (i == 0) {
                    AlgoVisHelper.drawText(g2d, weekdayMap.get(i + 1), 45 + 70 * i, 417);
                } else {
                    AlgoVisHelper.drawText(g2d, weekdayMap.get(i + 1), 40 + 70 * i, 420);
                }
                if (data.getWeekMap().get(i + 1) == null) {

                } else {
                    AlgoVisHelper.drawText(g2d, data.getWeekMap().get(i + 1), 20, 60 + 70 * i, 450);
                }
            }

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


