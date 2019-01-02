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

//            HashMap<String, String> plMap = new HashMap<>();
//            plMap.put("Java", "Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程.");

            AlgoVisHelper.drawText(g2d, data.getPl(), 50, 50);

//            String content = plMap.get("Java");
//            int length = content.length();

//            for (int i = 0; i < 3; i++) {
//                AlgoVisHelper.drawText(g2d, content.substring(length / (i + 2), length / (i + 1)), "仿宋", 20, 50, 150 + 30 * i);
//            }
//
//            AlgoVisHelper.drawText(g2d, content.substring(0, length / 3), "仿宋", 20, 200, 300 + 30 * 0);
//            AlgoVisHelper.drawText(g2d, content.substring(length / 3, length / 3 * 2), "仿宋", 20, 200, 300 + 30 * 1);
//            AlgoVisHelper.drawText(g2d, content.substring(length / 3 * 2, length), "仿宋", 20, 200, 300 + 30 * 2);
//

            AlgoVisHelper.drawText(g2d, "2019-" + data.getWeekMap().get(data.getWeekday())
                    , 400, 80);

            AlgoVisHelper.drawText(g2d, weekdayMap.get(data.getWeekday()), 400, 120);

            Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                    0f);
            g2d.setStroke(dash);

            for (int i = 0; i < 7; i++) {

                if (i + 1 == data.getWeekday()) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                } else {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Black);
                }

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


