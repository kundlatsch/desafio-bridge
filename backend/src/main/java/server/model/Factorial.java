package server;

public class Factorial {

  private final int number;
  private final int numberFactorial;

	public Factorial(int number, int numberFactorial) {
    this.number = number;
    this.numberFactorial = numberFactorial;
	}

	public int getNumber() {
		return number;
  }

  public int getNumberFactorial() {
    return numberFactorial;
  }
  

}