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

  public double calcPayouts(String bond){
	  return (100+ (int)(purchased.get(bond).getPrice() * purchased.get(bond).getCoupon()/100 * purchased.get(bond).getTerm()));
  }

  public double calcMacaulay(String bond, double inflationRate){
	double mac = 0;
	  for(int i=1; i< purchased.get(bond).getTerm(); i++) {
		  mac += (i * (purchased.get(bond).getCoupon()/100)) / Math.pow(1+inflationRate, i);
//				  ((i*(purchased.get(bond).getPrice()*(purchased.get(bond).getCoupon()/100)))/Math.pow((1+inflationRate), i)) + ((purchased.get(bond).getTerm()*100)/Math.pow((1+inflationRate),purchased.get(bond).getTerm()));
	  }
	  mac += (purchased.get(bond).getTerm() * 100)/Math.pow(1+inflationRate, purchased.get(bond).getTerm());
//			  ((purchased.get(bond).getTerm()*(purchased.get(bond).getPrice()*(purchased.get(bond).getPrice() + purchased.get(bond).getCoupon()/100)))/Math.pow((1+inflationRate), purchased.get(bond).getTerm())) + ((purchased.get(bond).getTerm()*100)/Math.pow((1+inflationRate),purchased.get(bond).getTerm()));
	  return mac/(getBondValue(bond, inflationRate));
  
  }

  public double calcInternalRateOfReturn(String bond){
	  double irr = 0;
//	  for(int i = 1; i < purchased.get(bond).getTerm(); i++) {	
//		  irr += purchased.get(bond).getCoupon() / Math.pow(1+inflationRate, i);
//		  
//		}
//	  irr += 100/Math.pow(1+inflationRate, purchased.get(bond).getTerm()); 
	 return irr;
  }

  public double getBondValue(String bond, double inflationRate){
    return purchased.get(bond).getPrice()/Math.pow(1+inflationRate, purchased.get(bond).getTerm());
  }
}


























