package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.Calculator;
import server.Factorial;
import server.History;
import server.Number;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

	private History db;

	public FactorialController() {
		this.db = new History();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/factorial")
	public Factorial postFactorial(@RequestBody Number number) {
		int n = number.getNumber();
		int f = Calculator.factorial(n);
		Factorial factorial = new Factorial(n, f);
		this.db.saveFactorial(factorial);
		return factorial;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/history/{numberOfFacs}")
	public ArrayList<Factorial> getHistory(@PathVariable int numberOfFacs) {
		try {
			ResultSet rs = this.db.getLastNFactorials(numberOfFacs);

			ArrayList<Factorial> list = new ArrayList();
			while (rs.next()) {
				int number = rs.getInt("number");
				int factorial = rs.getInt("factorial");
				
				Factorial f = new Factorial(number, factorial);
				list.add(f);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			ArrayList<Factorial> nll = new ArrayList();
			return nll;
		}
	}

}