package com.xzit.module.junit_mockito.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TwoServiceTest {

    @InjectMocks
    private TwoService twoService;

    @Mock
    private OneService oneService;

//    @RunWith(SpringRunner.class) 可以替代：
//    @Before
//    public void before() {
//        MockitoAnnotations.openMocks(this);
//    }

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
