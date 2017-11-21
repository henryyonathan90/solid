package solid.singleresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name, List<Rental> rentals) {
    this.name = name;
    this.rentals = rentals;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Rental> getRentals() {
    return rentals;
  }

  public void setRentals(List<Rental> rentals) {
    this.rentals = rentals;
  }
}
