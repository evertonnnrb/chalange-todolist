package com.nrb.todo.model;

import com.nrb.todo.model.dto.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "todos")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private boolean done;
    @Enumerated(value = EnumType.STRING)
    private Priority priority;

    public Todo(TodoDto dto) {
        this.name = dto.name();
        this.description = dto.description();
        this.done = dto.done();
        this.priority = dto.priority();
    }
}
