
package assigntment;


class Bill {
    private String customerCode;
    private String customerType;
    private int oldIndex;
    private int newIndex;

    public Bill(String customerCode, String customerType, int oldIndex, int newIndex) {
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public int calculateUsedElectricity() {
        return newIndex - oldIndex;
    }

    public int calculateNorm() {
        switch (customerType) {
            case "NN":
                return 500;
            case "SX":
            case "KD":
                return 400;
            default:
                return 300;
        }
    }

    public int calculatePayment() {
        int usedElectricity = calculateUsedElectricity();
        int norm = calculateNorm();
        if (usedElectricity <= norm) {
            return usedElectricity * 550;
        } else {
            return norm * 550 + (usedElectricity - norm) * 1100;
        }
    }
    
    @Override
    public String toString() {
        return "Customer Code: " + customerCode +
               "\nCustomer Type: " + customerType +
               "\nOld Index: " + oldIndex +
               "\nNew Index: " + newIndex +
               "\nPayment: " + calculatePayment() + " VND";
    }
}
