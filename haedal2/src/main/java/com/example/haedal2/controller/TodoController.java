package com.example.haedal2.controller;

import com.example.haedal2.domain.Todo;
import com.example.haedal2.dto.TodoDto;
import com.example.haedal2.form.TodoForm;
import com.example.haedal2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

   /* @GetMapping()
    public String home(){
        return "redirect:/read";
    }

    @GetMapping("create")
    public String form(TodoForm todoForm){
        return "addTodo";
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

    @GetMapping("read") //조회 DB에 저장된 모든 할일 리스트를 가져와서 보여주는 코드
    public ModelAndView read(){
        List<Todo> todoList; //목록들을 담아올 객체
        todoList = todoService.read();
        ModelAndView view= new ModelAndView("listTodo");
        view.addObject("todoList",todoList);

        return view;

    }

    @GetMapping("delete")
    public String delete(@RequestParam Long id){
        todoService.delete(id);
        return "redirect:/read";
    }

    @GetMapping("update")
    public String update(@RequestParam Long id){
        todoService.update(id);
        return "redirect:/read";
    }*/
    //    @GetMapping("/jdbc")
//    public String home(){
//        return "redirect:/read";
//    }
    @GetMapping("/jdbc")
    public String home(){
        return "redirect:/read";
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
            return "redirect:/read";
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
        return "redirect:/read";
    }


    @GetMapping("/jdbc/update")
    public @ResponseBody String update(@RequestParam Long id){
        todoService.update(id);
        //return "redirect:/";
        return "성공";
    }


}

