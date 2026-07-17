import java.util.List;

public class AdvancedGenericsExample {

    // Generic method with a bounded type parameter:
    // T must implement both Comparable and Cloneable
    public static <T extends Comparable<T> & Cloneable>     T findMax(List<T> list) {
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Wildcard example: accepts a list of Number or any subtype (Integer, Double, etc.)
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(10, 25, 3, 47, 8);
        List<Double> doubleList = List.of(1.5, 2.7, 0.9);

        System.out.println("Sum of intList: " + sumOfList(intList));
        System.out.println("Sum of doubleList: " + sumOfList(doubleList));
    }
}