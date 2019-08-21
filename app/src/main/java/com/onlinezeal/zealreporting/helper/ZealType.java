package com.onlinezeal.zealreporting.helper;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public class ZealType {

    public static <T> T getType(Object type, Class<T> classes) {
        try {
            return classes.cast(type);
        } catch (ClassCastException ex) {
            return null;
        }
    }
}
