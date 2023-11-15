package com.nrb.todo;

import com.nrb.todo.model.Priority;
import com.nrb.todo.model.Todo;
import com.nrb.todo.model.dto.TodoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateSuccessFull() {
        TodoDto teste = new TodoDto("Teste", "TEST...", false, Priority.VERY_IMPORTANT);
        Todo todo = new Todo(teste);
        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[1].description").isEqualTo(todo.getDescription())
                .jsonPath("$[2].done").isEqualTo(todo.isDone())
                .jsonPath("$[3].priority").isEqualTo(todo.getPriority());


    }

    @Test
    void testCreateFailure() {
        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(new Todo(new TodoDto("","",false, null)))
                .exchange()
                .expectStatus().isBadRequest();

    }

    @Test
    void contextLoads() {
    }

}
