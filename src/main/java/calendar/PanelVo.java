package calendar;

import java.util.Map;

public class PanelVo {
    private int weekday;
    private String pl;
    private Map<Integer, String> weekMap;

    public PanelVo() {
    }

    public PanelVo(int weekday, Map<Integer, String> weekMap) {
        this.weekday = weekday;
        this.weekMap = weekMap;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public Map<Integer, String> getWeekMap() {
        return weekMap;
    }

    public void setWeekMap(Map<Integer, String> weekMap) {
        this.weekMap = weekMap;
    }

    @Override
    public String toString() {
        return weekday + " " + weekMap;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }
}
