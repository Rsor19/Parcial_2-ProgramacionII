package co.edu.uniquindio.poo.model;

import java.util.Objects;

/**
 * Cliente que solicita un servicio tecnológico.
 */
public class Cliente {
    private String documento;
    private String nombre;
    private String correo;

    public Cliente(String documento, String nombre, String correo) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    public void setDocumento(String documento) { this.documento = documento; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }

}
