package server;

public class Factorial {

	private final long id;
  private final int number;
  private final int numberFactorial;

	public Factorial(long id, int number, int numberFactorial) {
		this.id = id;
    this.number = number;
    this.numberFactorial = numberFactorial;
	}

	public long getId() {
		return id;
	}

	public int getNumber() {
		return number;
  }

  public int getNumberFactorial() {
    return numberFactorial;
  }
  

}