package id.mbingweb.hctest.util;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fqodry
 */
@Setter
@Getter
public class Response<T> {
    private String service;
    private String message;
    private T data;
}
