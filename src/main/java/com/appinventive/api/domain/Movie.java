package com.appinventive.api.domain;

import com.appinventive.api.validation.RangeNumberConstraint;
import com.appinventive.api.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;

    @RangeNumberConstraint(message = "Rating should be between 0.5 and 4.5")
    private Double rating;
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private User user;
}
