package edu.hw7.Task3Test;

import edu.hw7.Task3.LinearPersonDB;
import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import edu.hw7.Task3.ReadWriteLockDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReadWriteLockDBTest {

    public static PersonDatabase personDatabase;

    @BeforeEach
    void refreshStorage() {
        personDatabase = new ReadWriteLockDB();
    }


    @Test
    @DisplayName("Test add function")
    void testAdd() {
        Thread thread1 = new Thread(() -> {
            personDatabase.add(new Person(11, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(12, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(13, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(14, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(15, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(16, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(17, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(18, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(19, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(20, "masha", "Kursk", "80808080808"));
        });

        Thread thread2 = new Thread(() -> {
            personDatabase.add(new Person(1, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(2, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(3, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(4, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(5, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(6, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(7, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(8, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(9, "masha", "Kursk", "80808080808"));
            personDatabase.add(new Person(10, "masha", "Kursk", "80808080808"));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            fail("Fail! Exception catch`s");
        }

        ReadWriteLockDB resultDB = (ReadWriteLockDB) personDatabase;
        int result = resultDB.size();

        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("Test delete function")
    void testDelete() {
        personDatabase.add(new Person(1, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(2, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(3, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(4, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(5, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(6, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(7, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(8, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(9, "masha", "Kursk", "80808080808"));
        personDatabase.add(new Person(10, "masha", "Kursk", "80808080808"));

        Thread thread1 = new Thread(() -> {
            personDatabase.delete(6);
            personDatabase.delete(7);
            personDatabase.delete(8);
            personDatabase.delete(9);
            personDatabase.delete(10);
        });

        Thread thread2 = new Thread(() -> {
            personDatabase.delete(1);
            personDatabase.delete(2);
            personDatabase.delete(3);
            personDatabase.delete(4);
            personDatabase.delete(5);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            fail("Fail! Exception catch`s");
        }

        ReadWriteLockDB resultDB = (ReadWriteLockDB) personDatabase;
        int result = resultDB.size();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Test findByName function")
    void testFindByName() {
        Person person = new Person(1, "masha", "Kursk", "80808080808");
        personDatabase.add(person);
        personDatabase.add(new Person(1, "sasha", "Kursk", "80808080808"));
        personDatabase.add(new Person(1, null, "Kursk", "80808080808"));
        personDatabase.add(new Person(1, "dasha", "Kursk", "80808080808"));

        assertThat(personDatabase.findByName("masha")).isEqualTo(person);
    }

    @Test
    @DisplayName("Test findByAddress function")
    void testFindByAddress() {
        Person person = new Person(1, "masha", "Kursk", "80808080808");
        personDatabase.add(person);
        personDatabase.add(new Person(1, "sasha", "Saratov", "80808080808"));
        personDatabase.add(new Person(1, "glasha", "Samara", "80808080808"));
        personDatabase.add(new Person(1, "dasha", null, "80808080808"));

        assertThat(personDatabase.findByAddress("Kursk")).isEqualTo(person);
    }

    @Test
    @DisplayName("Test findByPhone function")
    void testFindByPhone() {

        Person person = new Person(1, "masha", "Kursk", "11");
        personDatabase.add(person);
        personDatabase.add(new Person(1, "sasha", "Saratov", "22"));
        personDatabase.add(new Person(1, "glasha", "Samara", "33"));
        personDatabase.add(new Person(1, "dasha", "Orel", "null"));

        assertThat(personDatabase.findByPhone("11")).isEqualTo(person);
    }
}
