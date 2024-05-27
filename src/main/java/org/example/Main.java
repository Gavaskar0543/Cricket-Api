package org.example;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Fetch fetch = new Fetch();
        String response = fetch.run("https://dog.ceo/api/breeds/image/random");
        System.out.println(response);

    }
}