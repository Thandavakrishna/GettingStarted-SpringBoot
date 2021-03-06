package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

/**
 * Created by thand on 29-01-2017.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        printTo100();
        return studentService.getAllStudents();
    }

    public void printTo100(){
        int[] array = new int[101];
        try{
            printToArrayLimit(array, 1);
        }catch(ArrayIndexOutOfBoundsException e){
        }
    }

    public void printToArrayLimit(int[] array, int index){
        array[index] = array[index-1]+1;
        System.out.println("Value at " + index + "is " + array[index]);
        printToArrayLimit(array, index+1);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delteStudent(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
}
