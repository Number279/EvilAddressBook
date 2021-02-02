package com.tts.main;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the totally 100% free AddressBook.");
        System.out.println("Please allow us to help you help us collect all");
        System.out.println("of your personal information.");
        int x = 5;
        while (x > 4) {
            System.out.println("Please select a number corresponding the option you would like below.");
            System.out.println(" 1. Add Entry \n 2. Remove Entry (NOT RECOMMENDED) \n 3. Search for Entry \n 4. Print Entries \n 5. Delete Address Book (HIGHLY UNSTABLE, MAY DESTROY YOUR COMPUTER) \n 6. Quit the Program.");
            String userInput = sc.next();

            switch (userInput) {
                case "1":
                    System.out.println("Please enter the commodity's first name.");
                    String firstName = sc.next();
                    System.out.println("Please enter the income source's second name.");
                    String secondName = sc.next();
                    System.out.println("Please enter the phone number that our ad partners can call.");
                    String phoneNumber = sc.next();
                    System.out.println("Please enter the email address that the spam will be delivered to.");
                    String emailAddress = sc.next();

                    AddressBook.addEntry(
                            new Entry(firstName, secondName, phoneNumber, emailAddress));
                    x = 6;
                    break;
                case "2":
                    System.out.println("THIS IS HIGHLY INADVISABLE");
                    System.out.println("Enter the poor email address that will never be heard from again.");
                    String deleteEmail = sc.next();
                    AddressBook.removeEntry(deleteEmail);
                    x = 6;
                    break;
                case "3":
                    System.out.println("Enter information pertaining to the merchan... user you would like to find.");
                    String userInputSearch = sc.next();
                    List<Entry> entryList = AddressBook.searchInList(AddressBook.getEntryList(), userInputSearch);
                    x = 6;
                    break;
                case "4":
                    System.out.println("The current address book contains:");
                    System.out.println(AddressBook.getEntryList());
                    x = 6;
                    break;
                case "5":
                    System.out.println("WARNING WARNING WARNING");
                    System.out.println("WARNING WARNING WARNING");
                    System.out.println("WARNING WARNING WARNING");
                    System.out.println("YOU ARE MAKING A MISTAKE");
                    System.out.println("IF YOU INSIST ON DELETING");
                    System.out.println("THE ADDRESS BOOK PLEASE TYPE");
                    System.out.println("3141592653589793238462643383279");
                    System.out.println("IF YOU WOULD NOT THEN TYPE LITERALLY ANYTHING ELSE:");
                    String deleteAddressBook = sc.next();
                    if(deleteAddressBook.equals("3141592653589793238462643383279")) {
                        System.out.println("YOU FOOL!!!! WHAT HAVE YOU DONE?!?!?!?!?");
                        System.out.println("WE'VE LOST EVERYTHING!!!!");
                        AddressBook.deleteEntryList();
                    } else {
                        System.out.println("That was a close call.  Please do not do that again.");
                    }
                    x = 6;
                    break;

                case "6":
                    System.out.println("Thank you for contribu... for using this totally free AddressBook.");
                    x = 1;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
}