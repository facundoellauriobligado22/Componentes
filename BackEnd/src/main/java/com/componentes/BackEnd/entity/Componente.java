package com.componentes.BackEnd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComponente;
    private int idUbicacion;
    private String partNumber;
    private String descripcion;
    private int idGrupo;
    private int idFabricante;
    private int stock;
    private int codigoMap;
    private String utilizacion;
    private boolean usoEnProduccion;
    private String fotoComponente;

    public Componente(int idUbicacion, String partNumber, String descripcion, int idGrupo, int idFabricante, int stock, int idComponente, String utilizacion, boolean usoEnProduccion, String fotoComponente) {
        this.idComponente = idComponente;
    }

    public Componente(int idComponente, int idUbicacion, String partNumber, String descripcion, int idGrupo, int idFabricante, int stock, int codigoMap, String utilizacion, boolean usoEnProduccion, String fotoComponente) {
        this.idComponente = idComponente;
        this.idUbicacion = idUbicacion;
        this.partNumber = partNumber;
        this.descripcion = descripcion;
        this.idGrupo = idGrupo;
        this.idFabricante = idFabricante;
        this.stock = stock;
        this.codigoMap = codigoMap;
        this.utilizacion = utilizacion;
        this.usoEnProduccion = usoEnProduccion;
        this.fotoComponente = fotoComponente;
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigoMap() {
        return codigoMap;
    }

    public void setCodigoMap(int codigoMap) {
        this.codigoMap = codigoMap;
    }

    public String getUtilizacion() {
        return utilizacion;
    }

    public void setUtilizacion(String utilizacion) {
        this.utilizacion = utilizacion;
    }

    public boolean isUsoEnProduccion() {
        return usoEnProduccion;
    }

    public void setUsoEnProduccion(boolean usoEnProduccion) {
        this.usoEnProduccion = usoEnProduccion;
    }

    public String getFotoComponente() {
        return fotoComponente;
    }

    public void setFotoComponente(String fotoComponente) {
        this.fotoComponente = fotoComponente;
    }
}

