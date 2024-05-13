package com.lunghr.count_math_lab2.math;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceUtils {
    public Double calculateFunction(Double x) {
        return 2.3 * Math.pow(x, 3) + 5.75 * Math.pow(x, 2) - 7.41 * x - 10.6;
    }

    public Double calculatePhiFunction(Double x, Double lambda) {
        return lambda * 2.3 * Math.pow(x, 3) + lambda * 5.75 * Math.pow(x, 2) - lambda * 7.41 * x + x - lambda * 10.6;
    }

    public Double calculateDiffFunction(Double x) {
        return 6.9 * Math.pow(x, 2) + 11.5 * x - 7.41;
    }

    public Double calculateSecondDiffFunction(Double x) {
        return 13.8 * x + 11.5;
    }

    public Double getLambda(Double a, Double b) {
        if (calculateDiffFunction(a) * calculateDiffFunction(b) > 0) {
            System.out.println(Math.abs(calculateDiffFunction(a)) + "; " +  Math.abs(calculateDiffFunction(b)));
            return (-1 / Math.max(Math.abs(calculateDiffFunction(a)), Math.abs(calculateDiffFunction(b))));
        } else {
            return (1 / Math.max(Math.abs(calculateDiffFunction(a)), Math.abs(calculateDiffFunction(b))));
        }
    }
}
