package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> listAll() {
        Sort listaOrdenada = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return todoRepository.findAll(listaOrdenada);
    }

    public List<Todo> createToDo(Todo todo) {
        todoRepository.save(todo);
        return listAll();
    }

    public List<Todo> updateToDo(Todo todo) {
        todoRepository.save(todo);
        return listAll();
    }

    public List<Todo> deleteTodo(Long id) {
        todoRepository.deleteById(id);
        return listAll();
    }
}
