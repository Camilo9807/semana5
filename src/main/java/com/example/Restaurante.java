package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {

    private String nombre;
    private String tipoCocina;
    private String direccion;
    private int capacidad;
    private String horarioApertura;
    private String horarioCierre;
    private int mesasDisponibles;
    private List<String> menu;

    public Restaurante() {
        nombre = "No definido";
        tipoCocina = "No definido";
        direccion = "No definido";
        capacidad = 0;
        horarioApertura = "No definido";
        horarioCierre = "No definido";
        mesasDisponibles = 1;
        List<String> menu = new ArrayList<String>();
    }

    public Restaurante(String nombre, String tipoCocina, String direccion, int capacidad, String horarioApertura,
            String horarioCierre, int mesasDisponibles, List<String> menu) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.mesasDisponibles = mesasDisponibles;
        this.menu = menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(String horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public String getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(String horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public int getMesasDisponibles() {
        return mesasDisponibles;
    }

    public void setMesasDisponibles(int mesasDisponibles) {
        this.mesasDisponibles = mesasDisponibles;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    public void mostrarMenu() {
        System.out.println("Platos del menú:");
        for (String plato : menu) {
            System.out.println(plato);
        }
    }

    public void reservarMesa(int numeroPersonas) {
        if (mesasDisponibles > 0) {
            mesasDisponibles--;
            System.out.println("Mesa reservada con exito");
        } else {
            System.out.println("¡Lo sentimos, no hay mesas diponibles!!");
        }
    }

    private double calcularPrecioPlato(String nombrePlato) {
        // Mapa con los precios de cada plato
        Map<String, Double> preciosPlatos = new HashMap<>();
        preciosPlatos.put("Paella", 12.50);
        preciosPlatos.put("Gazpacho", 8.00);
        preciosPlatos.put("Tortilla", 6.50);
        preciosPlatos.put("Croquetas", 5.00);

        return preciosPlatos.getOrDefault(nombrePlato, 0.0);
    }

    // Método para calcular la factura
    public void calcularFactura(List<String> platosPedido) {
        double total = 0;
        System.out.println("Factura del restaurante " + nombre + ":");
        for (String plato : platosPedido) {
            double precio = calcularPrecioPlato(plato);
            System.out.println(plato + ": " + precio + "€");
            total += precio;
        }
        System.out.println("Total a pagar: " + total + "€");
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear una lista de platos para el menú
        List<String> menuRestaurante = new ArrayList<>();
        menuRestaurante.add("Paella");
        menuRestaurante.add("Gazpacho");
        menuRestaurante.add("Tortilla");
        menuRestaurante.add("Croquetas");

        // Crear un objeto Restaurante
        Restaurante miRestaurante = new Restaurante("La Cocina Española", "Española", "Calle Mayor, 123", 50, "12:00",
                "23:00", 10, menuRestaurante);

        // Mostrar el menú
        miRestaurante.mostrarMenu();

        // Reservar una mesa para 2 personas
        miRestaurante.reservarMesa(2);

        // Calcular la factura para un pedido
        List<String> pedido = new ArrayList<>();
        pedido.add("Paella");
        pedido.add("Tortilla");
        miRestaurante.calcularFactura(pedido);
    }

}
