package com.xzit.module.junit_mockito.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTwoService {

    @InjectMocks
    private TwoService twoService;

    @Mock
    private OneService oneService;

    @Test
    public void testGetPriceByOneService() {
        Mockito.when(oneService.getPriceByProductCode(Mockito.anyString())).thenReturn(800);
        Assertions.assertEquals(1800, twoService.getPriceByOneService("any"));
    }

    @Test
    public void testGetPriceByTwoService() {
        TwoService twoServiceSpy = Mockito.spy(twoService);

        Mockito.when(oneService.getPriceByProductCode(Mockito.anyString())).thenReturn(800);
        Mockito.doReturn(1000).when(twoServiceSpy).getRandomPrice(Mockito.anyString());
        Assertions.assertEquals(2800, twoServiceSpy.getPriceByTwoService("any"));
    }
}
