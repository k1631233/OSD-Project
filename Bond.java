class Bond{
    int term, frequency;
    double coupon, price;
    String name;
    Date purchaseDate;
    public Bond(String name, double price, double coupon){
	this.frequency = 1;
	this.term = 100;
	this.name = name;
	this.price = price;
	this.coupon = coupon; //fraction of the bond you get every payment
	//get purchase date	
    }


}
