package com.lunghr.count_math_lab2.math.nonlinearEquations;

import com.lunghr.count_math_lab2.math.ServiceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewtonMethod {

    ServiceUtils serviceUtils = new ServiceUtils();

    private Double calculateNewX(Double x) {
        return (x - (serviceUtils.calculateFunction(x) / serviceUtils.calculateDiffFunction(x)));
    }

    public List<Iteration> executeNewtonMethod(Double a, Double b, Double accuracy) {
        List<Iteration> response = new ArrayList<>();
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
            response.add(new Iteration(x, epsilon));
            if (epsilon < accuracy) {
                return response;
            }
            System.out.println("");
        }
        return null;
    }
}
