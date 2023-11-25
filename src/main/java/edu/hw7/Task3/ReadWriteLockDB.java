package edu.hw7.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.Nullable;

public class ReadWriteLockDB implements PersonDatabase {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Map<Integer, Person> idMap;
    private Map<String, Person> nameMap;
    private Map<String, Person> adressMap;
    private Map<String, Person> phoneNumberMap;

    public ReadWriteLockDB() {
        this.adressMap = new HashMap<>();
        this.nameMap = new HashMap<>();
        this.idMap = new HashMap<>();
        this.phoneNumberMap = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        readWriteLock.writeLock().lock();

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

        readWriteLock.writeLock().unlock();

    }

    @Override
    public synchronized void delete(int id) {
        readWriteLock.writeLock().lock();
        Person person = idMap.remove(id);
        nameMap.remove(person.name());
        adressMap.remove(person.address());
        phoneNumberMap.remove(person.phoneNumber());
        readWriteLock.writeLock().unlock();
    }

    @Override
    public synchronized @Nullable Person findByName(String name) {
        readWriteLock.readLock().lock();
        try {
            Person person = nameMap.get(name);
            if (person.address() == null || person.phoneNumber() == null) {
                return null;
            }
            return person;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public synchronized @Nullable Person findByAddress(String address) {
        readWriteLock.readLock().lock();
        try {
            Person person = adressMap.get(address);
            if (person.name() == null || person.phoneNumber() == null) {
                return null;
            }
            return person;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public synchronized @Nullable Person findByPhone(String phone) {
        readWriteLock.readLock().lock();
        try {
            Person person = phoneNumberMap.get(phone);
            if (person.address() == null || person.name() == null) {
                return null;
            }
            return person;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int size() {
        return this.idMap.size();
    }
}
