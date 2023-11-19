package com.vin.learn.entities.mysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name = "usr_id")
    private String id;//UUID id;
    @Column(name = "usr_name", updatable = false, nullable = false)
    private String name;
    @Column(name = "usr_email", updatable = false, nullable = false)
    private String email;
}
