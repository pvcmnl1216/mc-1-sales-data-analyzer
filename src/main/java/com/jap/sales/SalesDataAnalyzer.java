package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalesDataAnalyzer {
    public List<SalesRecord> readFile(String fileName) {
        List<SalesRecord> salesRecordList = new ArrayList<>();

        try {
            FileReader fis = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                String date = split[0];
                int customerID = Integer.parseInt(split[1]);
                int productCategory = Integer.parseInt(split[2]);
                String paymentMethod = split[3];
                double value = Double.parseDouble(split[4]);
                double timeOnSite = Double.parseDouble(split[5]);
                int clicksInSite = Integer.parseInt(split[6]);
                salesRecordList.add(new SalesRecord(date,
                        customerID,
                        productCategory,
                        paymentMethod,
                        value,
                        timeOnSite,
                        clicksInSite));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return salesRecordList;
    }

    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData, AmountComparator amountComparator) {
        Collections.sort(salesData, amountComparator);
        return salesData;
    }

    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData, TimeOnSiteComparator timeOnSiteComparator) {
        Collections.sort(salesData, timeOnSiteComparator);
        return salesData.get(0);
    }
}
