package com.example.mantenimiento;

import java.util.Date;

public class FormResponsePMI {
    private int status;

    private int idUsuario;
    private String municipio;

    private String folio;
    private String cuadrilla;
    private String fecha_visita;
    private String tipo_mantenimiento;
    private String placas_vehiculo;
    private String pmi_id;

    public int getStatus(){return status;}

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }


    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(String cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public String getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(String fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public String getTipo_mantenimiento() {
        return tipo_mantenimiento;
    }

    public void setTipo_mantenimiento(String tipo_mantenimiento) {
        this.tipo_mantenimiento = tipo_mantenimiento;
    }

    public String getPlacas_vehiculo() {
        return placas_vehiculo;
    }

    public void setPlacas_vehiculo(String placas_vehiculo) {
        this.placas_vehiculo = placas_vehiculo;
    }

    public String getPmi_id() {
        return pmi_id;
    }

    public void setPmi_id(String pmi_id) {
        this.pmi_id = pmi_id;
    }
}
