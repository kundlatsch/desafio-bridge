package server;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

	private final AtomicLong counter = new AtomicLong();

  private int calcFactorial(int number) {
    return 1;
  }

	@GetMapping("/factorial")
	public Factorial greeting(@RequestParam(value = "number") int number) {
		return new Factorial(counter.incrementAndGet(), number, calcFactorial(number));
	}
}