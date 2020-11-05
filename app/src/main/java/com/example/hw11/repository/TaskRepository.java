package com.example.hw11.repository;

import com.example.hw11.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {
    private static final int TASK_SIZE = 100;
    private static TaskRepository sInstance;

    public static TaskRepository getInstance() {
        if (sInstance == null)
            sInstance = new TaskRepository();

        return sInstance;
    }

    private List<Task> mTasks;

    private TaskRepository() {
        //create dummy object for test.
        mTasks = new ArrayList<>();
        for (int i = 0; i < TASK_SIZE; i++) {
            Task task = new Task();
            task.setTitle("Crime#" + (i + 1));

            mTasks.add(task);
        }
    }
}
