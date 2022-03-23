package qa.homeWork;

public class Cerc {

  public double raza;
  public double pi=3.14;

  public Cerc(double raza) {
    this.raza = raza;
  }

  public double AriaCerc(){

    return 2*pi*this.raza*this.raza;
  }
}
