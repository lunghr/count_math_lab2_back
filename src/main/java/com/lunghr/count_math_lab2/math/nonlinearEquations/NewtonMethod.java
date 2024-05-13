package com.lunghr.count_math_lab2.math.nonlinearEquations;

import com.lunghr.count_math_lab2.math.ServiceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewtonMethod {

    ServiceUtils serviceUtils = new ServiceUtils();

    private Double calculateNewX(Double x) {
        return (x - (serviceUtils.calculateFunction(x) / serviceUtils.calculateDiffFunction(x)));
    }

    public String executeNewtonMethod(Double a, Double b, Double accuracy) {
        Double x;
        Double epsilon = 1.0;
        if (serviceUtils.calculateFunction(a) * serviceUtils.calculateSecondDiffFunction(a) > 0) {
            x = a;
        } else {
            x = b;
        }
        System.out.println("x_0: " + x);

        while (epsilon > accuracy) {
            epsilon = Math.abs(calculateNewX(x) - x);
            System.out.println("Epsilon: " + epsilon);
            x = calculateNewX(x);
            System.out.println("X: "+ x);
            if (epsilon < accuracy) {
                return String.valueOf(x);
            }
            System.out.println("");
        }
        return "oops";
    }
}
