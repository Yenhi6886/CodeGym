public class NextDayCalculator {
    public static String getNextDay(int day, int month, int year) {
        int[] daysIsMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        if ((year % 400 ==0) || (year % 4 == 0 && year % 100 != 0)) {
            daysIsMonth[1] = 29;
        }
        day++;
        if (day > daysIsMonth[month-1]) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        return day+"/"+month+"/"+year;
    }
}
