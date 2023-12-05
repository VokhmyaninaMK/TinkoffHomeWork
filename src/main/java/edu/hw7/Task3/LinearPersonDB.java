package edu.hw7.Task3;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class LinearPersonDB implements PersonDatabase {

    private Map<Integer, Person> idMap;
    private Map<String, Person> nameMap;
    private Map<String, Person> adressMap;
    private Map<String, Person> phoneNumberMap;

    public LinearPersonDB() {
        this.adressMap = new HashMap<>();
        this.nameMap = new HashMap<>();
        this.idMap = new HashMap<>();
        this.phoneNumberMap = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        if (person.address() != null) {
            adressMap.put(person.address(), person);
        }
        if (person.name() != null) {
            nameMap.put(person.name(), person);
        }
        if (person.phoneNumber() != null) {
            phoneNumberMap.put(person.phoneNumber(), person);
        }

        idMap.put(person.id(), person);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = idMap.remove(id);
        nameMap.remove(person.name());
        adressMap.remove(person.address());
        phoneNumberMap.remove(person.phoneNumber());
    }

    @Override
    public synchronized @Nullable Person findByName(String name) {
        Person person = nameMap.get(name);
        if (person.address() == null || person.phoneNumber() == null) {
            return null;
        }
        return person;
    }

    @Override
    public synchronized @Nullable Person findByAddress(String address) {
        Person person = adressMap.get(address);
        if (person.name() == null || person.phoneNumber() == null) {
            return null;
        }
        return person;
    }

    @Override
    public synchronized @Nullable Person findByPhone(String phone) {
        Person person = phoneNumberMap.get(phone);
        if (person.address() == null || person.name() == null) {
            return null;
        }
        return person;
    }

    public int size() {
        return this.idMap.size();
    }

}
