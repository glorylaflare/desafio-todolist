package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.exception.TodoNotFoundException;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> listAll() {
        Sort listaOrdenada = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return todoRepository.findAll(listaOrdenada);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        if (!todoRepository.existsById(todo.getId())) {
            throw new TodoNotFoundException("Todo não encontrada com o id " + todo.getId());
        }
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundException("Todo não encontrada com o id " + id);
        }
        todoRepository.deleteById(id);
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }
}
