package com.lunghr.count_math_lab2.math.equationsSystems;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewtonForSystems {

    SystemServiceUtils serviceUtils = new SystemServiceUtils();

    public List<SystemIteration> executeNewtonMethodForSystems(Double x, Double y, Double accuracy, Integer equation) {
        Double epsilon = 1.0;
        List<SystemIteration> response = new ArrayList<>();
        int counter = 0;
        if (x * y < 0 && equation.equals(3)){
            x = Math.abs(x);
            y= Math.abs(y);
        }
        Double NewX;
        Double NewY;
        while (epsilon > accuracy) {
            counter++;
            epsilon = serviceUtils.calculateEpsilon(x, y, equation);
            NewX = serviceUtils.calculateX(x, y, equation);
            NewY = serviceUtils.calculateY(x, y, equation);
            x = NewX;
            y = NewY;
            System.out.println(counter + ": " + x + " " + y + " " + epsilon);

            response.add(new SystemIteration(x, y, epsilon));
            if (epsilon < accuracy) {
                return response;
            }
            System.out.println("");
        }
        return null;
    }
}
