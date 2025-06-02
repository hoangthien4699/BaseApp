package com.example.baseapp.utils;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static String FORMAT_OLD = "yyyy-MM-dd'T'HH:mm:ss";
    public static String DATE_FORMAT_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static String FORMAT_FROM_SERVER = "yyyy-MM-dd HH:mm:ss";
    public static String FORMAT_NORMAL = "dd/MM/yyyy";
    public static String FORMAT_REVERT = "yyyy/MM/dd";
    public static String FORMAT_NORMAL_WITH_TIME = "dd/MM/yyyy HH:mm";
    public static String FORMAT_NORMAL_WITH_TIME_NO_SPACE = "ddMMyyyyHHmm";
    public static String FORMAT_NORMAL_WITH_TIME_REVERT = "HH:mm dd/MM/yyyy";
    public static String FORMAT_POST_SERVER = "yyyy-MM-dd";
    public static String FORMAT_ONLY_TIME = "HH:mm";
    public static String FORMAT_NOT_YEAR = "dd/MM";

    public static String FORMAT_DAY = "dd";
    public static String FORMAT_MONTH = "MM";
    public static String FORMAT_YEAR = "yyyy";

    public static final long SECOND_MILLIS = 1000;
    public static final long MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final long HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final long DAY_MILLIS = 24 * HOUR_MILLIS;
    private static final long MONTH_MILLIS = 20 * DAY_MILLIS;
    private static final String[] multiFormat = new String[]{
        FORMAT_OLD,
        FORMAT_FROM_SERVER,
        FORMAT_NORMAL,
        FORMAT_REVERT,
        FORMAT_NORMAL_WITH_TIME,
        FORMAT_NORMAL_WITH_TIME_REVERT,
        FORMAT_POST_SERVER,
        DATE_FORMAT_Z
    };

    public static String convertWithSuitableFormat(String input, String outputFormat, String timezoneIn, String timezoneOut) {
        for (String f : multiFormat) {
            String s = convertWithFormat(input, f, outputFormat, timezoneIn, timezoneOut);
            if (!s.isEmpty()) return s;
        }
        return "";
    }

    public static String convertWithSuitableFormat(String input, String outputFormat) {
        for (String f : multiFormat) {
            String s = convertWithFormat(input, f, outputFormat);
            if (!s.isEmpty()) return s;
        }
        return "";
    }

    public static Date convertWithSuitableFormat(String input) {
        Date date = null;
        for (String f : multiFormat) {
            SimpleDateFormat inputFormat = new SimpleDateFormat(f, Locale.getDefault());
            inputFormat.setLenient(false);
            try {
                date = inputFormat.parse(input);
                break;
            } catch (ParseException ignored) {
            }
        }
        return date;
    }

    public static String formatTimeInDay(String input) {
        DateFormat inputFormat = new SimpleDateFormat(FORMAT_OLD, Locale.getDefault());
        inputFormat.setLenient(false);
        DateFormat outputFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        try {
            Date date = inputFormat.parse(input);
            if (date != null) {
                return outputFormat.format(date);
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean compareIsAfterCurrent(String datetime) {
        Date input = convertWithSuitableFormat(datetime);
        Date current = Calendar.getInstance().getTime();
        if (input == null) {
            return false;
        } else {
            return !input.before(current); // true if input after current
        }
    }

    public static boolean compareIsAfterCurrent(String datetime, String format) {
        DateFormat inputFormat = new SimpleDateFormat(format, Locale.getDefault());
        inputFormat.setLenient(false);
        String date = inputFormat.format(Calendar.getInstance().getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        try {
            Date currentDate = dateFormat.parse(date);
            Date input = dateFormat.parse(datetime);
            if (currentDate != null && input != null) {
                return !input.before(currentDate); // true if input after current
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isOvertime(String deadline) {
        Date string = convertWithSuitableFormat(deadline);
        if (string == null) return false;
        Date currentDate = Calendar.getInstance().getTime();
        return currentDate.getTime() - string.getTime() > 0 && (currentDate.getTime() - string.getTime()) / 86400 > 0;
    }

    public static long dayBetweenWith(String to) {
        Date dTo = convertWithSuitableFormat(to);
        Date currentDate = Calendar.getInstance().getTime();
        if (dTo != null) {
            return TimeUnit.MILLISECONDS.toDays(dTo.getTime() - currentDate.getTime());
        } else {
            return 0;
        }
    }

    public static long dayBetweenWith(String from, String to) {
        Date dFrom = convertWithSuitableFormat(from);
        Date dTo = convertWithSuitableFormat(to);
        Calendar timeCurrent = Calendar.getInstance();
        Calendar timeDeadline = Calendar.getInstance();
        if (dFrom != null && dTo != null) {
            timeCurrent.setTime(dFrom);
            timeDeadline.setTime(dTo);
            return TimeUnit.MILLISECONDS.toDays(timeDeadline.getTimeInMillis() - timeCurrent.getTimeInMillis());
        } else {
            return 0;
        }
    }

    public static long dayBetweenWith(String from, String to, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        dateFormat.setLenient(false);
        Calendar timeCurrent = Calendar.getInstance();
        Calendar timeDeadline = Calendar.getInstance();
        try {
            Date dFrom = dateFormat.parse(from);
            Date dTo = dateFormat.parse(to);
            if (dFrom != null && dTo != null) {
                timeCurrent.setTime(dFrom);
                timeDeadline.setTime(dTo);
                return TimeUnit.MILLISECONDS.toDays(timeDeadline.getTimeInMillis() - timeCurrent.getTimeInMillis());
            } else {
                return 0;
            }
        } catch (ParseException e) {
            return 0;
        }
    }

    public static String convertWithFormat(String input, String format, String formatOut) {
        if (TextUtils.isEmpty(input)) return "";
        SimpleDateFormat inputFormat = new SimpleDateFormat(format, Locale.getDefault());
        SimpleDateFormat output = new SimpleDateFormat(formatOut, Locale.getDefault());
        try {
            Date d = inputFormat.parse(input);
            if (d != null) {
                return output.format(d);
            } else {
                return "";
            }
        } catch (ParseException e) {
            return "";
        }
    }

    public static String convertWithFormat(String input, String format, String formatOut, String timezoneIn, String timezoneOut) {
        if (TextUtils.isEmpty(input)) return "";
        SimpleDateFormat inputFormat = new SimpleDateFormat(format, Locale.getDefault());
        inputFormat.setLenient(false);
        inputFormat.setTimeZone(TimeZone.getTimeZone(timezoneIn));
        SimpleDateFormat output = new SimpleDateFormat(formatOut, Locale.getDefault());
        output.setLenient(false);
        output.setTimeZone(TimeZone.getTimeZone(timezoneOut));
        try {
            Date d = inputFormat.parse(input);
            if (d != null) {
                return output.format(d);
            } else {
                return "";
            }
        } catch (ParseException e) {
            return "";
        }
    }

    public static long convertToTimestamp(String time, String inputFormat) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(inputFormat, Locale.getDefault());
            formatter.setLenient(false);
            Date date = formatter.parse(time);
            if (date != null) {
                return date.getTime();
            } else {
                return 0L;
            }
        } catch (ParseException ex) {
            return 0L;
        }
    }

    public static long convertToTimestamp(String time) {
        Date date = convertWithSuitableFormat(time);
        return date.getTime();
    }

    public static long getTimeDiffWithCurrent(String time) {
        long currentTime = Calendar.getInstance().getTimeInMillis();

        Date input = convertWithSuitableFormat(time);
        if (input != null) {
            return TimeUnit.MILLISECONDS.toDays(input.getTime() - currentTime);
        } else {
            return -1;
        }
    }

    public static String[] getSplitCurrentTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat day = new SimpleDateFormat(FORMAT_DAY, Locale.getDefault());
        SimpleDateFormat month = new SimpleDateFormat(FORMAT_MONTH, Locale.getDefault());
        SimpleDateFormat year = new SimpleDateFormat(FORMAT_YEAR, Locale.getDefault());
        return new String[]{day.format(c.getTime()), month.format(c.getTime()), year.format(c.getTime())};
    }

    public static String[] getSplitTime(String input, String inputFormat) {
        SimpleDateFormat format = new SimpleDateFormat(inputFormat, Locale.getDefault());

        SimpleDateFormat day = new SimpleDateFormat(FORMAT_DAY, Locale.getDefault());
        SimpleDateFormat month = new SimpleDateFormat(FORMAT_MONTH, Locale.getDefault());
        SimpleDateFormat year = new SimpleDateFormat(FORMAT_YEAR, Locale.getDefault());


        try {
            Date date = format.parse(input);
            if (date != null) {
                String a = day.format(date);
                if (a.indexOf("0") == 0) {
                    a = a.replaceFirst("0", "");
                }
                String b = month.format(date);
                if (b.indexOf("0") == 0) {
                    b = b.replaceFirst("0", "");
                }
                return new String[]{a, b, year.format(date)};
            } else {
                return new String[]{"0", "0", "0"};
            }
        } catch (ParseException e) {
            return new String[]{"0", "0", "0"};
        }
    }

    public static String[] getSplitTime(String input) {
        SimpleDateFormat day = new SimpleDateFormat(FORMAT_DAY, Locale.getDefault());
        SimpleDateFormat month = new SimpleDateFormat(FORMAT_MONTH, Locale.getDefault());
        SimpleDateFormat year = new SimpleDateFormat(FORMAT_YEAR, Locale.getDefault());

        Date date = convertWithSuitableFormat(input);
        if (date != null) {
            String a = day.format(date);
            if (a.indexOf("0") == 0) {
                a = a.replaceFirst("0", "");
            }
            String b = month.format(date);
            if (b.indexOf("0") == 0) {
                b = b.replaceFirst("0", "");
            }
            return new String[]{a, b, year.format(date)};
        } else {
            return new String[]{"0", "0", "0"};
        }
    }

    public static int getSplitCurrentBy(String by) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(by, Locale.getDefault());
        Calendar c = Calendar.getInstance();
        return Integer.parseInt(dateFormat.format(c.getTime()));
    }

    public static String getCurrentDate(String format) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_NORMAL, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static long getCurrentDateInTimestamp() {
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }

    public static String getCurrentDateWith(int set, int value) {
        Calendar c = Calendar.getInstance();
        c.add(set, value);
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_NORMAL, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static String getCurrentDateWith(int set, int value, String format) {
        Calendar c = Calendar.getInstance();
        c.add(set, value);
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static Calendar getCalendar(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return c;
    }

    public static Calendar getCalendar(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        return c;
    }

    public static Calendar getCalendar(String input, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        Calendar c = Calendar.getInstance();
        try {
            Date date = dateFormat.parse(input);
            if (date != null) {
                c.setTime(date);
            }
            return c;
        } catch (ParseException e) {
            return c;
        }
    }

    public static String getStringCalendar(int year, int indexMonth, int day) {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_NORMAL, Locale.getDefault());
        Calendar c = Calendar.getInstance();
        c.set(year, indexMonth, day);

        return df.format(c.getTime());
    }

    public static String addDay(String input, int days, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        Calendar c = Calendar.getInstance();

        try {
            Date date = df.parse(input);
            if (date != null) {
                c.setTime(date);
                c.add(Calendar.DATE, days);
                return df.format(c.getTime());
            } else {
                return "";
            }
        } catch (ParseException e) {
            return "";
        }
    }

    public static String getCalculatedDate(String date, int days) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        if (!date.isEmpty()) {
            try {
                cal.setTime(s.parse(date));
                cal.add(Calendar.DATE, days);
                return output.format(new Date(cal.getTimeInMillis())) + "T07:00:00";
            } catch (ParseException e) {

            }
        }
        return "";
    }

    public static String getCurrentTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_ONLY_TIME, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static String getStartOfDay(int set, int value, String format, String timezone) {
        Calendar c = Calendar.getInstance();
        c.add(set, value);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        df.setTimeZone(TimeZone.getTimeZone(timezone));
        return df.format(c.getTime());
    }

    public static String getStartOfDay(String format, String timezone) {
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getDefault());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        df.setTimeZone(TimeZone.getTimeZone(timezone));
        return df.format(c.getTime());
    }

    public static String getEndOfDay(String format) {
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getDefault());
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static boolean isToDay(String input) {
        long time = convertToTimestamp(input);
        return android.text.format.DateUtils.isToday(time);
    }
}
