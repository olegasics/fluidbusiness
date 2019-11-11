package ru.basics.server.utils.restUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.basics.server.rest.RestControllerInterface;

public class RestUtils<T> {

    public static Boolean checkIsNullBool(Object o) {
        if (o == null) {
            return true;
        }
        return false;
    }


}
