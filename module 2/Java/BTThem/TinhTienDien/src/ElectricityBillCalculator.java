public class ElectricityBillCalculator {
    public double calculate (int kwh) {
        double amount =0;
        if (kwh <= 50 ) {
            amount = kwh * 1800;
        } else if (kwh <= 100) {
            amount= 50 * 1800 + (kwh-50) * 2300;
        } else {
            amount= 50 * 1800 + 50 * 2300 + (kwh-100) * 3000;
        }
        return amount;
    }
}
