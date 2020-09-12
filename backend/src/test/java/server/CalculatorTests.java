package server;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import server.Calculator;

public class CalculatorTests {

	@Test
	public void factorialBaseCase() throws Exception {
    assertThat(Calculator.factorial(0)).isEqualTo(1);
    assertThat(Calculator.factorial(1)).isEqualTo(1);
	}

	@Test
	public void factorialAnyCase() throws Exception {
		assertThat(Calculator.factorial(2)).isEqualTo(2);
		assertThat(Calculator.factorial(5)).isEqualTo(120);
		assertThat(Calculator.factorial(8)).isEqualTo(40320);
	}
}