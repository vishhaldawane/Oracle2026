public class DivideTest {
    public static void main(String[] args) {
        System.out.println("begin main");
        Calculator calci = new Calculator();
        int ans1 = calci.divide(10,2); System.out.println(ans1);
        int ans2 = calci.divide(50,0); System.out.println(ans2);
        int ans3 = calci.divide(70,3); System.out.println(ans3);
        int ans4 = calci.divide(300,7); System.out.println(ans4);
        System.out.println("end main");
    }
}
class Calculator
{
    int divide(int x, int y) {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("dividing...");
//        int z=0;
//        if(y==0) {
//            System.out.println("cannot divide by zero");
//        }
//        else {
//             z = x / y;
//        }
        int z=0;
        try
        {
            z=x/y;
        }
        catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception : "+e.getMessage());
        }
        //if y is zero, ArithmeticException's object is thrown from this line
                    //and if that object is not caught, then it is rethrown
                    //to jvm, and jvm would drop it by terminating your prg
                // x/0 -> AE e, throw e towards your prg,
                // your prg not ready to catch, hence it is rethrown to jvm
                // jvm is not going play catch catch with you,
                // it will drop the catch, by terminating it
        System.out.println("----- divided ------");
       return z;
    }
}

