package com.Lesson9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherPattern {

    public String startingWithA(String string, Character a){
        String shablon1="(\\A"+a+"| "+a+")[A-z]+";
        Pattern pattern=Pattern.compile(shablon1);
        Matcher matcher=pattern.matcher(string);
        while (matcher.find()){
           String rez=matcher.group();
            System.out.println(rez.replaceAll(" ",""));
        }


        return null;
    }

    public void OneWordSentences(String s){
        String shablon="(\\? |\\. |! |; |^[A-z ][A-z])[A-z]+(!|;|,|\\.|\\?)";
        Pattern pattern=Pattern.compile(shablon);
        Matcher matcher=pattern.matcher(s);
        while (matcher.find()){
            String rez=matcher.group();
            System.out.println(rez.replaceAll("[!.;? ]",""));
        }
    }

    public void isMobilePhone(String s){
        String shablon="\\+?375\\(?(29|33|25)\\)?\\d{7}$";
        Pattern pattern=Pattern.compile(shablon);
        Matcher matcher=pattern.matcher(s);
            System.out.println(matcher.find());
    }

    public void searchDate(String s){
            String shablon="\\d{4}:(0|1)\\d:([0-2]\\d|3[0-1]) ((0|1)\\d|2[0-3]):((0|1)\\d|2[0-3])";
        Pattern pattern=Pattern.compile(shablon);
        Matcher matcher=pattern.matcher(s);
        while (matcher.find()){
            String rez=matcher.group();
            System.out.println(rez);
        }
    }

    public void searchSite(String s){
        String shablon="(http://|https://)?(\\w{3}\\.)?\\w+\\.\\w{2,3}";
        Pattern pattern=Pattern.compile(shablon);
        Matcher matcher=pattern.matcher(s);
        while (matcher.find()){
            String rez=matcher.group();
            System.out.println(rez);
        }
    }

}
