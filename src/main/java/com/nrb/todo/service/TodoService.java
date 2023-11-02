package com.nrb.todo.service;

import com.nrb.todo.model.Todo;
import com.nrb.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private TodoRepository repository;

    public void save(Todo todo) {
        repository.save(todo);
    }

    public List<Todo> getList() {
        return repository.findAll();
    }

    public Todo update(Long id) {
        Todo todo = repository.findById(id).orElseThrow();
        return repository.save(todo);
    }

    public void removeTodo(Long id) {
        repository.delete(update(id));
    }
}
