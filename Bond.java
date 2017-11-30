import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

  public int getFrequency(){ return frequency; }

  public double getCoupon(){ return coupon; }

  public int getTerm(){ return term; }

  public String getName(){ return name; }

  public String getPurchasedDate(){ return purchasedDate; }

  public double getPrice (){ return price; }
}
