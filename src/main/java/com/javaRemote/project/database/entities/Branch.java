package com.javaRemote.project.database.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branchid")
    private int branchId;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name="rentalid")
    private Rental rental;

    @OneToMany(mappedBy = "branch")
    private List<Car> cars;

    @OneToMany(mappedBy = "branch")
    private List<Employee> employees;

    @OneToMany(mappedBy = "branch")
    private List<Reservation> reservations;

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", address='" + address + '\'' +
                '}';
    }
}
