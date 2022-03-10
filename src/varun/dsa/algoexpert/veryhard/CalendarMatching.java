package varun.dsa.algoexpert.veryhard;

import java.util.ArrayList;
import java.util.List;

/**
 * Calendar Matching
 * Imagine that you want to schedule a meeting of a certain duration with a co-worker. You have access to your
 * calendar and your coworker's calendar (both of which contain your respective meetings for the day, in the form
 * of [startTime, endTime] ), as well as both of your daily bounds (i.e., the earliest and latest times at which you're
 * available for meetings every day, in the form of [earliestTime, latestTime] ).
 * Write a function that takes in your calendar, your daily bounds, your co-worker's calendar, your co-worker's daily
 * bounds, and the duration of the meeting that you want to schedule, and that returns a list of all the time blocks
 * (in the form of [startTime, endTime] ) during which you could schedule the meeting, ordered from earliest time block to latest.
 * Note that times will be given and should be returned in military time. For example: 8:30 , 9:01 , and 23:56
 * Also note that the given calendar times will be sorted by start time in ascending order, as you would expect them to
 * appear in a calendar application like Google Calendar.
 *
 * Sample Input
 * calendari = [['9:00', '10:30'], ['12:00', '13:00'], ['16:00', '18:00'])
 * dailyBoundsi = ['9:00', '20:00']
 * calendar2 = [['10:00', '11:30'], ['12:30', '14:30'], ['14:30', '15:00'], ['16:00', '17:00']],
 * dailyBounds2 = ['10:00', '18:30'] meetingDuration = 30
 *
 * Sample Output
 * [['11:30', '12:00'], ['15:00', '16:00'], ['18:00', '18:30']]
 *
 * Complexity:
 * Time Complexity -> O(c1+c2)
 * Space Complexity -> O(c1+c2)
 *
 * Problem Link: https://www.algoexpert.io/questions/Calendar%20Matching
 */
class CalendarMatching {
    public static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /*Solution Explanation:
    1. Since we have dailyBounds as separate variable, we will have to add them to the calendar list and make it a single calendar per person.
    2. Once we add two more meetings, we have one calendar per person.
    3. Then we try to merge both calenaders to one list of unavailablilities. To do this, we will have to compare and we need to convert string to int.
    We can convert the time from string to minutes.
    4. Once done, we have one full list of unavailibilites. We can further merge cover-ups and flatten this.
    5. Once done, we then have to calculate gaps between previous end and current start and add it to the list.
    6. last step would be convert the minutes string back to string and return it.*/

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));
        StringMeeting dailyBounds1 = new StringMeeting("09:00", "20:00");
        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));
        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");

        List<StringMeeting> result = calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, 30);
        for (StringMeeting r : result) {
            System.out.println(r.toString());
        }
    }

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration
    ) {
        List<Meeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
        List<Meeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
        List<Meeting> mergedCalendar = mergeCalendars(updatedCalendar1, updatedCalendar2);
        List<Meeting> flattenedCalendar = flattenCalendar(mergedCalendar);
        return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
    }

    public static List<Meeting> mergeCalendars(List<Meeting> calendar1, List<Meeting> calendar2) {
        List<Meeting> merged = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < calendar1.size() && j < calendar2.size()) {
            Meeting meeting1 = calendar1.get(i);
            Meeting meeting2 = calendar2.get(j);

            if (meeting1.start < meeting2.start) {
                merged.add(meeting1);
                i++;
            } else {
                merged.add(meeting2);
                j++;
            }
        }

        while (i < calendar1.size()) {
            merged.add(calendar1.get(i));
            i++;
        }

        while (j < calendar2.size()) {
            merged.add(calendar2.get(j));
            j++;
        }

        return merged;
    }

    public static List<Meeting> flattenCalendar(List<Meeting> calendar) {
        List<Meeting> flattened = new ArrayList<Meeting>();
        flattened.add(calendar.get(0));
        for (int i = 1; i < calendar.size(); i++) {
            Meeting currentMeeting = calendar.get(i);
            Meeting previousMeeting = flattened.get(flattened.size() - 1);
            if (previousMeeting.end >= currentMeeting.start) {
                Meeting newPreviousMeeting = new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
                flattened.set(flattened.size() - 1, newPreviousMeeting);
            } else {
                flattened.add(currentMeeting);
            }
        }
        return flattened;
    }

    public static List<StringMeeting> getMatchingAvailabilities(List<Meeting> calendar, int meetingDuration) {
        List<Meeting> matchingAvailibilites = new ArrayList<Meeting>();
        for (int i = 1; i < calendar.size(); i++) {
            int start = calendar.get(i - 1).end;
            int end = calendar.get(i).start;
            int availabilityDuration = end - start;
            if (availabilityDuration >= meetingDuration) {
                matchingAvailibilites.add(new Meeting(start, end));
            }
        }

        List<StringMeeting> matchingAvailibilityInHours = new ArrayList<StringMeeting>();
        for (int i = 0; i < matchingAvailibilites.size(); i++) {
            matchingAvailibilityInHours.add(
                    new StringMeeting(minutesToTime(matchingAvailibilites.get(i).start),
                            minutesToTime(matchingAvailibilites.get(i).end)));
        }
        return matchingAvailibilityInHours;
    }

    public static List<Meeting> updateCalendar(
            List<StringMeeting> calendar,
            StringMeeting dailyBounds
    ) {
        List<StringMeeting> updatedCalendar = new ArrayList<StringMeeting>();
        updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
        updatedCalendar.addAll(calendar);
        updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        List<Meeting> calendarInMinutes = new ArrayList<>();
        for (StringMeeting stringMeeting : updatedCalendar) {
            calendarInMinutes.add(new Meeting(timeToMinutes(stringMeeting.start), timeToMinutes(stringMeeting.end)));
        }
        return calendarInMinutes;
    }

    public static int timeToMinutes(String time) {
        String[] values = time.split(":");
        int hour = Integer.parseInt(values[0]);
        int minutes = Integer.parseInt(values[1]);
        return hour * 60 + minutes;
    }

    public static String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        String hoursString = Integer.toString(hours);
        String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
        return hoursString + ":" + minutesString;
    }

    public static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ":" + end + "]";
        }
    }

}
