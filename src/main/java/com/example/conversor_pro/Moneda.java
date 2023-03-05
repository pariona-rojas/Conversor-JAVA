package com.example.conversor_pro;

import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.Map;

public class Moneda {
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id=b61fcbad62944505b2c5f183cb77c2c6";

    public static void convertir() {
        int opcionMoneda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion deseada:\n1. Convertir de pesos a dolares\n2. Convertir de soles a dolares\n3. Convertir de dolares a pesos\n4. Convertir de dolares a soles"));
        switch (opcionMoneda) {
            case 1:
                convert_to_dolar("MXN");
                break;
            case 2:
                convert_to_dolar("PEN");
                break;
            case 3:
                convert_from_dolar("MXN");
                break;
            case 4:
                convert_from_dolar("PEN");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
                break;
        }
    }

    static void convert_to_dolar(String moneda) {
        double cantidad;
        double tasaCambio;
        double dolares;
        try {
            tasaCambio = getTasaCambio(moneda);
            cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir"));
            dolares = cantidad / tasaCambio;
            dolares = Math.round(dolares * 100.0) / 100.0;
            JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " " + moneda + " equivale a " + dolares + " dolares");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las tasas de cambio");
        }
    }

    static void convert_from_dolar(String moneda) {
        double cantidad;
        double tasaCambio;
        double monedaLocal;
        try {
            tasaCambio = getTasaCambio(moneda);
            cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir"));
            monedaLocal = cantidad * tasaCambio;
            monedaLocal = Math.round(monedaLocal * 100.0) / 100.0;
            JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " dolares equivale a " + monedaLocal + " " + moneda);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las tasas de cambio");
        }
    }

    private static double getTasaCambio(String moneda) {
        String url = API_URL + "&symbols=" + moneda;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject response = restTemplate.getForObject(url, JSONObject.class);
        Map<String, Object> rates = (Map<String, Object>) response.get("rates");
        double tasaCambio = (double) rates.get(moneda);
        return tasaCambio;
    }
}