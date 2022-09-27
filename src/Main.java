import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //exercise 1
        int year = 2000 + (int) (Math.random() * ((2022 - 2000) + 1));
        if (isLeapYear(year))
            System.out.println(year + " является високосным");
        else
            System.out.println(year + " не является високосным");

        //exercise 2
        int prodYear = 2010 + (int) (Math.random() * ((2022 - 2010) + 1));
        int clientOS = 1;
        recommendedApplicationVersion(clientOS, prodYear);

        //exercise 3
        System.out.println("Потребуется дней: " + getDeliveryDays(95));

        //exercise 4
        int[] array = {3, 2, 1, 6, 5};
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
        reverseArray(array);
        for (int i : array)
            System.out.print(i + " ");

        System.out.println();

        //exercise 5
        String str = "aabccddefgghiijjkk";
        checkStringForDuplicate(str);

        //exercise 6
        int[] arr = generateRandomArray();
        double average = getAverage(arr);
        System.out.println(average);

    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void recommendedApplicationVersion(int clientOS, int prodYear) {
        if (clientOS == 1) {
            if (prodYear >= 2015) {
                System.out.println("Установите версию приложения для Android по ссылке");
            } else {
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
            }
        } else {
            if (prodYear >= 2015) {
                System.out.println("Установите версию приложения для IOS по ссылке");
            } else {
                System.out.println("Установите облегченную версию приложения для IOS по ссылке");
            }
        }
    }

    public static int getDeliveryDays(int distance) {
        int count = 1;

        distance -= 20;
        if (distance > 0) {
            int variable = distance / 40; //количество 40 км расстояний в deliveryDistance
            if (variable == 0) {
                count++;
            } else {
                count += variable + 1;
            }
        }
        return count;
    }

    public static void reverseArray(int[] array) {
        for (int i = array.length - 1, j = 0; i >= array.length / 2; i--, j++) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public static void checkStringForDuplicate(String str) {
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (tmp == str.charAt(i)) {
                System.out.println("Присутствует дупликат: " + tmp);
                return;
            }
            tmp = str.charAt(i);
        }
        System.out.println("Дупликатов не обнаружено");
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static double getAverage(int[] array) {
        double sum = calculateSum(array);
        return  calculateAverage(sum, array.length);
    }

    public static double calculateSum(int[] array) {
        double sum = 0;
        for (int i : array)
            sum += i;
        return sum;
    }

    public static double calculateAverage(double sum, int count) {
        return  sum / count;
    }
}