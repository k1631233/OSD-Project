import java.util.Calendar;
import java.util.Date;
class Bond{

  int term, frequency;
  double coupon, price;
  String name;
  Date purchaseDate;

  public Bond(String name, double price, double coupon, int frequency, int term){
    this.frequency = frequency;
    this.term = term;
    this.name = name;
    this.price = price;
    this.coupon = coupon; //fraction of the bond you get every payment
	//get purchase date
  }

}
