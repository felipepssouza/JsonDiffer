package br.com.felipe.decode;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

/**
 * Class responsible to decode String
 */
@Component
public class StringDecoder {

    public String decodeBase64(String toDecode) {
        return new String(Base64.decodeBase64(toDecode));
    }
}
