import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

//      Protocol protocol = new Protocol(new BigInteger("6"),new BigInteger("51"));
//      protocol.calculateZ();
//      System.out.println(protocol.toString());
//      System.out.println(protocol.calculateZ());
        Main.simulateAttack();
    }

  public static void simulateAttack() {
    Protocol attack = new Protocol();

    System.out.println("Enter modulus: ");
    Scanner scanner = new Scanner(System.in);
    BigInteger n = new BigInteger(scanner.next(), 16);
    attack.setModulus(n);

    int numberOfAttacks = attack.makeAttack(0);
    System.out.println("Number of attacks: " + numberOfAttacks);
  }
}
