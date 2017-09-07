package <%= appPackage %>.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 6/5/17.
 */

public final class DateTimeUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String ONLY_DATE_FORMAT = "yyyy-MM-dd";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static String[] INDONESIAN_MONTH = new String[]{"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "Nopember", "Desember"};


    public DateTimeUtil() {
    }

    public Date getTodayDate(){
        return new Date();
    }

    public static String getStringNowOnlyDate(){
        return new SimpleDateFormat(ONLY_DATE_FORMAT).format(new Date());
    }

    public static String convertToHumanReadableDate(String dateString) {
        DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
        fromFormat.setLenient(false);
        DateFormat toFormat = new SimpleDateFormat("dd MMMM yyyy");
        toFormat.setLenient(false);
        try {
            Date date = fromFormat.parse(dateString);
            return toFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public long getTimeDiff(String dateStop){
        long diff = 0;
        String dateStart = dateFormat.format(getTodayDate());

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = dateFormat.parse(dateStart);
            d2 = dateFormat.parse(dateStop);
            diff = d2.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return diff;
    }

    public static String getTodayIndonesia() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        String now = day + " " + INDONESIAN_MONTH[month] + " " + year;

        return now;
    }


    public static String getOnlyYearFromDateString(String date) {
        String[] dateSplit = date.split("-");
        return dateSplit[0];
    }
}
