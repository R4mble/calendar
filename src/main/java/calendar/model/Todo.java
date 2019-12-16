package calendar.model;

import lombok.Data;

import java.util.Date;

@Data
public class Todo {
    private Date createTime;
    private String content;
    private boolean done;
    private int priority;
}
