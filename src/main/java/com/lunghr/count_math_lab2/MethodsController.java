package com.lunghr.count_math_lab2;

import com.lunghr.count_math_lab2.math.equationsSystems.NewtonForSystems;
import com.lunghr.count_math_lab2.math.nonlinearEquations.HalvingMethod;
import com.lunghr.count_math_lab2.math.nonlinearEquations.NewtonMethod;
import com.lunghr.count_math_lab2.math.nonlinearEquations.SimpleIterationMethod;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/methods")
@AllArgsConstructor
public class MethodsController {
    private final HalvingMethod halvingMethod;
    private final NewtonMethod newtonMethod;
    private final SimpleIterationMethod simpleIterationMethod;
    private final NewtonForSystems newtonForSystems;


    //    @GetMapping("/res")
    @PostMapping("/res")
    public ResponseEntity<List<?>> calculateMethod(@RequestHeader("CalculationMethod") String method, @RequestBody DiapasonRequest diapason) {
        Double a = diapason.getA();
        Double b = diapason.getB();
        Double accuracy = diapason.getAccuracy();
        Integer equation = diapason.getEquation();
        String root = diapason.getRoot();
        if (diapason.getType().equals("nonlinear")) {
            if (root.equals("Left")) {
                a = -4.0;
                b = -3.0;
            } else if (root.equals("Central")) {
                a = -1.0;
                b = 0.0;
            } else if (root.equals("Right")) {
                a = 1.0;
                b = 2.0;
            }
            System.out.println(a + " " + b);

            if ("Newton".equals(method)) {
                System.out.println("2");
                return ResponseEntity.ok(newtonMethod.executeNewtonMethod(a, b, accuracy, equation));

            }
            if ("Halving".equals(method)) {
                System.out.println("2");
                return ResponseEntity.ok(halvingMethod.executeHalvingMethod(a, b, accuracy, equation));
            }
            if ("SimpleIteration".equals(method)) {
                System.out.println("2");
                return ResponseEntity.ok(simpleIterationMethod.executeSimpleIterationMethod(a, b, accuracy, equation));
            }

        }
        if ("NewtonForSystems".equals(method)) {
            System.out.println("2");
            return ResponseEntity.ok(newtonForSystems.executeNewtonMethodForSystems(a, b, accuracy, equation));
        } else {
            return ResponseEntity.ok(null);
        }
    }
}

