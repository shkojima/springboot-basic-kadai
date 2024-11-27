package com.example.springpractice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springpractice.entity.ToDo;
import com.example.springpractice.service.ToDoService;



@Controller
public class ToDoController {
	//サービスの準備
	private final ToDoService toDoService;
	
	//インジェクション
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	//データの受け渡し
	@GetMapping("/todo")
	public String getToDo(Model model) {
		//toDoListを取得
		List<ToDo> todos = toDoService.getAllToDo();
		//ビューにユーザーリストを渡す
		model.addAttribute("todos",todos);
		//ビューを返す
		return "ToDoView";
	}

}
