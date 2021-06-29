package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "branch")
@NoArgsConstructor
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branchid")
    private Integer branchId;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "rentalid")
    private Rental rental;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<Car> cars;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<Reservation> reservations;

    public Branch(Branch branch) {
        this.branchId = branch.getBranchId();
        this.address = branch.getAddress();
        this.rental = branch.getRental();
    }

    public Branch setBranchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }

    public Branch setAddress(String address) {
        this.address = address;
        return this;
    }

    public Branch setRental(Rental rental) {
        this.rental = rental;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchId, branch.branchId) &&
                Objects.equals(address, branch.address) &&
                Objects.equals(rental, branch.rental);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, address, rental);
    }
}
