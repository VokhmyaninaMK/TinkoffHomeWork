package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;

public class Task5 {
    private Task5() {
    }

    public record lastNameFirstName(String firstName, String lastName) {
    }

    static ArrayList<lastNameFirstName> parseContacts(ArrayList<String> contactList, String methodOfSort) {
        ArrayList<lastNameFirstName> result = new ArrayList<>();
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
            lastNameFirstName currentPerson;
            if (words.length == 2) {
                currentPerson = new lastNameFirstName(words[1], words[0]);
            } else {
                currentPerson = new lastNameFirstName(words[0], null);
            }
            result.add(currentPerson);
        }
        return result;
    }
}
