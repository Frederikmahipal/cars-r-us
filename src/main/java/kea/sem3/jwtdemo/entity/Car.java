package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pricePrDay;
    private String brand;
    private String model;

    @Column(name="created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "last edited")
    @UpdateTimestamp
    private LocalDateTime lastEdited;

    public Car(int pricePrDay, String brand, String model) {
        this.pricePrDay = pricePrDay;
        this.brand = brand;
        this.model = model;
    }

    public Car() {
    }
}
