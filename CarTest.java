public class CarTest {
    public static void main(String[] args)
    {
        try {
            Driver driver=new Driver();
            driver.drive();
        } catch (CarKeyNotFoundException e) { //mandatory for checked one
            System.out.println(e.getMessage());
        }
        catch(SpeedLimitException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End of main....");

    }
}
class Driver {
    Car car= new Car();
    Driver() throws CarKeyNotFoundException {
        System.out.println("Driver is ready...to drive...");
      //  drive();
    }
    void drive() {
        longDrive();
    }
    private void longDrive() {
        for(int i=1;i<=50;i++) {
            System.out.println("Long drive..."+i);
            double speed = Math.random()%10;
            if(speed>0.98) {
                throw new SpeedLimitException("Oh No Speed limit exceeded....");
            }
        }

    }
}
class SpeedLimitException extends RuntimeException {
    public SpeedLimitException(String message) {
        super(message);
    }
}

class Car{
    boolean isKeyFound=false;

    Car() throws  CarKeyNotFoundException
    {
        double val = Math.random()%10;
        if(val>0.30) {
            isKeyFound=true;
        }
        else {
            throw new  CarKeyNotFoundException("Unable to find key of the Car...");
        }
    }
}
class CarKeyNotFoundException extends Exception{
    public CarKeyNotFoundException(String message) {
        super(message);
    }
}