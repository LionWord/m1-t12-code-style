import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) { //Понятнее, когда переменная объявлена имением (amount вместо a и тд)
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int exponent) {
        double scale = Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }

    void calculateMoneyGain() {
        int period;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double result = 0;
        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateMoneyGain();
    }
}
