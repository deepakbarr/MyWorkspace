//package com.workspace.lens;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.Instant;
//import java.util.Date;
//import java.util.Locale;
//import java.util.TimeZone;
//
//import org.joda.time.format.DateTimeFormatter;
//import org.joda.time.format.ISODateTimeFormat;
//
///**
// * Hello world!
// *
// */
//public class App
//{
//    public static void main( String[] args )
//    {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
//        df.setTimeZone(TimeZone.getTimeZone("IST"));
//        String output = df.format(new Date());
//        System.out.println("output = " + output);
//        DateTimeFormatter dtf = ISODateTimeFormat.dateTime();
//        System.out.println(ISODateTimeFormat.dateTime());
//
//        System.out.println("Instant.now().toString(); = " + Instant.now().toString());
//
////        DateTimeFormatter formatter = DateTimeFormat.forPattern( "MM/dd/yyyy" ).withZone( timeZone );
//
//
//    }
//}
