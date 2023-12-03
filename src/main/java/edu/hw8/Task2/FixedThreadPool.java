package edu.hw8.Task2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedThreadPool implements ThreadPool {

    private static int threadsCount = 0;
    private static final Queue<Runnable> TASKS = new ArrayDeque<>();
    private static final AtomicBoolean CLOSED = new AtomicBoolean(true);

    public void create(int threadsCount) {
        FixedThreadPool.threadsCount = threadsCount;
        CLOSED.set(false);
    }

    public boolean tasksIsEmpty() {
        return TASKS.isEmpty();
    }

    public boolean isClosed() {
        return CLOSED.get();
    }

    public Runnable getTask() {
        return TASKS.poll();
    }

    public Queue<Runnable> getTasks() {
        return TASKS;
    }

    @Override
    public void start() {
        if (threadsCount <= 0) {
            throw new RuntimeException();
        } else {
            for (int index = 0; index < threadsCount; index++) {
                NewThread thread = new NewThread(this);
                thread.start();
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (!CLOSED.get()) {
            TASKS.add(runnable);
        }
    }

    @Override
    public void close() throws Exception {
        CLOSED.set(true);
        TASKS.clear();
    }
}
