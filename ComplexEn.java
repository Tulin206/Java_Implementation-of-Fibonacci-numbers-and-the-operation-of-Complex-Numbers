// The following line allows to omit the prefix `Math` when addressing class methods and
// constants defined in the class Math of the java.lang package (implicitly imported)
import static java.lang.Math.* ;


public class ComplexEn {

  private double re;   // real part
  private double im;   // imaginary part


  // Constructors
  ComplexEn (double re, double im){
    this.re = re;
    this.im = im;
  }

  ComplexEn (double re){
    this(re, 0);
    // this.re = re;
    // this.im = 0;
  }

  ComplexEn (){
    this(0);
  }


  // Constants
  static final ComplexEn I = new ComplexEn(0.0, 1.0);
  static final ComplexEn ZERO = new ComplexEn(0.0);
  static final ComplexEn HALF = new ComplexEn(0.5);
  static final ComplexEn ONE = new ComplexEn(1.0);


  // ComplexEn number in Cartesian coordinates
  static double real (ComplexEn z){
    return z.re;
  }

  static double imag (ComplexEn z){
    return z.im;
  }


  // ComplexEn number in Polar coordinates
  static double abs (ComplexEn z){
    return Math.sqrt(z.re*z.re + z.im*z.im);
  }

  static double arg (ComplexEn z){
    return Math.atan2(z.im, z.re);
  }


  // returning the ComplexEn conjugate of the ComplexEn argument
  static ComplexEn conj(ComplexEn z){
    return new ComplexEn(z.re,-z.im);
  }


  // Basic mathematical operations with ComplexEn numbers
  static ComplexEn add(ComplexEn z1, ComplexEn z2){
    ComplexEn temp = new ComplexEn ();
    temp.re = z1.re + z2.re;
    temp.im = z1.im + z2.im;

    return temp;
  }

  static ComplexEn sub(ComplexEn z1, ComplexEn z2){
    ComplexEn temp = new ComplexEn (0.0,0.0);
    temp.re = z1.re - z2.re;
    temp.im = z1.im - z2.im;

    return temp;
  }

  static ComplexEn mul(ComplexEn z1, ComplexEn z2){
    ComplexEn temp = new ComplexEn (0.0,0.0);
    temp.re = (z1.re * z2.re)-(z1.im * z2.im);
    temp.im = (z1.re * z2.im)+(z1.im+z2.re);

    return temp;
  }

  static ComplexEn div(ComplexEn z1, ComplexEn z2){
    ComplexEn temp = new ComplexEn (0.0,0.0);
    temp.re = ((z1.re * z2.re)+(z1.im * z2.im))/(z2.re*z2.re+z2.im*z2.im);
    temp.im = ((z1.im * z2.re)-(z1.re+z2.im))/(z2.re*z2.re+z2.im*z2.im);

    return temp;
  }




  // More mathematical functions
  static boolean equals(ComplexEn z1, ComplexEn z2){
    // method to find out apprpximate equality of two ComplexEn numbers
    return z1.re == z2.re && z1.im == z2.im;
  }


  // ComplexEn -> String --- as a pair of real numbers:  (re, im)
  public String toString() {
    return "(" + re + ", " + im + ")";
    // alternative representation:
    // ComplexEn -> String --- "1.0 - i*3.0"
    // if (im < 0.0) {
    //   return "(" + re + " - i*" + -im + ")";
    // }
    // else {
    //   return "(" + re + " + i*" +  im + ")";
    // }
  }


  /**
   * Assertion printing to the standard output (terminal). Note, the standard
   * `assert` statement should be preferred in general, but results in a very verbose
   * output that is not needed for this simple example.
   *
   * @param passed   Result of a validation statement
   * @param message  String representing a message what is going wrong
   **/
  private static void assert_out(boolean passed, String message) {
    if ( ! passed ) {
      System.out.println("WARNING: Assertion raised: " + message);
    }
  }


  /* Test for validity of the basic arithmetic operations as well as of the other
   * mathematical functions defined above. If a test fails, a message is printed to
   * the terminal by using the class method `assert_out(...)`.
   */
  private static void test() {
    ComplexEn z1 = new ComplexEn( 3.0, -7.0);
    ComplexEn z2 = new ComplexEn(-5.0, 11.0);

    assert_out(equals(z1, new ComplexEn(3.0, -7.0)),
         "equals incorrectly defined!");
    assert_out(equals(add(z1, z2), new ComplexEn(-2.0,  4.0)),
         "ComplexEn addition incorrectly defined!");
    assert_out(equals(sub(z1, z2), new ComplexEn( 8.0,-18.0)),
         "ComplexEn subtraction incorrectly defined!");
    assert_out(equals(mul(z1, z2), new ComplexEn(62.0, 68.0)),
         "ComplexEn multiplication incorrectly defined!");
    assert_out(equals(div(z1, z2), new ComplexEn(-46.0/73.0, 1.0/73.0)),
         "ComplexEn division incorrectly defined!");
    assert_out(equals(conj(z1), new ComplexEn(3.0, 7.0)),
         "ComplexEn conjugation incorrectly defined!");
    assert_out(abs(z1) == 7.615773105863909,
         "ComplexEn absolute value incorrectly defined!");
    assert_out(arg(z2) == 1.9974238199217726,
         "ComplexEn angle incorrectly defined!");
  }


  /* Test for validity of arithmetic identities like associativity and commutativity
   * of the basic arithmetic operations and some of the other mathematical functions.
   */
  private static void test(ComplexEn z1, ComplexEn z2) {
    System.out.println("\nComplexEn test started");
    System.out.println("z1: " + z1 + " ... z2: " + z2);
    System.out.println("z1 == z2: " + equals(z1,z2) +
                  " ... z2 == z1: " + equals(z2,z1));
    System.out.println("conj(z1): " + conj(z1) +
                  " ... conj(z2): " + conj(z2));

    if ( ! equals(z1, conj(conj(z1))) ) {
      System.out.println("ERROR in conj");
    }

    if ( ! equals(z2, conj(conj(z2))) ) {
      System.out.println("ERROR in conj");
    }

    System.out.println("real(z1)(): " + real(z1) +
                  " ... imag(z1): " + imag(z1));
    System.out.println("real(z2)(): " + real(z2) +
                  " ... imag(z2): " + imag(z2));

    System.out.println("abs(z1): " + abs(z1) +
                  " ... arg(z1): " + arg(z1));
    System.out.println("abs(z1): " + abs(z1) +
                  " ... arg(z1): " + arg(z1));

    System.out.println("Add: " + add(z1,z2) + " ... " + add(z2,z1));
    System.out.println("Sub: " + sub(z1,z2) + " ... " + sub(z2,z1));
    System.out.println("Mul: " + mul(z1,z2) + " ... " + mul(z2,z1));
    System.out.println("Div: " + div(z1,z2) + " ... " + div(z2,z1));

    System.out.println("ARI: " + sub(sub(add(z1,z2),z1),z2) );
    System.out.println("ARI: " + sub(add(z1,sub(z2,z1)),z2) );
    System.out.println("ARI: " + div(div(mul(z1,z2),z1),z2) );
    System.out.println("ARI: " + div(mul(z1,div(z2,z1)),z2) );

    System.out.println("ComplexEn test finished");
  }


  // Main entrance point of the Java program that runs some test cases.
  public static void main(String[] args) {
    test();

    test(new ComplexEn(2.0, -3.0),       new ComplexEn(5.0, -7.0));
    test(new ComplexEn(1.0),             new ComplexEn(0.0, 1.0));
    test(new ComplexEn(Math.PI, Math.E), new ComplexEn(Math.PI, Math.E));
    test(new ComplexEn(3.0, 4.0),        new ComplexEn(4.0, 3.0));
    test(new ComplexEn(0.0, 0.0),        new ComplexEn(0.0, 0.0));

    if ( ! equals(new ComplexEn(13.0), new ComplexEn(13.0, 0.0)) ) {
      System.out.println("ERROR in Constructors");
    }

    // Check that a constant cannot be modified
    // I = I.add(new ComplexEn(1.0, -1.0));   // Compiler error
    System.out.println("\nImaginary unit: " + I);
    // Check whether attributes of imaginary unit are mutable
    I.re= 5.0;
    System.out.println("Imaginary unit? " + I + "\n");
  }

}

