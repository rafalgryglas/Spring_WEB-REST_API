package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {
    @Autowired
    private DbService service;

    @MockBean
    private TaskRepository repository;

    @Test
    public void getAllTasksTest() {
        //Given
        List<Task> tasks = new ArrayList<>();
        Task task = new Task(1L, "Test", "Testing...");
        Task task1 = new Task(2L, "Test2", "Testing...");
        tasks.add(task);
        tasks.add(task1);
        when(repository.findAll()).thenReturn(tasks);
        //When
        List<Task> resultList = service.getAllTasks();
        //Then
        assertEquals(2, resultList.size());
    }

    @Test
    public void getTaskTest() {
        //Given
        Task task = new Task(1L, "Test", "Testing...");
        when(repository.findById(task.getId())).thenReturn(Optional.ofNullable(task));
        //When
        Optional<Task> result = service.getTask(1L);
        //Then
        assertEquals("Test", result.get().getTitle());
    }

    @Test
    public void saveTaskTest() {
        //Given
        Task task = new Task(1L, "Test", "Testing...");
        Task task1 = new Task(2L, "Test", "Testing...");
        when(repository.save(task)).thenReturn(task);
        //When
        Task result = service.saveTask(task);
        //Then
        assertEquals("Test", result.getTitle());
    }
}
