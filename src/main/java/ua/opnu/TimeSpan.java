package ua.opnu;


public class TimeSpan {

    // TODO: add class fields
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні значення годин або хвилин");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }


    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні значення для додавання");
        }
        this.hours += hours;
        this.minutes += minutes;
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    void subtract(TimeSpan span) {
        int totalMinutesCurrent = getTotalMinutes();
        int totalMinutesSubtract = span.getTotalMinutes();

        if (totalMinutesSubtract > totalMinutesCurrent) {
            throw new IllegalArgumentException("Віднімання неможливе: інтервал більший за поточний");
        }

        int resultMinutes = totalMinutesCurrent - totalMinutesSubtract;
        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Factor має бути > 0");
        }
        int totalMinutes = getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}