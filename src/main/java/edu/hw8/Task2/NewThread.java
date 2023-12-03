package edu.hw8.Task2;

public class NewThread extends Thread {
    private final FixedThreadPool threadPool;

    public NewThread(FixedThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        while (!threadPool.tasksIsEmpty() || threadPool.isClosed()) {
            Runnable task = threadPool.getTask();
            if (task != null) {
                task.run();
            }
        }
    }
}
