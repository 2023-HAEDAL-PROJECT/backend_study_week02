package com.example.haedalweek2.controller;



import com.example.haedalweek2.form.TodoForm;
import com.example.haedalweek2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller()
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    @GetMapping("/jdbc")
//    public String home(){
//        return "redirect:/read";
//    }

    @GetMapping("/jdbc/create")
    public String form(TodoForm todoForm){
        return "addTodo";
    }


    /*
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

    */

    @GetMapping("/jdbc/update")
    public @ResponseBody String update(@RequestParam Long id){
        todoService.update(id);
        //return "redirect:/";
        return "성공";
    }
}
