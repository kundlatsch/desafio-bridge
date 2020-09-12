package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.Factorial;
import server.History;
import server.Number;

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

  private int calcFactorial(int number) {
    return 12;
  }

	@PostMapping("/factorial")
	public int postFactorial(@RequestBody Number number) {
		int n = number.getNumber();
		int factorial = calcFactorial(n);
		Factorial fac = new Factorial(n, factorial);
		this.db.saveFactorial(fac);
		return factorial;
	}

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