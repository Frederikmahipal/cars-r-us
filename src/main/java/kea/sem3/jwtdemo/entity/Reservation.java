package kea.sem3.jwtdemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="reservation_date")
    @CreationTimestamp
    private LocalDateTime reservationDate;

    @Column(name="rental_date")
    @CreationTimestamp
    private LocalDateTime rentalDate;

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }
}
