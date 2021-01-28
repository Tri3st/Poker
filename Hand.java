public class Hand {
  private Card[] cards;
  private int sameCards;
  private int sameSuit;
  private int pair;
  private int twopair;
  private boolean toak;
  private boolean foak;
  private boolean fh;
  private boolean straight;
  private boolean flush;
  private int cl;
  private int sp;
  private int di;
  private int he;
  private int[] amnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
  
  public Hand (String x){
    cards = new Card[5];
    String[] h = x.split(" ");
    for(int i=0;i<5;i++){
      cards[i] = new Card(h[i]);
    }
    calculate();
  }
  
  private void calculate(){
    for (int i=0; i<5; i++){
      char s = cards[i].getSuit();
      switch(s){
        case 'C':
          cl++;
          break;
        case 'S':
          sp++;
          break;
        case 'D':
          di++;
          break;
        case 'H':
          he++;
          break;
        }
        int num = cards[i].getValue()-2;
        amnt[num]++;
      }
      if (contains(4)) foak = true;
      else if (contains(3)&&contains(2)) fh = true;
      else if (contains(3)) toak = true;
      else if (containsTwice(2)) twopair = true;
      else if (contains(2)) pair = true;
      printHand();
  } 

  
  private boolean contains(int x){
    for (int c: amnt){
      if (c==x) return true;
    } 
    return false;
  }
  
  private boolean containsTwice(int x){
    boolean 
    for (int x1=0; x1<amnt.length;x1++) {
      if (amnt[x1]==2)
    }
  }
  
  private void printHand(){
    if (foak) System.out.println("4 of a kind");
    if (toak) System.out.println("3 of a kind");
    if (fh) System.out.println("full house");
  }
  
  public String toString(){
    String t ="";
    for (Card c: cards) {
      t+= c.getNum() + "" + c.getSuit() + " ";
    }
    return t;
  }
}