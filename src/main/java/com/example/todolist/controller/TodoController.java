package com.example.todolist.controller;

import com.example.todolist.domain.Todo;
import com.example.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public List<Todo> createTodo(@RequestBody @Valid Todo todo) {
        return todoService.createToDo(todo);
    }

    @GetMapping
    public List<Todo> listAllTodo() {
        return todoService.listAll();
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody @Valid Todo todo) {
        return todoService.updateToDo(todo);
    }

    @DeleteMapping("{id}")
    public List<Todo> deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }
}
