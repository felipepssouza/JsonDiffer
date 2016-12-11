package br.com.felipe.decode;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class StringDecoderTest {

    private StringDecoder decoder;

    @Before
    public void setup(){
        this.decoder = new StringDecoder();
    }

    @Test
    public void shouldDecodeString(){
        String decodedString = this.decoder.decodeBase64("eyJub21lIjoiRmVsaXBlIiwiYWdlIjozMH0=");
        assertThat(decodedString, is(equalTo("{\"nome\":\"Felipe\",\"age\":30}")));
    }

}
