package calendar;

import java.util.Map;

public class PanelVo {
    private int weekday;
    private Map<Integer, String> weekMap;

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
}
