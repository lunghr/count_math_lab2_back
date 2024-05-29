package com.lunghr.count_math_lab2.math.equationsSystems;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemServiceUtils {

    public Double calculateDeltaXConst(Double x, Double y, int eq_num, Integer equation) {
        if (equation.equals(1)) {
            if (eq_num == 1) {
                return Math.cos(x + y) - 1.4;
            } else {
                return 2 * x;
            }
        } else if (equation.equals(2)) {
            if (eq_num == 1) {
                return Math.cos(x + 0.5);
            } else {
                return 1.0;
            }
        } else {
            if (eq_num == 1) {
                return Math.cos(x + y) - 1.5;
            } else {
                return 2 * x;
            }
        }
    }


    public Double calculateDeltaYConst(Double x, Double y, int eq_num, Integer equation) {
        if (equation.equals(1)) {
            if (eq_num == 1) {
                return Math.cos(x + y);
            } else {
                return 2 * y;
            }
        } else if (equation.equals(2)) {
            if (eq_num == 1) {
                return -1.0;
            } else {
                return Math.sin(y - 2) * (-1);
            }
        } else {
            if (eq_num == 1) {
                return Math.cos(x + y);
            } else {
                return 4 * y;
            }
        }
    }


    public Double calculateFreeConst(Double x, Double y, int eq_num, Integer equation) {
        if (equation.equals(1)) {
            if (eq_num == 1) {
                return (-1) * (Math.sin(x + y) - 1.4 * x);
            } else {
                return (-1) * (Math.pow(x, 2) + Math.pow(y, 2) - 1);
            }
        } else if (equation.equals(2)) {
            if (eq_num == 1) {
                return (-1) * (Math.sin(x + 0.5) - y - 1);
            } else {
                return (-1) * (Math.cos(y - 2) + x);
            }
        } else {
            if (eq_num == 1) {
                return (-1) * (Math.sin(x + y) - 1.5 * x + 0.1);
            } else {
                return (-1) * (Math.pow(x, 2) + 2 * Math.pow(y, 2) - 1);
            }
        }
    }


    public Double calculateDeltaY(Double x, Double y, Integer equation) {
        return (calculateFreeConst(x, y, 2, equation) - (calculateFreeConst(x, y, 1, equation) * calculateDeltaXConst(x, y, 2, equation) / calculateDeltaXConst(x, y, 1, equation))) /
                ((-1) * calculateDeltaYConst(x, y, 1, equation) / calculateDeltaXConst(x, y, 1, equation) * calculateDeltaXConst(x, y, 2, equation) +
                        calculateDeltaYConst(x, y, 2, equation));
    }

    public Double calculateDeltaX(Double x, Double y, Integer equation) {
        return (calculateFreeConst(x, y, 1, equation) - calculateDeltaYConst(x, y, 1, equation) * calculateDeltaY(x, y, equation)) /
                calculateDeltaXConst(x, y, 1, equation);

    }

    public Double calculateX(Double x, Double y, Integer equation) {
        return x + calculateDeltaX(x, y, equation);
    }

    public Double calculateY(Double x, Double y, Integer equation) {
        return y + calculateDeltaY(x, y, equation);
    }

    public Double calculateEpsilon(Double x, Double y, Integer equation) {
        return Math.max(Math.abs(calculateX(x, y, equation) - x), Math.abs(calculateY(x, y, equation) - y));
    }
}
