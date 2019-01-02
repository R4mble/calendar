package calendar.model;

public class Calendar {

    private int month;
    private int day;
    private int weekday;

    public Calendar(int month, int day, int weekday) {
        this.month = month;
        this.day = day;
        this.weekday = weekday;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    @Override
    public String toString() {
        return month + " " + day + " " + weekday;
    }
}
