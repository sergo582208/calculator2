package calculator.calculatorspringdemo;

import calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController{
    public CalculatorController() {
        this(null);
    }
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String welcome(){
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null){
            return "Отсутствуют входные значения";
        }
        return calculatorService.plus(num1,num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null) {
            return "Отсутствуют входные значения";
        }
        return calculatorService.minus(num1,num2);
    } @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Отсутствуют входные значения";
        }
        return calculatorService.multiply(num1,num2);
    } @GetMapping("/divide")
        public String divide(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2) throws IllegalAccessException {
        if (num2 == 0) {
            throw new IllegalAccessException();
        }
        return calculatorService.divide(num1,num2);
        }
    }

