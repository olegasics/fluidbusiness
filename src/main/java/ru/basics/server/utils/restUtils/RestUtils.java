package ru.basics.server.utils.restUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestUtils {

    public static ResponseEntity<Object> checkIsNullBool(Object o) {
        if (o == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
