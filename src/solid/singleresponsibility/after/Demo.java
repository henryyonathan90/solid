package solid.singleresponsibility.after;

import solid.singleresponsibility.Customer;
import solid.singleresponsibility.Movie;
import solid.singleresponsibility.PriceCodeEnum;
import solid.singleresponsibility.Rental;

import java.util.Arrays;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class Demo {
  public static void main(String[] args) {
    Movie newMovie = new Movie("MyMovie", PriceCodeEnum.NEW_RELEASE);
    Rental rental = new Rental(newMovie, 2);
    Customer customer = new Customer("Henry", Arrays.asList(rental));

    StatementServiceImpl impl = new StatementServiceImpl();
    System.out.println(impl.createStatement(customer));
  }
}
