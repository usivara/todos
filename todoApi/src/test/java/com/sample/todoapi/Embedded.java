package com.sample.todoapi;

import my.sample.todoapi.dto.Todo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Embedded {
    @JsonProperty("todoList")
    List<Todo> todos = new ArrayList<Todo>();

    public Embedded(){

    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> Employees) {
        this.todos = Employees;
    }
}
