package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Task", "Test content");
        //When
        Task result = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals("Task", result.getTitle());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "Task", "Test content");
        //When
        TaskDto result = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals("Task", result.getTitle());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Task", "Test content"));
        taskList.add(new Task(2L, "Task 2", "Test content 2"));
        //When
        List<TaskDto> resultList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(2, resultList.size());
    }
}
