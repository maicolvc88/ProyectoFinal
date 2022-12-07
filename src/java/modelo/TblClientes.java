/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iud_m
 */
@Entity
@Table(name = "tbl_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblClientes.findAll", query = "SELECT t FROM TblClientes t"),
    @NamedQuery(name = "TblClientes.findByCedulaCliente", query = "SELECT t FROM TblClientes t WHERE t.cedulaCliente = :cedulaCliente"),
    @NamedQuery(name = "TblClientes.findByNombreCliente", query = "SELECT t FROM TblClientes t WHERE t.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "TblClientes.findByDireccionCliente", query = "SELECT t FROM TblClientes t WHERE t.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "TblClientes.findByTelefonoCliente", query = "SELECT t FROM TblClientes t WHERE t.telefonoCliente = :telefonoCliente")})
public class TblClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula_cliente")
    private Integer cedulaCliente;
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "direccion_cliente")
    private String direccionCliente;
    @Column(name = "telefono_cliente")
    private String telefonoCliente;

    public TblClientes() {
    }

    public TblClientes(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public TblClientes(Integer cedulaCliente, String nombreCliente, String direccionCliente, String telefonoCliente) {
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
    }
    
    

    public void setCedulaCliente(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaCliente != null ? cedulaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblClientes)) {
            return false;
        }
        TblClientes other = (TblClientes) object;
        if ((this.cedulaCliente == null && other.cedulaCliente != null) || (this.cedulaCliente != null && !this.cedulaCliente.equals(other.cedulaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TblClientes[ cedulaCliente=" + cedulaCliente + " ]";
    }
    
}
