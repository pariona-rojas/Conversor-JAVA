package com.example.conversor_pro;

import javax.swing.*;

public class Temperatura {
    public static void convertir(){
        int opcionTemperatura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion deseada:\n1. Convertir de Celsius a Fahrenheit\n2. Convertir de Fahrenheit a Celsius"));
        switch (opcionTemperatura){
            case 1:
                convert_to_fahrenheit();
                break;
            case 2:
                convert_to_celsius();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
                break;
        }
    }

    static void convert_to_fahrenheit() {
        double celsius;
        double fahrenheit;
        celsius = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura en grados Celsius"));
        fahrenheit = (celsius * 9 / 5) + 32;
        fahrenheit = Math.round(fahrenheit * 100.0) / 100.0;
        JOptionPane.showMessageDialog(null, celsius + " grados Celsius equivale a " + fahrenheit + " grados Fahrenheit");
    }

    static void convert_to_celsius() {
        double celsius;
        double fahrenheit;
        fahrenheit = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura en grados Fahrenheit"));
        celsius = (fahrenheit - 32) * 5 / 9;
        celsius = Math.round(celsius * 100.0) / 100.0;
        JOptionPane.showMessageDialog(null, fahrenheit + " grados Fahrenheit equivale a " + celsius + " grados Celsius");
    }
}
