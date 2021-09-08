package my.sample.todoapi.controller;


import my.sample.todoapi.dto.Todo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

	@RequestMapping("todos")
	public List<Todo> helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		List<Todo> todoList = new ArrayList<>();
		Todo todo = new Todo();
		todo.setId(1);
		todo.setDesc("wahhh");
		todo.setTitle("Take over the galaxy");
		todoList.add(todo);
		todo = new Todo();

		todo.setId(2);
		todo.setDesc("destroy alderaan");
		todo.setTitle("Make sure there are no survivors left!");
		todoList.add(todo);
		return todoList;
	}
}
