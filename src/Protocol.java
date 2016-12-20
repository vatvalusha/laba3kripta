import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Created by user on 07.12.2016.
 */
public class Protocol {
  BigInteger x;
  BigInteger y;
  BigInteger n;
  BigInteger z;
  BigInteger t;



  public BigInteger calculateZ(){
    z = y.divide(y).mod(n);
    return z;
  }
  public BigInteger calculateT(){
    t = generateRandomNumber(32);
//    t = new BigInteger("6");
    return t;
  }

  public BigInteger generateY(BigInteger n){
    System.out.println("Y = "+calculateT().modPow(new BigInteger("2"), n));
    return y = calculateT().modPow(new BigInteger("2"), n);



  }

  public boolean tryToMakeMod(BigInteger root){
    if(t.compareTo(root) != 0){
      BigInteger p = n.gcd(t.add(root));
      BigInteger q = n.divide(p);
      System.out.println("p: " + p.toString(16));
      System.out.println("q: " + q.toString(16));
      return true;
    }else return false;
  }
  public boolean tryToMakeExpansionOfModulus(BigInteger root) {
    if ((t.compareTo(root) != 0) && (t.compareTo(root) != 0)) {
      BigInteger p = n.gcd(t.add(root));
      BigInteger q = n.divide(p);
      if ((p.compareTo(BigInteger.ONE) != 0) && (q.compareTo(BigInteger.ONE) != 0)) {
        System.out.println("p: " + p.toString(16));
        System.out.println("q: " + q.toString(16));
      }

      return true;
    } else {
      return false;
    }
  }

  public void setModulus(BigInteger n) {
    this.n = n;
  }

  public int makeAttack(int attackCounter) {
    generateY(n);

    System.out.println("Enter root: ");
    Scanner scanner = new Scanner(System.in);
    BigInteger root = new BigInteger(scanner.next(), 16);

//    boolean isAttackSuccessful = tryToMakeExpansionOfModulus(root);
    boolean isAttackSuccessful = tryToMakeMod(root);
    attackCounter++;
    if (!isAttackSuccessful) {
      makeAttack(attackCounter++);
    }

    return attackCounter;
  }

  public static BigInteger generateRandomNumber(int length) {
    SecureRandom secureRandom = new SecureRandom();
    byte[] randoms = new byte[length];
    secureRandom.nextBytes(randoms);
    return new BigInteger(randoms).abs();
  }
//  public BigInteger calculateT(){
//
//  }

  @Override
  public String toString() {
    return "Protocol{" +
      "x=" + x +
      ", y=" + y +
      ", n=" + n +
      ", z=" + z +
      ", t=" + t +
      '}';
  }

  public BigInteger getT() {
    return t;
  }

  public boolean checkZ(){
    return z.compareTo(x.modPow(new BigInteger("2"),n)) == 0;
  }

  public BigInteger getX() {
    return x;
  }

  public BigInteger getY() {
    return y;
  }

  public BigInteger getN() {
    return n;
  }

  public BigInteger getZ() {
    return z;
  }
}
