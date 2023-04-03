package Modelo;

public class Empleado extends Persona{

    private String cargo;

    public Empleado(String nombre, String apellido, String cedula , String direccion){
        super(nombre, apellido,cedula,direccion);


        this.cargo= cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
