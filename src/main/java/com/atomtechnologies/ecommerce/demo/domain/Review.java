package com.atomtechnologies.ecommerce.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(prefix = "")
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rating", nullable = false)
    private Long rating;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;}