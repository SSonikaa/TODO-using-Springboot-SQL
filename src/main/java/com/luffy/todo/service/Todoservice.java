package com.luffy.todo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luffy.todo.model.Todo;
import com.luffy.todo.repo.Itodorepo;
@Service
public class Todoservice {
	
	@Autowired
	Itodorepo repo;
	
 public List<Todo> getallitems(){
	 ArrayList<Todo> todolist = new ArrayList<>();
	 repo.findAll().forEach(todo->todolist.add(todo));
	 return todolist;
 }
 
 
 public Todo getitembyid(Long id){
	 return repo.findById(id).get();
 }
 public boolean updatestatus(Long id){
	 Todo todo = getitembyid(id);
	 todo.setStatus("ho gya update");
	 return saveorupdate(todo);
 }
 
public boolean saveorupdate(Todo todo){
	Todo updatedtodo = repo.save(todo);
	if(getitembyid(updatedtodo.getId())!= null) {
		return true;
	}
	return false;
	
}
 public boolean delete(Long id){ 
	 repo.deleteById(id);
	 if(getitembyid(id)== null) {
			return true;
		}
		
		return false;
 }
 

}
