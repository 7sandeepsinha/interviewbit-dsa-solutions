package org.sandeep.maths;

public class DayOfTheWeek {
    public String solve(int d, int m, int y) {
        long days = 0;
        String[] week = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int leap = (y-1)/4 - (y-1)/100 + (y-1)/400;
        days = 365L * (y-1);
        days = days + leap;
        for(int i=0;i<m-1;i++){
            days += month[i];
        }
        boolean isLeap = false;
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0)
                    isLeap = true;
            }
        }
        if(isLeap){
            if( m >= 3){
                days++;
            }else if(m==2 && d==29){
                days++;
            }
        }

        days = days + d;
        int dayNumber = (int)days%7;
        return week[dayNumber];
    }
}
