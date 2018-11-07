package com.example.andre.questquiz.helper;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class SharedPreferenceTest {

    SharedPreferences sharedPrefs = Mockito.mock(SharedPreferences.class);
    Context context = Mockito.mock(Context.class);

    @Mock
    Base64Custom base;

    @Before
    public void setUp() throws Exception {
        this.sharedPrefs = Mockito.mock(SharedPreferences.class);
        this.context = Mockito.mock(Context.class);
        Mockito.when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs);
    }

    @Test
    public void codificarTest () {
        context = Mockito.mock(Context.class);
        sharedPrefs = Mockito.mock(SharedPreferences.class);

        when(context.getString(anyInt())).thenReturn("test-string");
        when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs);
    }

}
