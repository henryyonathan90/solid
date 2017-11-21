package solid.dependencyinversion.before;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class ElectricPowerSwitch {

  public LightBulb lightBulb;
  public boolean on;

  public ElectricPowerSwitch(LightBulb lightBulb) {
    this.lightBulb = lightBulb;
    this.on = false;
  }

  public boolean isOn() {
    return this.on;
  }

  public void press() {
    boolean checkOn = isOn();
    if (checkOn) {
      lightBulb.turnOff();
      this.on = false;
    } else {
      lightBulb.turnOn();
      this.on = true;
    }
  }
}
