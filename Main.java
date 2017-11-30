import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * TO CHANGE FOR CLASS DIAGRAM:
 * add inflationRate parameter (Investor.java)
 * TO DO:
 * add try/catch for ints(?) (Main.java)
 * add calc methods for Investor.java (Investor.java)
 * add everything else for Bond.java (Bond.java)
 * implement getInflation (Main.java)
 * need to have string accept spaces when creating bond (Main.java, line 26)
 */
class Main {

  static Map < String, Bond > listOfBonds = new HashMap < String, Bond > ();

  static double inflation;

  public static void main(String[] args) {

    inflation = 0.05;

    Investor user = new Investor();

    while (true) {

      System.out.print("OSD_Project : ");

      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine();
      //SYSTEM COMMANDS
      if (input.matches("[>][a-zA-Z]+[\\/]\\d+(.\\d\\d)[\\/]\\d+(.\\d\\d)[\\/]\\d+")) { //does not accept spaces in string atm
        String[] parts = input.substring(1, input.length()).split("/");
        addBond(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), 1, Integer.parseInt(parts[3]));
      } else if (input.equals(">help")) {
        help();
      } else if (input.equals(">exit")) {
        System.out.println("Are you sure? [Y/n]");
        Scanner exit = new Scanner(System.in);
        String input2 = exit.nextLine();
        if (input2.equalsIgnoreCase("Y"))
          System.exit(0);
      } else if (input.equals(">browse")){
        for (Map.Entry<String, Bond> entry : listOfBonds.entrySet()) {
          String key = entry.getKey();
          Object value = entry.getValue();
          System.out.println(key);
        }
      }
      //INVESTOR COMMANDS
      else if (input.matches("[>](purchase)[\\/][a-zA-Z]+")){
        String[] parts = input.substring(1, input.length()).split("/");
        if(!isValid(parts[1])){ //test for valid key
          System.out.println("Bond not found");
        } else {
          System.out.println("Are you sure you want to purchase " +parts[1]+ "? [Y/n]");
          Scanner exit = new Scanner(System.in);
          String input2 = exit.nextLine();
          if (input2.equalsIgnoreCase("Y")){
            user.purchaseBonds(parts[1]);
            System.out.println("Bond purchased");
          }
        }
      } else if (input.matches("[>](value)[\\/][a-zA-Z]+[\\/]\\d+(.\\d\\d)")){
        String[] parts = input.substring(1, input.length()).split("/");
        if(!isValid(parts[1])){ //test for valid key
          System.out.println("Bond not found");
        } else {
        	System.out.println(user.getBondValue(parts[1], Double.parseDouble(parts[2])));
        }
      
      } else if (input.matches("[>](macaulay)[\\/][a-zA-Z]+[\\/]\\d+(.\\d\\d)")){
        String[] parts = input.substring(1, input.length()).split("/");
        if(!isValid(parts[1])){ //test for valid key
          System.out.println("Bond not found");
        } else {
        	System.out.println(user.calcMacaulay(parts[1], Double.parseDouble(parts[2])));
        }
        
      }
      else if (input.matches("[>](irr)[\\/][a-zA-Z]+")){
          String[] parts = input.substring(1, input.length()).split("/");
          if(!isValid(parts[1])){ //test for valid key
            System.out.println("Bond not found");
          } else {
            System.out.println(user.calcInternalRateOfReturn(parts[1]));
          }
          
        }
      else if (input.matches("[>](payouts)[\\/][a-zA-Z]+")){
          String[] parts = input.substring(1, input.length()).split("/");
          if(!user.isValid(parts[1])){ //test for valid key
            System.out.println("Bond not found");
          } else {
        	  System.out.println(user.calcPayouts(parts[1]));
          }
          
        }
      
      else {
        System.out.println("Command not found, please type >help for a list of available commands");
      }
    }
  }


  public static boolean isValid(String bond){ //check if key exists in purchased
    return (listOfBonds.get(bond) != null); //returns true if it does
  }

  public static void addBond(String name, double price, double coupon, int f, int t) {
    System.out.println("Confirm that you want to create a new bond ");
    System.out.println("Name: " + name + "\nPrice: " + price + "\nCoupon: " + coupon);
    System.out.println("Are you sure? [Y/n]");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine(); //add try/catch to detect for ints
    if (input.equalsIgnoreCase("Y")) {
      System.out.println("New bond added");
      listOfBonds.put(name, new Bond(name, price, coupon, f, t));
    } else { //cancels if any string other than Y or y is inputted
      System.out.println("Operation cancelled");
      return;
    }
  }

  public static Map <String, Bond> getBonds() {
    return listOfBonds;
  }

  public double getInflation(){
    return inflation;
  }

  public static void help() {
    System.out.println("+-----------------------------HELP-----------------------------+");
    System.out.println("|To add a bond, type '>[Bond name]/[Bond price]/[Bond coupon]/[Bond term]' |");
    System.out.println("|To exit the system, type '>exit'                              |");
    System.out.println("|To browse current available bonds, type '>browse'             |");
    System.out.println("|If you wish to buy a bond, type '>purchase/[Bond name]'       |");
    System.out.println("|If you wish to view purchased bonds, type '>purchased'        |");
    System.out.println("|type '>payouts/[Bond name]'                                   |");
    System.out.println("|type '>macaulay/[Bond name]'                                  |");
    System.out.println("|type '>irr/[Bond name]'                                       |");
    System.out.println("+--------------------------------------------------------------+");
  }
}
