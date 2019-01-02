package calendar.model;

public class Weekday {

    private static int weekday = 1;

    public static int get() {
        if (weekday == 7) {
            weekday = 1;
            return weekday;
        }
        return ++weekday;
    }
}
