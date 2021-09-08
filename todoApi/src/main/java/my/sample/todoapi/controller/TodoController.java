package my.sample.todoapi.controller;


import my.sample.todoapi.dto.Todo;
import my.sample.todoapi.repository.TodoRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class TodoController {

	private final TodoRepository repository;

	public TodoController(TodoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("todos")
	public List<Todo> all() {
		return repository.findAll();
	}

}
