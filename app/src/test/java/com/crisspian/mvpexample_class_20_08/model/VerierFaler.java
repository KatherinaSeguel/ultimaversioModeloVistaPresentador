package com.crisspian.mvpexample_class_20_08.model;

import com.google.j2objc.annotations.Weak;

import org.junit.Before;
import org.junit.Test;

import static com.crisspian.mvpexample_class_20_08.model.Verifier.MEDIUM;
import static com.crisspian.mvpexample_class_20_08.model.Verifier.STRONG;
import static com.crisspian.mvpexample_class_20_08.model.Verifier.WEAK;
import static com.google.common.truth.Truth.assertThat;

public class VerierFaler {
    private Verifier verifier;

    @Before
    public void setUP(){
        verifier= new Verifier();

    }

    @Test
    public  void verifierweak(){
        //given
        String password = "pas";
        //when
        int opcion = verifier.evaluatePass(password);
        //then , que pasa

        assertThat(opcion).isEqualTo(WEAK); //valor del weak  WEAK
    }

    @Test
    public  void verifiermedium(){
        //given
        String password = "aasd22222";
        //when
        int opcion = verifier.evaluatePass(password);
        //then , que pasa

        assertThat(opcion).isEqualTo(MEDIUM); //valor del weak  WEAK
    }

    @Test
    public  void verifierstrong(){
        //given
        String password = "ASdfreee";
        //when
        int opcion = verifier.evaluatePass(password);
        //then , que pasa

        assertThat(opcion).isEqualTo(STRONG); //valor del weak  WEAK
    }

}
