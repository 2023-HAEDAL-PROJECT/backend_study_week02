package com.example.haedalweek2.controller;



import com.example.haedalweek2.domain.Todo;
import com.example.haedalweek2.dto.TodoDto;
import com.example.haedalweek2.form.TodoForm;
import com.example.haedalweek2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/jdbc")
    public String home(){
        return "redirect:/jdbc/read";
    }

    @GetMapping("/jdbc/create")
    public String form(TodoForm todoForm){
        return "addTodo";
    }


    @PostMapping("/jdbc/create")
    public String create(TodoForm todoForm){
        String task = todoForm.getTask();
        System.out.println(task);
        TodoDto todoDto = todoService.create(task);
        if(todoDto.isSuccess()){
            return "redirect:/jdbc/read";
        }
        else{
            return "addTodo";
        }
    }


    @GetMapping("/jdbc/read")
    public ModelAndView read(){
        List<Todo> todoList;
        todoList = todoService.read();
        ModelAndView view = new ModelAndView("listTodo");
        view.addObject("todoList",todoList);

        return view;
    }


    @GetMapping("/jdbc/delete")
    public String delete(@RequestParam Long id){
        todoService.delete(id);
        return "redirect:/jdbc/read";
    }


    @GetMapping("/jdbc/update")
    public String update(@RequestParam Long id){
        todoService.update(id);
        return "redirect:/jdbc/read";
    }
}
