package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empy() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneElementStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }

}

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneElementStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}
