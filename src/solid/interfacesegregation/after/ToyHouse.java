package solid.interfacesegregation.after;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class ToyHouse implements Priceable, Colorable {
  double price;
  String color;

  public void setPrice(double price) {
    this.price = price;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
