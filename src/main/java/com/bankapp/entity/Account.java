package com.bankapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "account", schema = "public")
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "open_date")
    private Instant openDate;

    @Column(name = "close_date")
    private Instant closeDate;

    @Column(name = "is_active")
    private boolean active;

    @OneToMany(mappedBy = "account",
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Card> cards;
}
