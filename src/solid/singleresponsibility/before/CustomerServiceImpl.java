package solid.singleresponsibility.before;

import solid.singleresponsibility.Customer;
import solid.singleresponsibility.PriceCodeEnum;
import solid.singleresponsibility.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class CustomerServiceImpl {

  //calculateRentalAmount
  public double calculateRentalAmount(Rental rental) {
    double amount = 0;

    switch (rental.getMovie().getPriceCode()) {
      case REGULAR:
        amount += 2;
        if (rental.getDaysRented() > 2)
          amount += (rental.getDaysRented() - 2) * 1.5;
        break;
      case NEW_RELEASE:
        amount += rental.getDaysRented() * 3;
        break;
      case CHILDRENS:
        amount += 1.5;
        if (rental.getDaysRented() > 3)
          amount += (rental.getDaysRented() - 3) * 1.5;
        break;
    }
    return amount;
  }

  //calculateTotalAmount
  public double calculateTotalAmount(List<Rental> rentals) {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      totalAmount += calculateRentalAmount(rental);
    }
    return totalAmount;
  }

  //calculateRenterPoint
  public int calculateRenterPoint(List<Rental> rentals) {
    int point = 0;
    for (Rental rental : rentals) {
      point++;

      //bonus point
      if ((rental.getMovie().getPriceCode() == PriceCodeEnum.NEW_RELEASE)
          && rental.getDaysRented() > 1)
        point++;
    }

    return point;
  }

  //createStatement
  public String createStatement(Customer customer) {
    List<Object> objs = new ArrayList<>();

    String format = "Rental Record for %s\n";
    objs.add(customer.getName());

    for (Rental rental : customer.getRentals()) {
      //show figures for this rental
      format += "\t%s\t%s\n";
      objs.add(rental.getMovie().getTitle());
      objs.add(String.valueOf(calculateRentalAmount(rental)));

    }
    //add footer lines
    format += "Amount owed is %s\n";
    format += "You earned %s frequent renter points";
    objs.add(String.valueOf(calculateTotalAmount(customer.getRentals())));
    objs.add(String.valueOf(calculateRenterPoint(customer.getRentals())));

    return String.format(format, objs.toArray());
  }

  //createSimpleStatement
  public String createSimpleStatement(Customer customer) {
    String result = "Rental Record for " + customer.getName() + "\n";

    //add footer lines
    result += "Amount owed is " + String.valueOf(calculateTotalAmount(customer.getRentals())) +
        "\n";
    result += "Point earned is " + String.valueOf(calculateRenterPoint(customer.getRentals())) +
        " frequent renter points";
    return result;
  }
}
