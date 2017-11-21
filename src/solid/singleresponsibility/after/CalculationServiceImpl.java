package solid.singleresponsibility.after;

import solid.singleresponsibility.PriceCodeEnum;
import solid.singleresponsibility.Rental;

import java.util.List;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class CalculationServiceImpl {
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
}
