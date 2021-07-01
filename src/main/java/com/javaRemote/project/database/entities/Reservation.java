package com.javaRemote.project.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "reservation")
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationid")
    private Integer reservationId;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "branchid")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    public Reservation(Reservation reservation) {
        this.reservationId = reservation.getReservationId();
        this.startDate = Date.valueOf(reservation.getStartDate());
        this.endDate = Date.valueOf(reservation.getEndDate());
        this.price = reservation.getPrice();
        this.branch = reservation.getBranch();
        this.customer = reservation.getCustomer();
        this.car = reservation.getCar();
    }

    public Reservation setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    public Reservation setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Reservation setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Reservation setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Reservation setBranch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public Reservation setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Reservation setCar(Car car) {
        this.car = car;
        return this;
    }

    public String getStartDate() {
        if (startDate != null) {
            return String.valueOf(startDate);
        }
        return null;
    }

    public String getEndDate() {
        if (endDate != null) {
            return String.valueOf(endDate);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationId, that.reservationId) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(price, that.price) &&
                Objects.equals(branch, that.branch) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, startDate, endDate, price, branch, customer, car);
    }
}
