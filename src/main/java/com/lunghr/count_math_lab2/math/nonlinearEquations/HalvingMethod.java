package com.lunghr.count_math_lab2.math.nonlinearEquations;

import com.lunghr.count_math_lab2.math.ServiceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HalvingMethod {
    ServiceUtils serviceUtils = new ServiceUtils();

    private Double calculateNewX(Double a, Double b) {
        return (a + b) / 2;
    }

    public List<Iteration> executeHalvingMethod(Double a, Double b, Double accuracy) {
        List<Iteration> response = new ArrayList<>();
        double epsilon = 1.0;
        Double x;
        int counter = 0;

        while (epsilon > accuracy) {
            x = calculateNewX(a, b);
//            System.out.println("x_" + counter + ": " + x);
            epsilon = Math.abs(a - b);

            if (serviceUtils.calculateFunction(a) * serviceUtils.calculateFunction(x) > 0) {
                a = x;
            } else {
                b = x;
            }

//            System.out.println("a_" + counter + " and b_" + counter + ": " + a + ", " + b);

            response.add(new Iteration(x, epsilon));
            if (epsilon < accuracy) {
                return response;
            }
            System.out.println("");
        }
        return null;
    }
}
