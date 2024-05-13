package com.lunghr.count_math_lab2.math.nonlinearEquations;

import com.lunghr.count_math_lab2.math.ServiceUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimpleIterationMethod {
    private ServiceUtils serviceUtils = new ServiceUtils();

    public String executeSimpleIterationMethod (Double a, Double b, Double accuracy){
        Double x = b;
        var lambda = serviceUtils.getLambda(a, b);

        System.out.println(lambda);
        double epsilon = 1.0;
        while (epsilon > accuracy){
            System.out.println(1);
            epsilon = Math.abs(serviceUtils.calculatePhiFunction(x, lambda) - x);
            x = serviceUtils.calculatePhiFunction(x, lambda);

            if (epsilon < accuracy) {
                return String.valueOf(x);
            }

        }
        return "oops";
    }


}
