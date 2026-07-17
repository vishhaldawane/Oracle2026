import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) {


        PickleJar pickleJar1 = new PickleJar(1, 950);
        pickleJar1.show();

                //every instance of an "Object class"
                //got a method called as getClass()
                //that returns an instance of class "Class"

                //Reflection API - object crawlers | browsers |

                Class theMirror = pickleJar1.getClass();

        Annotation anno[] = theMirror.getAnnotations();
        for (Annotation a : anno) {
            // System.out.println(a);
            if (a instanceof CreatedBy) {
                CreatedBy createdBy = (CreatedBy) a;
                System.out.println(createdBy.name());
                System.out.println(createdBy.pickleType());
                if (createdBy.name().equalsIgnoreCase("savita")) {
                    System.out.println("It would be tasty....");
                } else {
                    System.out.println("It wont be tasty ....");
                }
            }
        }

        Method methodDetails[] = theMirror.getMethods();

        for (Method m : methodDetails) {
            System.out.println("method name : " + m.getName());

            Annotation methodAnnoAry[] = m.getAnnotations();
            for(Annotation methodAnno : methodAnnoAry){
                if (methodAnno instanceof Thickness) {
                    Thickness thickness = (Thickness) methodAnno;
                    System.out.println(thickness.type());
                    if (thickness.type().equalsIgnoreCase("oily")) {
                        System.out.println("It would be great to eat with rice..");
                    } else {
                        System.out.println("It wont be great to eat with rice....");
                    }
                }
            }

        }


    }

}

@CreatedBy(name="reeta", pickleType="lemon")
class PickleJar
{


    int weight;
    int capacity;


    PickleJar(int weight, int capacity)
    {
        this.weight = weight;
        this.capacity = capacity;
    }

    @Thickness(type="oily") //can be dry, oily
    public void show() {
        System.out.println("Pickle jar is shown....");
    }
    public void fun() {

    }
    public void foo() {

    }
}