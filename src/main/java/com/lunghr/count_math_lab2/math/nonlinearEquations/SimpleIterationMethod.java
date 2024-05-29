package com.lunghr.count_math_lab2.math.nonlinearEquations;

import com.lunghr.count_math_lab2.math.ServiceUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SimpleIterationMethod {
    private ServiceUtils serviceUtils = new ServiceUtils();

    public List<Iteration> executeSimpleIterationMethod(Double a, Double b, Double accuracy, Integer equation) {
        serviceUtils.setArgs(equation);
        List<Iteration> response = new ArrayList<>();
        double epsilon = 1.0;
        Double x;


        if (Math.abs(serviceUtils.calculateDiffFunction(a)) > Math.abs(serviceUtils.calculateDiffFunction(b))) {
            x = a;
        } else {
            x = b;
        }
        var lambda = serviceUtils.getLambda(a, b);
        System.out.println(lambda);
        while (epsilon > accuracy) {
            System.out.println(" ");
            epsilon = Math.abs(serviceUtils.calculateLambdaPhiFunction(x, lambda) - x);
            x = serviceUtils.calculateLambdaPhiFunction(x, lambda);
            System.out.println(x + " " + lambda);
            response.add(new Iteration(x, epsilon));
            if (epsilon < accuracy) {
                return response;
            }
            System.out.println("");
        }
        return null;
    }


}
