package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return this.hours;
    }


    public int getMinutes() {
        return this.minutes;
    }


    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            return; // нічого не змінюємо
        }
        this.hours += hours;
        this.minutes += minutes;
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes %= 60;
        }
    }


    public void addTimeSpan(TimeSpan timespan) {
        if (timespan != null) {
            this.add(timespan.getHours(), timespan.getMinutes());
        }
    }


    public double getTotalHours() {
        return this.hours + this.minutes / 60.0;
    }


    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public void subtract(TimeSpan span) {
        if (span == null) return;

        int totalMinutesCurrent = this.getTotalMinutes();
        int totalMinutesSubtract = span.getTotalMinutes();

        if (totalMinutesSubtract > totalMinutesCurrent) {
            return; // нічого не змінюємо
        }

        int resultMinutes = totalMinutesCurrent - totalMinutesSubtract;
        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return; // нічого не змінюємо
        }
        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}

