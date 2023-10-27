package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;

public class Task5 {
    private Task5() {
    }

    static ArrayList<String> parseContacts(ArrayList<String> contactList, String methodOfSort) {
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
        for (int i = 0; i < contactList.size(); i++) {
            String[] words = contactList.get(i).split(" ");
            if (words.length == 2) {
                contactList.set(i, words[1] + ' ' + words[0]);
            }
        }
        return contactList;
    }
}
