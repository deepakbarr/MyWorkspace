package com.workspace.demo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String value = "0001-01-01 00:00:00";

        LocalDateTime out=  LocalDateTime.from(timestampFormat(-1).parse(value));
        System.out.println(out.toEpochSecond(ZoneOffset.MAX));
    }

    private static DateTimeFormatter timestampFormat(int length) {
        final DateTimeFormatterBuilder dtf = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd HH:mm:ss");

        if (length !=-1) {
            dtf.appendFraction(ChronoField.MICRO_OF_SECOND, 0, length, true);
        }
        return dtf.toFormatter();
    }

}
