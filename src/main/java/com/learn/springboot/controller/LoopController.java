package com.learn.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by thand on 08-05-2017.
 */
@RestController
@RequestMapping("/loop")
public class LoopController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity printNumbers(){
        print1to100();
        return (ResponseEntity) ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public void print1to100(){
        int[] array = new int[101];
        try{
            printWithrecursive(array, 1);
        }catch(ArrayIndexOutOfBoundsException e){
        }


    }

    private void printWithrecursive(int[] array, int index) {
        array[index] = array[index-1] + 1;
        System.out.println(array[index]);
        printWithrecursive(array, index+1);
    }


}
