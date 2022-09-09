package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SalesDataAnalyzer {
    // Read the data from the file and store in a List
    public List<SalesRecord> readFile(String fileName) {
        List<SalesRecord> salesRecordList = new ArrayList<>();
        // read the CSV file
        try {
            FileReader fis = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // get one row at a time
        // read the values from the row
        // use the values to create an object
        // add that object in a list
        // return the list
        return salesRecordList;
    }

    // Sort the customers based on purchase amount
    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(
            List<SalesRecord> salesData,
            AmountComparator amountComparator
    ) {
        List<SalesRecord> salesRecordList = new ArrayList<>();
        // sort the sales record list, according to the criteria set by the amountComparator parameter
        Collections.sort(salesRecordList, new Comparator<SalesRecord>() {
            @Override
            public int compare(SalesRecord o1, SalesRecord o2) {
                return 0;
            }
        });
        return salesRecordList;
    }

    // Find the top customer who spent the maximum time on the site
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(
            List<SalesRecord> salesData,
            TimeOnSiteComparator timeOnSiteComparator
    ) {
        SalesRecord customerWhoSpentMaxTimeOnSite = new SalesRecord();
        // sort the sales data, according to the time spent on site, we want to find out the record

        // with the maximum time spent on site
        return customerWhoSpentMaxTimeOnSite;
    }
}
