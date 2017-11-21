package solid.dependencyinversion.after;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class LightBulb implements Switchable {

  public void turnOn() {
    System.out.println("LightBulb: Bulb turned on...");
  }

  public void turnOff() {
    System.out.println("LightBulb: Bulb turned off...");
  }

}
