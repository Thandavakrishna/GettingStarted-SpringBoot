package com.learn.springboot.controller;

/**
 * Created by thand on 08-05-2017.
 */
public class PerformDivision {

    public PerformDivision(){}

    public void performDivisionByNumbers(){
    /*public static void main(String[] args) {*/
        int[] array = new int[101];
        try{
            performDivisionUsingArrays(array, 1);
        }catch (ArrayIndexOutOfBoundsException e){

        }

    }

    public void performDivisionUsingArrays(int[] array, int index) {
        try {
            array[index] = array[index - 1] + 1;

            if (array[index] % 15 == 0)
                System.out.println("FizzBuzz");
            else if (array[index] % 3 == 0)
                System.out.print("Fizz");
            else if (array[index] % 5 == 0)
                System.out.print("Buzz");

            performDivisionUsingArrays(array, index + 1);
        }catch (ArrayIndexOutOfBoundsException e){

        }
    }
}
