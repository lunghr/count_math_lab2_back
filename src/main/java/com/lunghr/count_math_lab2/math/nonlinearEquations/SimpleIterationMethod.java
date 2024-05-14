package com.lunghr.count_math_lab2.math.nonlinearEquations;

import com.lunghr.count_math_lab2.math.ServiceUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimpleIterationMethod {
    private ServiceUtils serviceUtils = new ServiceUtils();

    public String executeSimpleIterationMethod(Double a, Double b, Double accuracy) {

        double epsilon = 1.0;
        Double x;

        if (Math.abs(serviceUtils.calculateDiffFunction(a)) > Math.abs(serviceUtils.calculateDiffFunction(b))) {
            x = a;
        } else {
            x = b;
        }
        var lambda = serviceUtils.getLambda(a, b);
        while (epsilon > accuracy) {
            System.out.println(" ");
            epsilon = Math.abs(serviceUtils.calculateLambdaPhiFunction(x, lambda) - x);
            x = serviceUtils.calculateLambdaPhiFunction(x, lambda);
            if (epsilon < accuracy) {
                return String.valueOf(x);
            }
        }
        return "oops";
    }


}
