package com.nrb.todo.service;

import com.nrb.todo.model.Todo;
import com.nrb.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> getList() {
        Sort sort = Sort.by("priority").descending()
                .and(Sort.by("name").ascending());
        return repository.findAll(sort);
    }

    public Todo getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Todo update(Todo todo) {
        Todo todoUpdate = getById(todo.getId());
        BeanUtils.copyProperties(todo, todoUpdate);
        return repository.save(todoUpdate);
    }

    public void removeTodo(Todo todo) {
        repository.delete(todo);
    }
}
