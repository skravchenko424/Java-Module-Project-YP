public class Race {
    private String leaderName;
    private int leaderDistance;

    private static final int RACE_TIME = 24;

    public Race() {
        this.leaderName = "";
        this.leaderDistance = 0;
    }

    // Метод для определения нового лидера
    public void checkLeader(Car car) {
        int carDistance = RACE_TIME * car.getSpeed();

        // Сравниваем дистанцию нового автомобиля с дистанцией текущего лидера
        if (carDistance > leaderDistance) {
            leaderName = car.getName();
            leaderDistance = carDistance;
        }
    }

    public String getLeaderName() {
        return leaderName;
    }

    public int getLeaderDistance() {
        return leaderDistance;
    }

    // Метод для вывода итогов гонки
    public void printRaceResults() {
        if (leaderName.isEmpty()) {
            System.out.println("Гонка не состоялась или не было участников");
        } else {
            System.out.println("\n=== ГОНКА ЗАВЕРШЕНА ===");
            System.out.println("Победитель: " + leaderName);
            System.out.println("Пройденная дистанция: " + leaderDistance + " км");
        }
    }
}