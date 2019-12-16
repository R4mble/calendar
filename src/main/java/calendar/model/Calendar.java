package calendar.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Calendar {
    private int month;
    private int day;
    private int weekday;
}
