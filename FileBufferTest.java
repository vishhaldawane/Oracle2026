import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class FileBufferTest {
    public static void main(String[] args) {
        try {
            System.out.println("Trying to open a file...");
            //byte based stream - ASCII
            //can only read english data
            FileInputStream fin1 = new
                    FileInputStream("/Users/admin/PRMITR/copy.txt");

            FileInputStream fin2 = new
                    FileInputStream("/Users/admin/PRMITR/copy.txt");

            BufferedInputStream buff = new BufferedInputStream(fin2); // fin2 is passed here


            System.out.println("File is opened....fin1");
//byte is 1 byte in memory, 8 bits = 256 letters
            Date now = new Date(); //java.util - find the time before the loop

            System.out.println("File reading started...without buffering");
            byte theByte = (byte) fin1.read(); //raed the first LETTER

            while(theByte != -1) { //verify the End of File is reached or not
                //System.out.print((char)theByte); //print that first LETTER
                theByte = (byte) fin1.read(); //grab the second letter now
            }
            Date then = new Date(); // find the time after the loop
            System.out.println("File reading over...without buffering");
            System.out.println("Without buffer File read time : "+ (then.getTime()-now.getTime()) + " ms" );
            fin1.close(); //always close the files

            System.out.println("============");
            System.out.println("File is opened....fin2 via buff");
//byte is 1 byte in memory, 8 bits = 256 letters
            now = new Date(); //java.util - find the time before the loop

            System.out.println("File reading started...WITH  buffering");
            theByte = (byte) buff.read(); //raed the first LETTER

            while(theByte != -1) { //verify the End of File is reached or not
                //System.out.print((char)theByte); //print that first LETTER
                theByte = (byte) buff.read(); //grab the second letter now
            }
            then = new Date(); // find the time after the loop
            System.out.println("File reading over...WITH buffering");
            System.out.println("WITH buffer File read time : "+ (then.getTime()-now.getTime()) + " ms" );



            buff.close();
            fin2.close();


        } catch (FileNotFoundException e) {
            System.out.println("Exception : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception : "+e.getMessage());
        }

    }
}
/*
    Java Objects / data used here in Java is in the memory
    memory is volatile
    we want to store our java data on a device
    in the form of a file or a database row

                Java Objects / DATA
                        |
             ----------------------
                |               |
                File            Database
                |


          Read the file         Write to the file
          |                     |
          input stream          output stream


                    Java i/o
                     |
              ------------------
              |                 |
            byte based       character based
            1 byte             1 char = 2 bytes
            |                   |
            ASCII               UNICODE
            |                   |
            256 english         international letters
            letters             65535 ( first 256 ASCII )
                |                       |
       -------------            -----------------
       |        |                   |           |
 InputStream   OutputStream         Reader      Writer <-- abstract parents
 |  read()          |write()        |  read()      |write()
 FileInputStream FileOutputStream  FileReader   FileWriter

any class in java.io ends with
Stream word is of BYTE BASED STREAM

any class ends with Reader or Writer
is of CHARACTER BASED STREAM





























 */