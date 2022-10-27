package com.jpmc.theater.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Showing {
	
	private Movie movie;
    private Integer sequenceOfTheDay;
    private LocalDateTime showStartTime;


    public boolean isSequence(Integer sequence) {
        return this.sequenceOfTheDay == sequence;
    }

}
