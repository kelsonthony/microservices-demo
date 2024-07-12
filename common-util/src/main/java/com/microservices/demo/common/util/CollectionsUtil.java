package com.microservices.demo.common.util;

import java.util.List;

public class CollectionsUtil {

    private CollectionsUtil() {

    }

    public static class CollectionsUtilHolder {
        static final CollectionsUtil INSTANCE = new CollectionsUtil();
    }

    public static CollectionsUtil getInstance() {
        return CollectionsUtilHolder.INSTANCE;
    }

    public <T> List<T> getListfromIterable(Iterable<T> iterable) {
        List<T> list = new java.util.ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
