class Solution {
     // Days in each month (non-leap year)
    static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] weekDays = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

    public String dayOfTheWeek(int day, int month, int year) {
        int days = 0;

        // Count days for the years
        for (int y = 1971; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        // Count days for the months of the current year
        for (int m = 1; m < month; m++) {
            days += daysInMonth[m - 1];
            if (m == 2 && isLeap(year)) {
                days += 1;  // Leap day
            }
        }

        // Add days in the current month
        days += day - 1;

        return weekDays[days % 7];
    }

    // Leap year check
    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
