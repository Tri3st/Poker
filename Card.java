
public class Card {
  private char num;
  private char suit;
  private int value;
  
  public Card(String x){
    this.suit = x.charAt(1);
    this.num = x.charAt(0);
    switch(num) {
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
        value = Integer.parseInt("" + num);
        break;
      case 'T':
        value = 10;
        break;
      case 'J':
        value = 11;
        break;
      case 'Q':
        value = 12;
        break;
      case 'K':
        value = 13;
        break;
      case 'A':
        value = 14;
        break;
    }
  }
  
  public char getNum(){
    return this.num;
  }
  
  public char getSuit(){
    return this.suit;
  }
  
  public int getValue(){
    return this.value;
  }
  
  public String toString(){
    String t="";
    t += num + "" + suit;
    return t;
  }
}