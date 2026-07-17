import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileTest {
    public static void main(String[] args) {

        try {
            System.out.println("Trying to open a file...");
            // c:\\Users\\urname\\filename.txt

            FileInputStream fis = new FileInputStream("/Users/admin/PRMITR/prince.txt");
            System.out.println("file is ready to read...");

            byte b = (byte) fis.read(); //read first letter

            while(b != -1) { //check if EOF
                System.out.print((char) b);
                b = (byte) fis.read(); //read successive letters
                Thread.sleep(50);
            }
            fis.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}


