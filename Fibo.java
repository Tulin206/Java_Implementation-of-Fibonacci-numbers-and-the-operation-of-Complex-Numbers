// For variant 2 the following line could be used
// import static Prog1Tools.IOTools.readInteger;

public class Fibo {

    // iterative computation of fibonacci sequence
    public static long iterative(int n){
      long f1 = 0;
      long f2 = 1;
      long f3 = 0;
      if (n <= 0) {
        return 0;
      } else if (n == 1){
        return 1;
      } else{
        for(int i = 2; i <= n; i++){
          f3 = f2 + f1;
          f1 = f2;
          f2 = f3;
        }
      }
       
      return f3;
    }
      
  
    // Recursive computation of fibonacci sequence
    public static long recursive(int n) {
      if (n <= 0) {
        return 0;
      } else if (n == 1) {
        return 1;
      } else {
        return recursive(n - 2) + recursive(n - 1);
      }
    }
  
    public static void main(String[] args) {
      // variant 1: read the numbers from command-line arguments
      for (int i = 0; i < args.length; ++i) {
        int n = Integer.parseInt(args[i]);
        System.out.println("Iterative value for "+ n +" position is " + iterative(n));
        System.out.println("Recursive value for "+ n +" position is " + recursive(n));
      }
  
      // variant 2: read the integers from keyboard input using IOTools:
      // int n = IOTools.readInteger("Input n to evaluate factorial n! : ");
      // System.out.println("The factorial of "+n+" is " + recursive(n));
  
      // variant 3: read the integers from keyboard input using Console:
      /*
      java.io.Console console = System.console();
      int n = Integer.parseInt(console.readLine("Input n to evaluate factorial n! : "));
      System.out.println("The factorial of "+n+" is " + recursive(n));
      */
    }
  }  
