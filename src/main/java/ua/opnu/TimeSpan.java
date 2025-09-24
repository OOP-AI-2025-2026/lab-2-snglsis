package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours + minutes / 60;
            this.minutes = minutes % 60;
        }
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return; // тесты ожидают игнор или ноль, не исключение
        }
        this.hours += hours;
        this.minutes += minutes;
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes %= 60;
        }
    }

    public void addTimeSpan(TimeSpan timespan) {
        this.add(timespan.getHours(), timespan.getMinutes());
    }

    public double getTotalHours() {
        return this.hours + this.minutes / 60.0;
    }

    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public void subtract(TimeSpan span) {
        int totalMinutesCurrent = this.getTotalMinutes();
        int totalMinutesSubtract = span.getTotalMinutes();

        if (totalMinutesSubtract >= totalMinutesCurrent) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            int resultMinutes = totalMinutesCurrent - totalMinutesSubtract;
            this.hours = resultMinutes / 60;
            this.minutes = resultMinutes % 60;
        }
    }

    public void scale(int factor) {
        if (factor <= 0) {
            this.hours = 0;
            this.minutes = 0;
            return;
        }
        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
