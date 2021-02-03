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

    public static void addEntry(Entry entry) {
        var isNotUnique = entryList.stream()
                .anyMatch(e -> e.getEmailAddress().equals(entry.getEmailAddress()));

        if (isNotUnique) {
            System.out.print("We've already sold that email address! The ad guys won't buy it twice!");
        }  else {
            entryList.add(entry);
            System.out.println(entry);
            System.out.print("Thanks for the donati... addition to the address book!");
        }
    }


    public static void removeEntry(String email){
        System.out.println("Attempting to remove..." + email);
        try{
            System.out.println(findEntry(email));
            System.out.println("Removed " + email + " from the Address Book.");
            entryList.removeIf(entry -> entry.getEmailAddress().equals(email));
    } catch (Exception e){
            System.out.println("There was nothing to remove!");
        } finally {
            System.out.println("That was unproductive!");
        }
    }

    public static List<Entry> searchInList(String userInputSearch) {
        boolean ans = false;
        List<Entry> results = new ArrayList<>();
        for (Entry entry : entryList) {
            if (entry.toString().contains(userInputSearch)) {
                results.add(entry);
                ans = true;
            }
        }
            if(ans){
                System.out.println(results);
        } else {
                System.out.println("We haven't made money on that yet!  Add more data for free!!");
            }
            return null;
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
