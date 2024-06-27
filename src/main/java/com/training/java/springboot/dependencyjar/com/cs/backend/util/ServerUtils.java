package com.training.java.springboot.dependencyjar.com.cs.backend.util;

import java.net.InetAddress;

public class ServerUtils {

    public static String getServerName() throws Exception {
        // return com.ibm.websphere.runtime.ServerName.getFullName();

        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String hostname = addr.getHostName();

        return hostname;
    }
}

