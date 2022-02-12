package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "member")
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser {
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private boolean approved;
    private int ranking;
    @Column(name="date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "date_edited")
    @UpdateTimestamp
    private LocalDateTime dateEdited;


    public Member() {};

    public Member(String username, String email, String password, String firstName) {
        super(username, email, password);
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public boolean isApproved() {
        return approved;
    }

    public int getRanking() {
        return ranking;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateEdited() {
        return dateEdited;
    }
}