package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;

public class Task5 {
    private Task5() {
    }


    static ArrayList<LastNameFirstName> parseContacts(ArrayList<String> contactList, String methodOfSort) {
        ArrayList<LastNameFirstName> result = new ArrayList<>();
        for (int i = 0; i < contactList.size(); i++) {
            String[] words = contactList.get(i).split(" ");
            if (words.length == 2) {
                contactList.set(i, words[1] + ' ' + words[0]);
            }
        }
        if (methodOfSort.equals("ASC")) {
            Collections.sort(contactList);
        } else {
            contactList.sort(Collections.reverseOrder());
        }
        for (String s : contactList) {
            String[] words = s.split(" ");
            LastNameFirstName currentPerson;
            if (words.length == 2) {
                currentPerson = new LastNameFirstName(words[1], words[0]);
            } else {
                currentPerson = new LastNameFirstName(words[0], null);
            }
            result.add(currentPerson);
        }
        return result;
    }


    public record LastNameFirstName(String firstName, String lastName) {
    }
}
