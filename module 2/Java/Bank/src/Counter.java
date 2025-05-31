public class Counter {
    private int id;
    private Customer currentCustomer;

    public Counter(int id) {
        this.id = id;
        this.currentCustomer = null;
    }

    public boolean isBusy() {
        return currentCustomer != null;
    }

    public void serve(Customer customer) {
        this.currentCustomer = customer;
    }

    public void finish() {
        this.currentCustomer = null;
    }

    public String getStatus() {
        if (isBusy()) {
            return "Quầy " + id + ": Đang phục vụ " + currentCustomer.getName();
        } else {
            return "Quầy " + id + ": Rảnh";
        }
    }
}