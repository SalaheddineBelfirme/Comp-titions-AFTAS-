package com.youcode.aftas.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdGenerator {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yy-MM-dd");

    public static String generateId(String cityName) {
        String prefix = cityName.substring(0, Math.min(cityName.length(), 3));
        String datePart = DATE_FORMAT.format(new Date());
        return prefix + datePart;
    }
}
