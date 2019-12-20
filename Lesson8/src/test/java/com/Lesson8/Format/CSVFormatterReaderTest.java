package com.Lesson8.Format;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class CSVFormatterReaderTest {
    CSVFormatterReader csvFormatterReader=new CSVFormatterReader();

    @Test
    public void checkingTheNumberFieldsRead(){
        ArrayList<String[]> testList=new ArrayList<>();
        testList=csvFormatterReader.formaterTo("testA.csv");
        String[] mas;
        mas=testList.get(0);
        int length=mas.length;
        Assert.assertTrue(length==6);
        length=testList.get(3).length;
        Assert.assertTrue(length==5);
        length=testList.get(4).length;
        Assert.assertTrue(length==5);
    }


    @Test
    public void checkingForBlankFields(){
        ArrayList<String[]> testList=new ArrayList<>();
        testList=csvFormatterReader.formaterTo("testA.csv");
        String[] mas;
        mas=testList.get(6);
        String tmp=mas.toString();
        Assert.assertTrue(tmp.contains(""));
    }
}