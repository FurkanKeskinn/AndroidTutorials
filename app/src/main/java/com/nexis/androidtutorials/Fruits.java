package com.nexis.androidtutorials;

import java.util.ArrayList;

public class Fruits {
    private String fruitName;
    private int fruitCalorie, fruitFoto;

    public Fruits() {
    }

    public Fruits(String fruitName, int fruitCalorie, int fruitFoto) {
        this.fruitName = fruitName;
        this.fruitCalorie = fruitCalorie;
        this.fruitFoto = fruitFoto;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitCalorie() {
        return fruitCalorie;
    }

    public void setFruitCalorie(int fruitCalorie) {
        this.fruitCalorie = fruitCalorie;
    }

    public int getFruitFoto() {
        return fruitFoto;
    }

    public void setFruitFoto(int fruitFoto) {
        this.fruitFoto = fruitFoto;
    }

    static public ArrayList<Fruits> getData() {
        ArrayList<Fruits> fruitsList = new ArrayList<Fruits>();
        String[] fruits = {"Muz", "Kiraz", "Elma", "Çilek"};
        int[] calorie = {15, 30, 25, 20};
        int[] fotos = {R.drawable.jerry, R.drawable.jerry, R.drawable.jerry, R.drawable.jerry};

        for (int i = 0; i < fruits.length; i++) {
            Fruits fruit = new Fruits();
            fruit.setFruitName(fruits[i]);
            fruit.setFruitCalorie(calorie[i]);
            fruit.setFruitFoto(fotos[i]);

            fruitsList.add(fruit);
        }
        return fruitsList;
    }
}
