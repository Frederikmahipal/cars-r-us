package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser{

    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int zip;
    private boolean approved;
    private int ranking;



    @Column(name="Created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "LastEdited")
    @UpdateTimestamp
    private LocalDateTime lastEdited;

    public Member(String username, String email, String password, String firstName) {
        super(username, email, password);
        this.firstName = firstName;
    }

    public Member(){
    }

}
