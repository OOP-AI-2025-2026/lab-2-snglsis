package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // Конструктор
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    // Геттеры
    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    // Додавання часу
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) return; // игнорируем некорректные значения
        this.hours += hours;
        this.minutes += minutes;
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes %= 60;
        }
    }

    // Додавання іншого TimeSpan
    public void addTimeSpan(TimeSpan timespan) {
        this.add(timespan.getHours(), timespan.getMinutes());
    }

    // Загальна кількість годин
    public double getTotalHours() {
        return this.hours + this.minutes / 60.0;
    }

    // Загальна кількість хвилин
    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    // Віднімання іншого TimeSpan
    public void subtract(TimeSpan span) {
        int totalMinutesCurrent = this.getTotalMinutes();
        int totalMinutesSubtract = span.getTotalMinutes();
        if (totalMinutesSubtract > totalMinutesCurrent) return; // игнорируем некорректное вычитание
        int resultMinutes = totalMinutesCurrent - totalMinutesSubtract;
        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    // Множення часу на фактор
    public void scale(int factor) {
        if (factor <= 0) return; // игнорируем некорректные значения
        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
