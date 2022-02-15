package com.infoshareacademy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProblemCategory {
    SEATS("Problems with seats"),
    BRAKES("Problems with brakes"),
    MAINTENANCE("General maintenance"),
    OTHER("Other problems"),
    DRIVE("Problems with drive"),
    ENGINE("Problems with engine");
    private final String categoryName;
}