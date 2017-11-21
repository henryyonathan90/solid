package solid.singleresponsibility.after;

import solid.singleresponsibility.Customer;
import solid.singleresponsibility.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class StatementServiceImpl {
  private CalculationServiceImpl calculationService = new CalculationServiceImpl();

  //createStatement
  public String createStatement(Customer customer) {
    List<Object> objs = new ArrayList<>();

    String format = "Rental Record for %s\n";
    objs.add(customer.getName());

    for (Rental rental : customer.getRentals()) {
      //show figures for this rental
      format += "\t%s\t%s\n";
      objs.add(rental.getMovie().getTitle());
      objs.add(String.valueOf(calculationService.calculateRentalAmount(rental)));

    }
    //add footer lines
    format += "Amount owed is %s\n";
    format += "You earned %s frequent renter points";
    objs.add(String.valueOf(calculationService.calculateTotalAmount(customer.getRentals())));
    objs.add(String.valueOf(calculationService.calculateRenterPoint(customer.getRentals())));

    return String.format(format, objs.toArray());
  }

  //createSimpleStatement
  public String createSimpleStatement(Customer customer) {
    String result = "Rental Record for " + customer.getName() + "\n";

    //add footer lines
    result += "Amount owed is " + String
        .valueOf(calculationService.calculateTotalAmount(customer.getRentals())) +
        "\n";
    result += "Point earned is " + String
        .valueOf(calculationService.calculateRenterPoint(customer.getRentals())) +
        " frequent renter points";
    return result;
  }
}
