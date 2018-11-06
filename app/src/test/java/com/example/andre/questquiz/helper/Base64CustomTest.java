package com.example.andre.questquiz.helper;

import android.util.Base64;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class Base64CustomTest {

    String VALOR = "andre";

    @Mock
    Base64 base64;

    @Mock
    Base64Custom base;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void codificarTest (){
        String test = base.codificarBase(VALOR);
        assertEquals("YW5kcmU=", "YW5kcmU=");
    }



}
