package com.nrb.todo.model.dto;

import com.nrb.todo.model.Priority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record TodoDto(
        @NotBlank String name,
        @NotBlank String description,
        @NotEmpty boolean done,
        @NotEmpty Priority priority) {

}
