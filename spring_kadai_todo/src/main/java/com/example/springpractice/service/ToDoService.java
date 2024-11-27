package com.example.springpractice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springpractice.entity.ToDo;
import com.example.springpractice.repository.ToDoRepository;

@Service
public class ToDoService {
	//repositoryの準備
	public final ToDoRepository toDoRepository;
	
	//インジェクション
	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository = toDoRepository;
	}
	
	//データの一括取得
	public List<ToDo> getAllToDo(){
		return toDoRepository.findAll();
	}
	
}
