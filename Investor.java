import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

class Investor {
  Map<String, Bond> purchased;
  public Investor(){
    purchased = new HashMap<String, Bond>();
  }

  public void purchaseBonds(String bond){
    purchased.put(bond, (Main.getBonds().get(bond)));
  }

  public String getPurchasedBonds(){
    String ret = "";
    for (Map.Entry<String, Bond> entry : purchased.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      ret += key + "\n";
    }
    return ret;
  }
  public boolean isValid(String bond){ //check if key exists in purchased
    return (purchased.get(bond) != null); //returns true if it does
  }

  public double calcPayouts(Bond bond){

  }

  public int calcMacaulay(Bond bond){

  }

  public double calcInternalRateOfReturn(Bond bond){

  }

  public double getBondValue(Bond bond, double inflationRate){
    int years = 2;
    return ((bond.getValue)/(Math.pow((1+inflationRate, years)));
  }
}
