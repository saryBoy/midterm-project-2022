package com.example.midterm.project;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @SequenceGenerator(
            name = "car",
            sequenceName = "car_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private String price;

    @Column(name = "year_of_issue")
    private String yearOfIssue;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", yearOfIssue='" + yearOfIssue + '\'' +
                '}';
    }
}
