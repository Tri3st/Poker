
public class Hand {
  private Card[] cards;
  //private int sameCards;
  //private int sameSuit;
  private boolean pair;
  private boolean twopair;
  private boolean toak;
  private boolean foak;
  private boolean fh;
  private boolean straight;
  private boolean flush;
  private boolean strflush;
  private boolean royflush;
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
      if (contains(3)&&contains(2)) fh = true;
      if (contains(3)) toak = true;
      if (containsTwice()) twopair = true;
      if (contains(2)) pair = true;
      if(sp==5 || cl==5 || di==5 || he==5) flush = true;
  } 

  private boolean isStraight(){
    if (contains(2) || contains(3) || contains(4)) return false;
    else {

    }
    
  }

  private boolean contains(int x){
    for (int c: amnt){
      if (c==x) return true;
    } 
    return false;
  }
  
  private boolean containsTwice(){
    boolean succes = false; 
    int index1 = -1;
    int index2 = -1;
    for (int x1=0; x1<amnt.length;x1++) {
      if (index1 == -1 && amnt[x1]>=2) index1 = x1;
      else if (amnt[x1]>=2 && index1 != -1) {
        index2 = x1;
        succes = true;
      }
    }
    return succes;
  }
  
  private void printHand(){
    System.out.println("4 of a kind : " + foak);
    System.out.println("3 of a kind : " + toak);
    System.out.println("full house : " + fh);
    System.out.println("pair : "+ pair);
    System.out.println("2 pair : "+ twopair);
    System.out.println("flush : " + flush);
    
  }
  
  public String toString(){
    String t ="";
    for (Card c: cards) {
      t+= c.getNum() + "" + c.getSuit() + " ";
    }
    printHand();
    return t;
  }
}