package br.com.acbueno.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends PanacheEntity {

    public String model;

    public String brand;

    public int hp;

    public String color;

}
