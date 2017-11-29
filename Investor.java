import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Investor {
  Map<String, Bond> purchased;
  public Investor(){
    purchased = new HashMap<String, Bond>();
  }

  public void purchaseBonds(String bond){
    purchased.put(bond, (Main.getBonds().get(bond)));
  }

  public void browseBonds(ArrayList<Bond>bondList){

  }

  public String getPurchasedBonds(){
    String ret = "d";
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
  // public double calcPayouts(Bond bond){
  //
  // }
  //
  // public int calcMacaulay(Bond bond){
  //
  // }
  //
  // public double calcInternalRateOfReturn(Bond bond){
  //
  // }
  //
  // public double getBondValue(Bond bond, double inflationRate){
  //
  // }
}
