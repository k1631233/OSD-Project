import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Bond{

  int term, frequency;
  double coupon, price;
  String name, purchasedDate;

  public Bond(String name, double price, double coupon, int frequency, int term){
    this.frequency = frequency;
    this.term = term;
    this.name = name;
    this.price = price;
    this.coupon = coupon; //fraction of the bond you get every payment
    //get current Date
    this.purchasedDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
  }

  public double getBondValue(Bond bond, double inflationRate){
    int years = 2;
    return ((bond.getValue)/(Math.pow((1+inflationRate, years)));
  }
  
  public int getFrequency(){ return frequency; }

  public double getCoupon(){ return coupon; }

  public int getTerm(){ return term; }

  public String getName(){ return name; }

  public String getPurchasedDate(){ return purchasedDate; }

  public double getPrice (){ return price; }
}
