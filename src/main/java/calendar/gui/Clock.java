package calendar.gui;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.util.Date;

public class Clock extends JComponent {

    private int hour = 0;
    private int min = 0;
    private int sec = 0;
    private JLabel display = new JLabel();
    private Date now = new Date();
    private String strTime = "" ;

    public Clock(){
        add(display);
        display.setBounds(195, 320, 80, 20);
        display.setBorder(BorderFactory.createLineBorder(Color.black));
        hour = now.getHours();
        min = now.getMinutes();
        sec = now.getSeconds();
        setVisible(true);
    }


    private void showTime(){
        String date;
        int hour_temp = hour,min_temp = min,sec_temp = sec;
        sec_temp += 1 ;
        if(sec_temp >= 60)
        {
            sec_temp = 0;
            min_temp += 1 ;
        }
        if(min_temp>=60){
            min_temp=0;
            hour_temp+=1;
        }
        if(hour_temp < 10)
            strTime = "0" + hour_temp + ":";
        else
            strTime = "" + hour_temp + ":";

        if(min_temp < 10)
            strTime = strTime + "0" + min_temp + ":";
        else
            strTime = strTime + "" + min_temp + ":";

        if(sec < 10)
            strTime = strTime + "0" + sec_temp;
        else
            strTime = strTime + "" + sec_temp;

        strTime = "  " + strTime;
        System.out.println(strTime);
        display.setText(strTime);
    }

    public void showUI(){

        new Thread( () ->
                {
                    while (true)
                    {
                        now = new Date();
                        hour = now.getHours();
                        min = now.getMinutes();
                        sec = now.getSeconds();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        showTime();
                        repaint();
                    }
                }
        ).start();

    }
}
