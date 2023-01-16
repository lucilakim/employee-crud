package ar.com.ada.backend12.employeeCrud.Utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Util {

    public Util() {
    }

    public Date parseDate(String s) {
        Date date = null;
        try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(s);
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("An ERROR occurred when trying to convert String to Date.");
            e.printStackTrace();
        }
        return date;
    }
}
