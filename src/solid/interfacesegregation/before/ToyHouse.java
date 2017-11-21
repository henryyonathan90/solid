package solid.interfacesegregation.before;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class ToyHouse implements Toy {
  double price;
  String color;

  public void setPrice(double price) {
    this.price = price;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void move() {
    throw new UnsupportedOperationException();
  }

  public void fly() {
    throw new UnsupportedOperationException();
  }
}
