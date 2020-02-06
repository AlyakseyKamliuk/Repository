package com.Lesson9;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
       AlArrayList<Integer> alArrayList = new AlArrayList<Integer>();
        alArrayList.add(1);
        alArrayList.add(2);
        alArrayList.add(3);
        alArrayList.add(4);
        alArrayList.add(5);
        alArrayList.add(6);
        alArrayList.add(7);
        alArrayList.add(8);
        alArrayList.add(9);
        alArrayList.add(10);
        alArrayList.add(11);
        alArrayList.add(12);
        alArrayList.add(13);
        alArrayList.delete(10);
        System.out.println(alArrayList.size());
        System.out.println(alArrayList.toString());
        AlLinkedList<Integer> alLinkedList = new AlLinkedList<>();
        alLinkedList.add(15);
        alLinkedList.add(11);
        alLinkedList.add(12);
        alLinkedList.add(5);
        alLinkedList.add(15);
        alLinkedList.add(16);
        alLinkedList.addFirst(10);
        alLinkedList.set(1, 8);
        alLinkedList.removeFirst();
        alLinkedList.removeLast();
        for (int i = 0; i < alLinkedList.size(); i++) {
            System.out.println(alLinkedList.next());
        }

        MatcherPattern match = new MatcherPattern();
        String ss1 = "Asdfsdgdbv +-{1234:5f55} {dsfsfds:dsf} \n fgdas:1}125,55 \\\\ Adfgjdflkdlfhdlfjldf125}";
        String ss2 = "fdsfsdf. asasda; asdadad? asdasdfaf sdfsdf! dsffsdf. sdfsdfsf hgjhg. jhgjhg!";
        String ss3 = "+375298787094";
        String ss4 = "+375(29)8787094";
        String ss5 = "+375258787094";
        String ss6 = "+375298787094";
        String ss7 = "+3752987870945";
        String ss8 = "sdasd 1985:12:31 00:15 dcfsdf sdsf";
        String ss9 = "www.javarush.ru";
        match.startingWithA(ss1, 'A');
        match.OneWordSentences(ss2);
        match.isMobilePhone(ss3);
        match.isMobilePhone(ss4);
        match.isMobilePhone(ss5);
        match.isMobilePhone(ss6);
        match.isMobilePhone(ss7);
        match.searchDate(ss8);
        match.searchSite(ss9);
    }
}
