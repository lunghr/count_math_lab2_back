package com.lunghr.count_math_lab2.math.equationsSystems;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewtonForSystems {

    SystemServiceUtils serviceUtils = new SystemServiceUtils();

    public String executeNewtonMethodForSystems (Double x, Double y, Double accuracy){
        Double epsilon = 1.0;
        int counter = 0;
        Double NewX;
        Double NewY;
        while (counter < 4){
            counter++;
            epsilon = serviceUtils.calculateEpsilon(x, y);
            NewX = serviceUtils.calculateX(x, y);
            NewY = serviceUtils.calculateY(x, y);
            x = NewX;
            y = NewY;
            System.out.println(counter + ": " + x + " " +  y + " " + epsilon);

            if (epsilon <= accuracy){
                return String.valueOf(x) + " " + String.valueOf(y);
            }
        }
        return "oops";
    }
}
