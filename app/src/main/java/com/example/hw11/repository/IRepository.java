package com.example.hw11.repository;

import com.example.hw11.model.Task;

import java.util.List;
import java.util.UUID;

public interface IRepository {
    List<Task> getTasks();
    Task getTask(UUID taskId);
    void insertTask(Task task);
    void updateTask(Task task);
    void deleteTask(Task task);
    int getPosition(UUID taskId);
}
