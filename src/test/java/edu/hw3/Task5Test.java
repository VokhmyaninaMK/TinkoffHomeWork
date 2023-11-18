package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Checking ParseContacts function efficiency")
    void testParseContacts() {
        ArrayList<String> test1 = new ArrayList<>();
        test1.add("Thomas Aquinas");
        test1.add("John Locke");
        test1.add("David Hume");
        test1.add("Rene Descartes");
        assertThat(edu.hw3.Task5.parseContacts(test1, "ASC").toString()).isEqualTo(
            "[LastNameFirstName[firstName=Thomas, lastName=Aquinas], LastNameFirstName[firstName=Rene, lastName=Descartes], LastNameFirstName[firstName=David, lastName=Hume], LastNameFirstName[firstName=John, lastName=Locke]]");

        ArrayList<String> test2 = new ArrayList<>();
        test2.add("Thomas Aquinas");
        test2.add("John Locke");
        test2.add("David Hume");
        test2.add("Rene Descartes");
        assertThat(edu.hw3.Task5.parseContacts(test2, "DESC").toString()).isEqualTo(
            "[LastNameFirstName[firstName=John, lastName=Locke], LastNameFirstName[firstName=David, lastName=Hume], LastNameFirstName[firstName=Rene, lastName=Descartes], LastNameFirstName[firstName=Thomas, lastName=Aquinas]]");

        ArrayList<String> test3 = new ArrayList<>();
        test3.add("A BBB");
        test3.add("BBB A");
        test3.add("C");
        test3.add("DD DD");
        assertThat(edu.hw3.Task5.parseContacts(test3, "ASC").toString()).isEqualTo(
            "[LastNameFirstName[firstName=BBB, lastName=A], LastNameFirstName[firstName=A, lastName=BBB], LastNameFirstName[firstName=C, lastName=null], LastNameFirstName[firstName=DD, lastName=DD]]");

        ArrayList<String> test4 = new ArrayList<>();
        test4.add("A BBB");
        test4.add("BBB A");
        test4.add("C");
        test4.add("DD DD");
        assertThat(edu.hw3.Task5.parseContacts(test4, "DESC").toString()).isEqualTo(
            "[LastNameFirstName[firstName=DD, lastName=DD], LastNameFirstName[firstName=C, lastName=null], LastNameFirstName[firstName=A, lastName=BBB], LastNameFirstName[firstName=BBB, lastName=A]]");
    }
}
