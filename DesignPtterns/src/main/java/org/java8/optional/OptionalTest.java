package org.java8.optional;

import java.util.Optional;

/**
 * @author mu_qingfeng
 * @date 2022/1/30 11:13 AM
 */
public class OptionalTest {
    public static void main(String[] args) {
        User user = null;
        Optional<User>  optional = Optional.ofNullable(user);

//        System.out.println(optional.get());

        System.out.println(optional.isPresent());
    }
}
