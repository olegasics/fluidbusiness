package ru.basics.server.utils.restUtils;

public class RestUtils<T> {

    public static Boolean checkIsNullBool(Object o) {
        if (o == null) {
            return true;
        }
        return false;
    }


}
