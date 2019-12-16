package calendar.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PanelVo {
    private int weekday;
    private String pl;
    private Map<Integer, String> weekMap;
    private Map<Integer, List<Todo>> weekToDo;

    public PanelVo(int weekday, Map<Integer, String> weekMap) {
        this.weekday = weekday;
        this.weekMap = weekMap;
    }

}
