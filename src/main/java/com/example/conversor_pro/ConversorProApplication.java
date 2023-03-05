package com.example.conversor_pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class ConversorProApplication {

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion deseada:\n1. Conversor de moneda\n2. Conversor de temperatura\n3. Salir"));
            switch (opcion){
                case 1:
                    Moneda.convertir();
                    break;
                case 2:
                    Temperatura.convertir();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }
        } while (opcion != 3);

    }

}
