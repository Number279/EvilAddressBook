package com.tts.main;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

//this class is pretty much just a utility class
//as such all of the properties will be static
public class AddressBook {

    //field: an arrayList of generic type Entries

    private static List<Entry> entryList = new ArrayList<>();

    //methods: ways to manipulate the array list

    //add method

    public static void addEntry(Entry entry){
//        HashSet<Entry> set = new HashSet<>();
//        for(Entry i : entryList){
//            if(!set.contains(i)){
                entryList.add(entry);
//                set.add(i);
//            }
//            if(set.contains(i)){
//                System.out.println("This information has already been sold.");
//            }
//        }
        System.out.println("Added" + entry);
    }

    public static void removeEntry(String email){
        System.out.println("Deleted the following entry:");
        System.out.println(findEntry(email));
        entryList.removeIf(entry -> entry.getEmailAddress().equals(email));
    }

    public static List<Entry> searchInList(List<Entry> entryList, String userInputSearch){
        List<Entry> results = new ArrayList<>();
        for (Entry entry : entryList) {
            if(entry.toString().contains(userInputSearch)) {
                results.add(entry);
                System.out.println(results);
            } else {
                System.out.println("Your search did not yield profitable results.");
            }
        }
        return results;
    }

    public static Entry findEntry (String email) {
        return entryList.stream()
                .filter(entry -> entry.getEmailAddress().equals(email))
                .findFirst()
                .orElseThrow();
    }

    public static List<Entry> getEntryList() {
        return entryList;
    }

    public static void setEntryList(List<Entry> entryList) {
        AddressBook.entryList = entryList;
    }

    public static void deleteEntryList() {
        entryList.removeAll(entryList);
    }
}
