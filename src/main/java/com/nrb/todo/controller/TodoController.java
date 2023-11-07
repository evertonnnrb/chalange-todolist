package com.nrb.todo.controller;

import com.nrb.todo.model.Todo;
import com.nrb.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        return ResponseEntity.ok(service.save(todo));
    }

    //TODO implements pageable interface
    @GetMapping
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id) {
        Todo todo = service.getById(id);
        return ResponseEntity.ok(service.save(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Todo todo= service.getById(id);
        service.removeTodo(todo);
        return ResponseEntity.noContent().build();
    }

}
