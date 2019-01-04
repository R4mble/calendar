package calendar.model;

import java.util.List;
import java.util.Map;

public class PanelVo {
    private int weekday;
    private String pl;
    private Map<Integer, String> weekMap;

    public Map<Integer, List<Todo>> getWeekToDo() {
        return weekToDo;
    }

    public void setWeekToDo(Map<Integer, List<Todo>> weekToDo) {
        this.weekToDo = weekToDo;
    }

    private Map<Integer, List<Todo>> weekToDo;

    public PanelVo() {
    }

    public PanelVo(int weekday, Map<Integer, String> weekMap) {
        this.weekday = weekday;
        this.weekMap = weekMap;
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

    public int getWeekday() {
        return weekday;
    }

}
