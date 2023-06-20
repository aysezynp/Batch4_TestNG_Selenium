package com.kraftechnologie.tests.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("**Open Browser**");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("**Close Browser**");
            }

    @Test
    public void test1() {
        System.out.println("First assertions");
        Assert.assertEquals("Title","Title");//birebir eşleşme olmalı

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2() {
        System.out.println("Third assertion");
        Assert.assertEquals("test2","test2");

    }

    @Test
    public void test3() {
        String expectedTitle="Kraft";
        String actualTitle="Kraftech";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify that title staring tech");//mesaj hata olunca görünür
        // bu assrtionda beklenen true yani karşılaştırmanın true olması durumunda test geçer
        //expected true //actual da true olursa geçer actual false olursa test geçmez
    }

    @Test
    public void test4() {
//verify that email contains @ sign
        String email="krafttech@srudy.com";

      /*  if(email.contains("@")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }*/
        Assert.assertTrue(email.contains("@"));
        //expected true actual da true ise geçer
        //bu test geçer
    }

    @Test
    public void test5() {
        Assert.assertFalse(0>1,"verify that is not greater than 1");

        //expected false actual false olursa geçer true olursa geçmez
        //0>1 false olduğu için beklenen de false old. için geçer
        //ancak 0<1 olsydı expected false actual true old. için geçmez

    }

    @Test
    public void test6(){
    Assert.assertNotEquals("two","one");
    //beklenen yani expected eşit olmaması actual da eşit olmadığı için geçer.
    }
}
