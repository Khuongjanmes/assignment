/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assigntment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class BillManager {
    private Map<String, Bill> bills = new HashMap<>();
    
    public Bill findBillByCode(String customerCode) {
        return bills.get(customerCode); 
    }

   
    public boolean addBill(Bill bill) {
        if (bills.containsKey(bill.getCustomerCode().toUpperCase())) {
            return false; 
        }
        bills.put(bill.getCustomerCode(), bill);
        return true;
    }

    public int calculateTotalPaymentByCustomerType(String customerType) {
        int totalPayment = 0;
        for (Bill bill : bills.values()) { 
            if (bill.getCustomerType().equalsIgnoreCase(customerType)) {
                totalPayment += bill.calculatePayment();
            }
        }
        return totalPayment;
    }
    
    public Bill findBillWithLargestPayment() {
       return Collections.max(bills.values(), Comparator.comparingInt(Bill::calculatePayment));
    }
   
    public boolean isCustomerCodeExists(String customerCode) {
        return bills.containsKey(customerCode);
    }

   
    public boolean deleteBillByCode(String customerCode) {
        return bills.remove(customerCode) != null;
    }

   
    public Map<String, Bill> getAllBills() {
        return bills;
    }
}
