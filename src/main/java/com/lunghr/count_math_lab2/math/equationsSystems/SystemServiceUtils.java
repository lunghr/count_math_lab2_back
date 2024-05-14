package com.lunghr.count_math_lab2.math.equationsSystems;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemServiceUtils {

    public Double calculateDeltaXConst(Double x, Double y, int eq_num) {
        if (eq_num == 1) {
            return Math.cos(x + y) - 1.4;
        } else {
            return 2 * x;
        }
    }


    public Double calculateDeltaYConst(Double x, Double y, int eq_num) {
        if (eq_num == 1) {
            return Math.cos(x + y);
        } else {
            return 2 * y;
        }
    }


    public Double calculateFreeConst(Double x, Double y, int eq_num) {
        if (eq_num == 1) {
            return (-1) * (Math.sin(x + y) - 1.4 * x);
        } else {
            return (-1) * (Math.pow(x, 2) + Math.pow(y, 2) - 1);
        }
    }


    public Double calculateDeltaY(Double x, Double y) {
        return (calculateFreeConst(x, y, 2) - (calculateFreeConst(x, y, 1) * calculateDeltaXConst(x, y, 2) / calculateDeltaXConst(x, y, 1))) /
                ((-1) * calculateDeltaYConst(x, y, 1) / calculateDeltaXConst(x, y, 1) * calculateDeltaXConst(x, y, 2) +
                        calculateDeltaYConst(x, y, 2));
    }

    public Double calculateDeltaX(Double x, Double y) {
        return (calculateFreeConst(x, y, 1) - calculateDeltaYConst(x, y, 1) * calculateDeltaY(x, y)) /
                calculateDeltaXConst(x, y, 1);

    }

    public Double calculateX(Double x, Double y) {
        return x + calculateDeltaX(x, y);
    }

    public Double calculateY(Double x, Double y) {
        return y + calculateDeltaY(x, y);
    }

    public Double calculateEpsilon(Double x, Double y) {
//        System.out.println(" ");
//        System.out.println("DeltaXConst1: " + calculateDeltaXConst(x, y, 1));
//        System.out.println("DeltaXConst2: " + calculateDeltaXConst(x, y, 2));
//        System.out.println("DeltaYConst1: " + calculateDeltaYConst(x, y, 1));
//        System.out.println("DeltaYConst2: " + calculateDeltaYConst(x, y, 2));
//        System.out.println("DeltaFreeConst1: " + calculateFreeConst(x, y, 1));
//        System.out.println("DeltaFreeConst2: " + calculateFreeConst(x, y, 2));
//        System.out.println("DeltaX: " + calculateDeltaX(x, y));
//        System.out.println("DeltaY: " + calculateDeltaY(x, y));
//        System.out.println("X: " + calculateX(x, y));
//        System.out.println("Y: " + calculateY(x, y));
        return Math.max(Math.abs(calculateX(x, y) - x), Math.abs(calculateY(x, y) - y));
    }
}
