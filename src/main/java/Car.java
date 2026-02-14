public class Car {
    private String name;    // название автомобиля
    private int speed;      // скорость автомобиля, км/ч

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Метод для вывода информации об автомобиле
    public void displayInfo() {
        System.out.println("Автомобиль: " + name + ", скорость: " + speed + " км/ч");
    }
}