package com.example.fastmat;

import java.util.Random;

public class Calculation {
    private static int [] numbers = {
            1,2,3,4,5,6,7,8,9,10,11,12
    };

    private static String [] operators = {
        "+", "-", "*"
    };

    private int firstNumber;
    private int secondNumber;
    private String operator;

    public void generateQuestion(){
        Random random = new Random();
        firstNumber = numbers[random.nextInt(numbers.length)];
        secondNumber = numbers[random.nextInt(numbers.length)];
        operator = operators[random.nextInt(operators.length)];

        /*
            This operation is done to avoid having negative answers,
            since the Android default keyboard does not have a "negative" key
         */
        if(firstNumber < secondNumber){
            int temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
    }

    public String getQuestion(){
        if(operator.equals("*")){
            operator = "x"; //Instead of showing * for multiplication, we will use x
        }
        String operation = firstNumber + " " + operator + " " + secondNumber;
        return operation;

    }

    public int getAnswer(){
        int answer = 0;
        if(operator.equals("*")){
            answer = firstNumber*secondNumber;
        } else if(operator.equals("-")){
            answer = firstNumber-secondNumber;
        } else if(operator.equals("+")){
            answer = firstNumber + secondNumber;
        }
        return answer;
    }
}
