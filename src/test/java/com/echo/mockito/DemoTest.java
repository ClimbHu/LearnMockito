package com.echo.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Random;

class DemoTest {

    @Spy
    private Demo demo;

    @BeforeEach
    void setUp() {
        System.out.println("---------测试开始-----------");
        // 搭配spy注解使用，真实模拟
        MockitoAnnotations.openMocks(this);
    }

    /**
     * @Description 测试对象模拟mock，times：次数；verify：行为验证，打桩；assertions：断言
     */
    @Test
    void add() {
        // 模拟一个Random对象
        Random random = Mockito.mock(Random.class);
        System.out.println(random.nextInt());
        // 校验，该方法执行了一遍
        Mockito.verify(random,Mockito.times(1)).nextInt();
        System.out.println("华丽的分割线--------------");
        // mock需要打桩，调用该方法后的返回值为100
        // mock 出来的对象需要打桩，对行为进行规范
        Mockito.when(random.nextInt()).thenReturn(100);

        // Mockito.when(demo.add(1,2)).thenReturn(3);
        Assertions.assertEquals(100,random.nextInt());
    }

    /**
     * @Description spy真实模拟，调用真实的方法
     */
    @Test
    void add1() {
        // MockitoAnnotations.openMocks(this);
        // spy 出来的对象不用进行打桩，默认走真实方法
        Assertions.assertEquals(3, demo.add(1, 2));

        // 真实模拟不需要打桩，会调用真实方法
        Mockito.when(demo.add(1,2)).thenReturn(0);
        Assertions.assertEquals(0, demo.add(1, 2));
    }

    @AfterEach
    void setOff() {
        System.out.println("---------测试结束-----------");
    }
}