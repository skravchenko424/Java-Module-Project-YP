
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        System.out.println("Добро пожаловать в гоночный симулятор!");
        System.out.println("В гонке участвуют 3 автомобиля.");
        System.out.println("Допустимая скорость автомобилей: от 1 до 250 км/ч\n");

        // Цикл для ввода данных о трёх автомобилях
        for (int i = 1; i <= 3; i++) {
            // Ввод названия автомобиля с проверкой
            String name = inputCarNameValidation(scanner, i);

            // Ввод скорости автомобиля с проверкой
            int speed = inputSpeedWithValidation(scanner, i);

            Car car = new Car(name, speed);

            // Выводим информацию о введенном автомобиле
            System.out.println("Автомобиль " + name + " (скорость: " + speed + " км/ч) добавлен.");

            // Проверяем, стал ли новый автомобиль лидером
            race.checkLeader(car);

            System.out.println(); // Пустая строка для разделения
        }

        // Выводим итоги гонки
        race.printRaceResults();

        scanner.close();
    }

    private static String inputCarNameValidation(Scanner scanner, int carNumber) {
        String name;

        // Бесконечный цикл для проверки корректности ввода имени
        while (true) {
            System.out.println("Введите название автомобиля №" + carNumber + ":");
            name = scanner.nextLine();

            if (name.isBlank()) {
                printErrorMessage("Ошибка: введено пустое название автомобиля.");
            } else {
                break; // Выходим из цикла если введено корректное имя
            }
        }

        return name;
    }

    private static int inputSpeedWithValidation(Scanner scanner, int carNumber) {
        int speed;

        // Бесконечный цикл для проверки корректности ввода скорости
        while (true) {
            System.out.print("Введите скорость машины №" + carNumber + " (1-250 км/ч): ");

            // Проверяем, ввел ли пользователь целое число
            if (scanner.hasNextInt()) {
                speed = scanner.nextInt();

                // Проверяем, находится ли скорость в допустимом диапазоне
                if (speed > 0 && speed <= 250) {
                    scanner.nextLine(); // Очищаем буфер после nextInt()
                    break; // Выходим из цикла, если скорость корректна
                } else {
                    printErrorMessage("Ошибка: скорость должна быть в диапазоне от 1 до 250 км/ч. Попробуйте снова.");
                }
            } else {
                // Если пользователь ввел не число
                String invalidInput = scanner.next();
                printErrorMessage("Ошибка: '" + invalidInput + "' не является допустимым целым числом. Попробуйте снова.");
            }
            // scanner.nextLine() не нужен здесь, так как мы уже считали некорректный ввод через next() или nextInt()
        }

        return speed;
    }

    private static void printErrorMessage( String message) {
        System.out.println("\u001B[31m" + message + " \u001B[0m");
    }
}