package com.jpmc.theater.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    private String title;
    private String description;
    private Integer durationInMins;
    private Double ticketPrice;
    private Integer specialCode;

}
