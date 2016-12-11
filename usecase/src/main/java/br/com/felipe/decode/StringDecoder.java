package br.com.felipe.decode;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Class responsible to decode String
 */
public class StringDecoder {

    public String decodeBase64(String toDecode) {
        return new String(Base64.decodeBase64(toDecode));
    }
}
