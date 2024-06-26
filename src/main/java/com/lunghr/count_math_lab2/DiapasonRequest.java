package com.lunghr.count_math_lab2;

import lombok.*;

@Data
@AllArgsConstructor
@Setter
@Getter
public class DiapasonRequest {
    private String root;
    private Integer equation;
    private String type;
    private Double a;
    private Double b;
    private Double accuracy;
}
