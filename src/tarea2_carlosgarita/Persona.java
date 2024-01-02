/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_carlosgarita;

/**
 *
 * @author cgari
 */
public class Persona {
    
    private int id = 0, edad = 0;
    
    public Persona(){
        this.id = 0;
        this.edad = 0;
    }

    public Persona(int id, int edad) {
        this.id = id;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }   
}
