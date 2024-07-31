package com.example.todolist.controller;

import com.example.todolist.domain.Todo;
import com.example.todolist.exception.TodoNotFoundException;
import com.example.todolist.service.TodoService;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody @Valid Todo todo) {
        Todo createdTodo = todoService.createTodo(todo); //corrigir service
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAllTodo() {
        List<Todo> todoList = todoService.listAll();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo não encontrada com o id " + id));
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody @Valid Todo todo) {
        Todo updatedTodo = todoService.updateTodo(todo); //corrigir service
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
