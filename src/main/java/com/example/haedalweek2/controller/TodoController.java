package com.example.haedalweek2.controller;


import com.example.haedalweek2.domain.Todo;
import com.example.haedalweek2.dto.TodoDto;
import com.example.haedalweek2.form.TodoForm;
import com.example.haedalweek2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping()
    public String home(){
        return "redirect:/read";
    }

    @GetMapping("create")
    public String form(TodoForm todoForm){
        return "addTodo";
    }

    // json 형태 반환 예시
    @PostMapping("create/json")
    public @ResponseBody TodoDto create_json(TodoForm todoForm){
        String task = todoForm.getTask();
        System.out.println(task);

        TodoDto todoDto = todoService.create(task);
        return todoDto;
    }

    @PostMapping("create")
    public String create(TodoForm todoForm){
        String task = todoForm.getTask();
        System.out.println(task);
        TodoDto todoDto = todoService.create(task);
        if(todoDto.isSuccess()){
            return "redirect:/read";
        }
        else{
            return "addTodo";
        }
    }


    @GetMapping("read")
    public ModelAndView read(){
        List<Todo> todoList;
        todoList = todoService.read();
        ModelAndView view = new ModelAndView("listTodo");
        view.addObject("todoList",todoList);

        return view;
    }
}