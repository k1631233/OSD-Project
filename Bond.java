import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Bond{

  int term, frequency;
  double coupon, price;
  String name;
  String purchasedDate;

  public Bond(String name, double price, double coupon, int frequency, int term){
    this.frequency = frequency;
    this.term = term;
    this.name = name;
    this.price = price;
    this.coupon = coupon; //fraction of the bond you get every payment
    //get current Date
    this.purchasedDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
  }

}
