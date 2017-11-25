package pl.kodolamacz.spring;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by acacko on 25.11.17
 */
public class HashTest {

    @Test
    public void hashTest() {
        System.out.println("myPassword -> md5:" + DigestUtils.md5Hex("myPassword"));
        System.out.println("pass2 -> md5:" + DigestUtils.md5Hex("pass2"));
        System.out.println("a -> md5:" + DigestUtils.md5Hex("a"));

        // kiepskie:
        System.out.println("mojeHasło -> hashCode:" + new String("mojeHasło").hashCode());
    }
}
