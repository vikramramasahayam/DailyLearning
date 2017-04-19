package com.vik.daily.learning.core;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

public class TestUri {

    @Test
    public void testHostName() throws URISyntaxException {
        // URI uri = new URI("http://localhost:8080");
        URI uri = new URI("file://tmp");
        System.out.println("Schema : " + uri.getScheme());
        System.out.println("HostName : " + uri.getHost());
        System.out.println("PortNumber : " + uri.getPort());
    }

}
