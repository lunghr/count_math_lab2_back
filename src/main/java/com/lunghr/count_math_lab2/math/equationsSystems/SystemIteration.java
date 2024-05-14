package com.lunghr.count_math_lab2.math.equationsSystems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class SystemIteration {
    Double x;
    Double y;
    Double accuracy;
}