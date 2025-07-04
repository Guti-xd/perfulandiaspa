package com.cliente.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion") // tabla direccion
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer idDireccion;
    private String calle;
    private String ciudad;
<<<<<<< HEAD
    public void setId(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
}
=======
    @ManyToOne
    @JoinColumn(name = "id_cliente")  // nombre igual que en la tabla cliente
    private Cliente cliente;    
    }
    
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
