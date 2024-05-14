package com.lunghr.count_math_lab2;

import com.lunghr.count_math_lab2.math.equationsSystems.NewtonForSystems;
import com.lunghr.count_math_lab2.math.nonlinearEquations.HalvingMethod;
import com.lunghr.count_math_lab2.math.nonlinearEquations.NewtonMethod;
import com.lunghr.count_math_lab2.math.nonlinearEquations.SimpleIterationMethod;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/methods")
@AllArgsConstructor
public class MethodsController {
    private final HalvingMethod halvingMethod;
    private final NewtonMethod newtonMethod;
    private final SimpleIterationMethod simpleIterationMethod;
    private final NewtonForSystems newtonForSystems;


    @GetMapping("/res")
    public ResponseEntity<String> calculateMethod(@RequestHeader("Calculation-method") String method, @RequestBody DiapasonRequest diapason) {
        Double a = diapason.getA();
        Double b = diapason.getB();
        Double accuracy = diapason.getAccuracy();

        if ("Newton".equals(method)){
            return ResponseEntity.ok(newtonMethod.executeNewtonMethod(a, b, accuracy));
        }
        if("Halving".equals(method)) {
            return ResponseEntity.ok(halvingMethod.executeHalvingMethod(a, b, accuracy));
        }
        if ("SimpleIteration".equals(method)){
            return ResponseEntity.ok(simpleIterationMethod.executeSimpleIterationMethod(a, b, accuracy));
        }
        if ("NewtonForSystems".equals(method)){
            return ResponseEntity.ok(newtonForSystems.executeNewtonMethodForSystems(a, b, accuracy));
        }
        else {
            return ResponseEntity.ok("Unknown method");
        }
    }
}
