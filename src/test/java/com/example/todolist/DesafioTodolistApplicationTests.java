package com.example.todolist;

import com.example.todolist.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo 1", "desc 1", false, 1);
		webTestClient.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("$.nome").isEqualTo(todo.getNome())
				.jsonPath("$.descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$.realizado").isEqualTo(todo.isRealizado())
				.jsonPath("$.prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testCreateTodoFailure() {
		var todo = new Todo("", "", false, 0);
		webTestClient.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest();
	}

}
