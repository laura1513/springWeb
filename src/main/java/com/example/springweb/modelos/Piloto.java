package com.example.springweb.modelos;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("pilotos")
public class Piloto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Field("driver")
    private String nombre;
    @Field("abbreviation")
    private String abreviatura;
    @Field("no")
    private int numero;
    @Field("team")
    private String equipo;
    @Field("country")
    private String pais;
    @Field("date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
}