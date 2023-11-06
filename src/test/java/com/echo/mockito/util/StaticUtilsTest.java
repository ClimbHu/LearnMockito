package com.echo.mockito.util;

// import com.echo.mockito.demo.demo;
// import com.echo.mockito.demo.demo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StaticUtilsTest {

    /**
     * @Description 对静态有参方法进行mock
     */
    @Test
    void range() {
        // 静态mock之后需要销毁，防止多个mock之间互相干扰
        try (MockedStatic<StaticUtils> demo = Mockito.mockStatic(StaticUtils.class)) {
            demo.when(() -> StaticUtils.range(2, 6)).thenReturn(Arrays.asList(10, 11, 12));
            List<Integer> range = StaticUtils.range(2, 6);

            Assertions.assertTrue(StaticUtils.range(2, 6).contains(12));
            // Assertions.assertTrue(StaticUtils.range(2, 6).contains(13));
        }
    }

    /**
     * @Description 对静态无参方法进行mock
     */
    @Test
    void name() {
        try(
            MockedStatic<StaticUtils> demo = Mockito.mockStatic(StaticUtils.class)) {
            demo.when(() -> StaticUtils.name()).thenReturn("haha");
            Assertions.assertEquals("haha", StaticUtils.name());
        }
    }
}