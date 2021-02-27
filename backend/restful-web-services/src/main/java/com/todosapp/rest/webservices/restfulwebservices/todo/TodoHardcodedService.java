package com.todosapp.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<>();
	//this will act as DB
	private static long idCounter= 0;
	
	static {
		todos.add(new Todo(++idCounter, "riya", "Learn React", new Date(), false ));
		todos.add(new Todo(++idCounter, "riya", "Learn about MicroServices", new Date(), false ));
		todos.add(new Todo(++idCounter, "riya", "Learn Driving", new Date(), false ));
	}
		
	public List<Todo> findAll() {
		return todos;
	} 
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo == null) return null;
		
		if(todos.remove(todo)) return todo;
		
		return null;
	}
	
	public Todo findById(long id) {
		for(Todo todo : todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		
		return null;
	}

}
