/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2425_stefanodmm;

import javax.swing.JOptionPane;

/**
 *
 * @author mainp
 */

public class Lista_Productos {
    private Nodo cabeza;
    private int tamaño;

    public Lista_Productos() {
        cabeza = null;
        tamaño = 0;
    }
    
    public void mostrar() {
        Nodo actual = cabeza;
        int contador = 1;
        StringBuilder mensaje = new StringBuilder();
        while (actual != null) {
            mensaje.append("Compra ").append(contador).append(": ")
                   .append(actual.campo1).append(", ")
                   .append(actual.campo2).append(", ")
                   .append(actual.campo3).append("\n");
            actual = actual.siguiente;
            contador++;
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Lista Doblemente Enlazada", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Nodo getCabeza() {
        return cabeza;
    }

    public void agregar(String campo1, String campo2, String campo3) {
        Nodo nuevoNodo = new Nodo(campo1, campo2, campo3);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public void eliminar(String campo1, String campo2, String campo3) {
        if (cabeza == null) return;
        Nodo actual = cabeza;
        Nodo anterior = null;
        while (actual != null && !actual.equals(campo1, campo2, campo3)) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual != null && actual.equals(campo1, campo2, campo3)) {
            if (anterior == null) {
                cabeza = cabeza.siguiente;
            } else {
                anterior.siguiente = actual.siguiente;
            }
            tamaño--;
        }
    }

    public boolean contiene(String campo1, String campo2, String campo3) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.equals(campo1, campo2, campo3)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public int tamaño() {
        return tamaño;
    }

    public void editarNodo(String campo1, String campo2, String campo3, int campoEditar, String nuevoValor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.campo1.equals(campo1) && actual.campo2.equals(campo2) && actual.campo3.equals(campo3)) {
                switch (campoEditar) {
                    case 1:
                        actual.campo1 = nuevoValor;
                        break;
                    case 2:
                        actual.campo2 = nuevoValor;
                        break;
                    case 3:
                        actual.campo3 = nuevoValor;
                        break;
                    default:
                        System.out.println("Campo no válido");
                }
                return;
            }
            actual = actual.siguiente;
        }
    }

    private static class Nodo {
        String campo1;
        String campo2;
        String campo3;
        Nodo siguiente;

        Nodo(String campo1, String campo2, String campo3) {
            this.campo1 = campo1;
            this.campo2 = campo2;
            this.campo3 = campo3;
            this.siguiente = null;
        }

        boolean equals(String campo1, String campo2, String campo3) {
            return this.campo1.equals(campo1) && this.campo2.equals(campo2) && this.campo3.equals(campo3);
        }
    }
}