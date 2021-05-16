package com.nexis.androidtutorials.CalculateActivity;

public class Operation {
    private int number1 , number2;

    public Operation(int number1, int number2){
        this.number1 = number1;
        this.number2 = number2;
    }
    public int topla(){
        return number1 + number2;
    }
    public int fark(){
        return number1 - number2;
    }
    public int carp(){
        return number1 * number2;
    }
    public int bol(){
        return number1 / number2;
    }
    }

