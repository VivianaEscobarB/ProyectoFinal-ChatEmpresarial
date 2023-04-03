package com.example.proyectofinalchatempresarial.Modelo;

import Exception.EmpleadoException;

import java.util.ArrayList;
public class MarketPlace {

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Vendedor> listaVendedoresAsociadas = new ArrayList<Vendedor>();

    public MarketPlace() {

    }

    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String cedula, String direccion) throws EmpleadoException {
        Empleado nuevoEmpleado = null;
        //1. verificar si existe
        boolean empleadoExiste = verificarEmpleadoExistente(cedula);
        if(empleadoExiste){
            throw new EmpleadoException("El empleado con cedula: "+cedula+" ya existe");
        }else{
            nuevoEmpleado = new Empleado(nombre,apellido, cedula,direccion);
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setApellido(apellido);
            nuevoEmpleado.setCedula(cedula);
            nuevoEmpleado.setDireccion(direccion);
            getListaEmpleados().add(nuevoEmpleado);

        }
        return nuevoEmpleado;
    }

    @Override
    public boolean actualizarEmpleado(String nombre, String apellido, String cedula,
                                      String direccionActual) throws EmpleadoException{
        // TODO Auto-generated method stub
        Empleado empleado = null;
        boolean flagExiste = false;
        empleado = obtenerEmpleado(cedula);
        if(empleado == null)
            throw new EmpleadoException("El empleado a actualizar no existe");
        else{
            empleado = new Empleado(nombre,apellido, cedula,direccionActual);
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setCedula();
            empleado.setDireccion(direccionActual);
            getListaEmpleados().add(empleado);
        }
        return flagExiste;
    }

    @Override
    public Boolean eliminarEmpleado(String cedula) throws EmpleadoException {
        Empleado empleado = null;
        boolean flagExiste = false;
        empleado = obtenerEmpleado(cedula);
        if(empleado == null)
            throw new EmpleadoException("El empleado a eliminar no existe");
        else{
            getListaEmpleados().remove(empleado);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public boolean verificarEmpleadoExistente(String cedula) {
        Empleado empleado = null;
        empleado = obtenerEmpleado(cedula);
        if(empleado == null)
            return false;
        else
            return true;
    }

    @Override
    public Empleado obtenerEmpleado(String cedula) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleados() {
        // TODO Auto-generated method stub
        return getListaEmpleados();
    }


    public ArrayList<Usuario> getlistaUsuarios() {
        return listaUsuarios;
    }
    public void setlistaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Vendedor> getListaVendedoresAsociadas() {
        return listaVendedoresAsociadas;
    }

    public void setListaVendedoresAsociadas(ArrayList<Vendedor> listaVendedoresAsociadas) {
        this.listaVendedoresAsociadas = listaVendedoresAsociadas;
    }


}
