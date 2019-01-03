package calendar.gui;

import calendar.model.PanelVo;
import calendar.util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class View extends JFrame{

    private int canvasWidth;
    private int canvasHeight;
    private PanelVo data;
    private String time = "";

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

            ViewHelper.drawText(g2d, data.getPl(), 50, 50);


//            String content = plMap.get("Java");
//            int length = content.length();

//            for (int i = 0; i < 3; i++) {
//                ViewHelper.drawText(g2d, content.substring(length / (i + 2), length / (i + 1)), "仿宋", 20, 50, 150 + 30 * i);
//            }
//
//            ViewHelper.drawText(g2d, content.substring(0, length / 3), "仿宋", 20, 200, 300 + 30 * 0);
//            ViewHelper.drawText(g2d, content.substring(length / 3, length / 3 * 2), "仿宋", 20, 200, 300 + 30 * 1);
//            ViewHelper.drawText(g2d, content.substring(length / 3 * 2, length), "仿宋", 20, 200, 300 + 30 * 2);
//


            ViewHelper.drawText(g2d, "2019-" + data.getWeekMap().get(data.getWeekday())
                    , 400, 80);

            ViewHelper.drawText(g2d, weekdayMap.get(data.getWeekday()), 400, 120);

            ViewHelper.drawText(g2d, time, 400, 160);

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


            JTextField textField = new JTextField();
            textField.setBounds(new Rectangle(10, 150, 250, 40));

            textField.addActionListener(e -> {
                System.out.println(e.getActionCommand());
            });

            textField.addActionListener(e -> {
                System.out.println(e.getWhen());
            });

            textField.addKeyListener(new KeyboardController());


//            this.add(textField, null);

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


