package com.bankapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_system", schema = "public")
public class PaymentSystem {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "system", nullable = false)
    private String system;

    @OneToMany(mappedBy = "paymentSystem",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST})
    private List<Product> products;
}
