package com.example.haedalweek2.dto;


import lombok.Data;

@Data
public class TaskDto {
    private String task;
    private boolean done;
    private Long id;
}
