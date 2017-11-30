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
	return purchased.get(bond).getPrice()*(1+(purchased.get(bond).getCoupon()/100*purchased.get(bond).getTerm()));
  }

  
  
  
  public double calcMacaulay(String bond, double inflationRate){
	double mac = 0;
	  for(int i=1; i< purchased.get(bond).getTerm() -1; i++) {
		  mac += ((i*(purchased.get(bond).getPrice()*(purchased.get(bond).getCoupon())))/Math.pow((1+inflationRate), i)) + ((purchased.get(bond).getTerm()*100)/Math.pow((1+inflationRate),purchased.get(bond).getTerm()));
	  }
	  mac += ((purchased.get(bond).getTerm()*(purchased.get(bond).getPrice()*(purchased.get(bond).getPrice() + purchased.get(bond).getCoupon())))/Math.pow((1+inflationRate), purchased.get(bond).getTerm())) + ((purchased.get(bond).getTerm()*100)/Math.pow((1+inflationRate),purchased.get(bond).getTerm()));
	  System.out.println(mac);
	  System.out.println(purchased.get(bond).getCoupon());
	  System.out.println(purchased.get(bond).getPrice());
	  return mac/(purchased.get(bond).getPrice()*100);
  
  }

  public double calcInternalRateOfReturn(String bond, double inflationRate){
	  double irr = 0;
	  for(int i = 0; i < purchased.get(bond).getTerm() -1 ; i++) {	
		  irr += ((purchased.get(bond).getPrice() * purchased.get(bond).getCoupon()/100) * ((purchased.get(bond).getCoupon()/100)/(1+inflationRate))) + (100/Math.pow((1+inflationRate), i));
	  }
	  irr += ((purchased.get(bond).getPrice() * purchased.get(bond).getCoupon()/100 + purchased.get(bond).getPrice()) * ((purchased.get(bond).getCoupon()/100)/(1+inflationRate))) + (100/Math.pow((1+inflationRate), purchased.get(bond).getTerm()));
	  return irr;
  }

  public double getBondValue(String bond, double inflationRate, double years){
    return purchased.get(bond).getPrice()/Math.pow(1+inflationRate, years);
  }
}


























