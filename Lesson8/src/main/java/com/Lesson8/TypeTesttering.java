package com.Lesson8;

public class TypeTesttering {
    private String string="Не верный тип данных! должен быть ";


    public Object tipeIs(Integer type){
        System.out.println(string+"Integer");
        return type;
    }
    public Object tipeIs(String type){
        System.out.println(string+"String");
        return type;
    }
    public Object tipeIs(char type){
        System.out.println(string+"char");
        return type;
    }
    public Object tipeIs(double type){
        System.out.println(string+"double");
        return type;
    }
    public Object tipeIs(int type){
        System.out.println(string+"int");
        return type;
    }
      public Object tipeIs(Object type){
        System.out.println(string+"Object");
        return type;
    }



}
