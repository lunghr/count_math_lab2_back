package com.lunghr.count_math_lab2.math;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceUtils {

    private static Double A;
    private static Double B;
    private static Double C;
    private static Double D;


    public Double calculateFunction(Double x) {
        return A * Math.pow(x, 3) + B * Math.pow(x, 2) + C * x + D;
    }

    public Double calculateLambdaPhiFunction(Double x, Double lambda) {
        return lambda * A * Math.pow(x, 3) + lambda * B * Math.pow(x, 2) + lambda * C * x + x + lambda * D;
    }

    public Double calculateDiffFunction(Double x) {
        return A * 3 * Math.pow(x, 2) + B * 2 * x + C;
    }

    public Double calculateSecondDiffFunction(Double x) {
        return A * 6 * x + B * 2;
    }

    public Double getLambda(Double a, Double b) {
        if (calculateDiffFunction(a) > 0 && calculateDiffFunction(b) > 0) {
            return (-1 / Math.max(Math.abs(calculateDiffFunction(a)), Math.abs(calculateDiffFunction(b))));
        } else {
            return (1 / Math.max(Math.abs(calculateDiffFunction(a)), Math.abs(calculateDiffFunction(b))));
        }
    }


    public void setArgs(Integer equation) {
        if (equation.equals(1)) {
            A = 2.3;
            B = 5.75;
            C = -7.41;
            D = -10.6;
        }
        else if (equation.equals(2)){
            A = 2.74;
            B = -1.93;
            C = -15.28;
            D = -3.72;
        }

        else if (equation.equals(3)){
            A = 1.0;
            B = 2.84;
            C = -5.606;
            D = -14.766;
        }
    }
}
