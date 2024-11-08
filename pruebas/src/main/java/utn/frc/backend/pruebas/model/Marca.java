package utn.frc.backend.pruebas.model;

//CREATE TABLE IF NOT EXISTS "Marcas" (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//NOMBRE TEXT(30) NOT NULL
//);

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "NOMBRE")
    private String nombre;
}

