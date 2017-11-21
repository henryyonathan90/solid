package solid.dependencyinversion.after;

/**
 * Created by henry.jonathan on 11/21/2017
 */
public class ElectricPowerSwitch {

  public Switchable client;
  public boolean on;

  public ElectricPowerSwitch(Switchable client) {
    this.client = client;
    this.on = false;
  }

  public boolean isOn() {
    return this.on;
  }

  public void press() {
    boolean checkOn = isOn();
    if (checkOn) {
      client.turnOff();
      this.on = false;
    } else {
      client.turnOn();
      this.on = true;
    }
  }
}
