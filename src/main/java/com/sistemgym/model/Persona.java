package com.sistemgym.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Persona {

        private int id;
        private int tipodocumento;
        private String documento;
        private String nombre;
        private String apellido;
        private String telefono;
        private String direccion;
        private String correo;
        private String ruta;
        private Date nacimiento;
        private String eps;
        private String contacto;
        private String telefono2;
        private String rh;
        private long huella;
        private Timestamp modificado;

    public Persona() {
    }

    public Persona(int id, int tipodocumento, String documento, String nombre, String apellido, String telefono, String direccion, String correo, String ruta, Date nacimiento, String eps, String contacto, String telefono2, Timestamp modificado, long huella, String rh) {
        this.id = id;
        this.tipodocumento = tipodocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.ruta = ruta;
        this.nacimiento = nacimiento;
        this.eps = eps;
        this.contacto = contacto;
        this.telefono2 = telefono2;
        this.modificado = modificado;
        this.huella = huella;
        this.rh = rh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public Timestamp getModificado() {
        return modificado;
    }

    public void setModificado(Timestamp modificado) {
        this.modificado = modificado;
    }

    public long getHuella() {
        return huella;
    }

    public void setHuella(long huella) {
        this.huella = huella;
    }
}
