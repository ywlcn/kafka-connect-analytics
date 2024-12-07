package com.sea;

import org.apache.kafka.connect.cli.ConnectDistributed;
import org.apache.kafka.connect.cli.ConnectStandalone;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KafkaConnectApplication {

    public static void main(String... args) {

        String workConfig = getFile("work-config/connect-standalone.properties");
        String connectConfig = getFile("connector-config/connect-jdbc-source.properties");
        ConnectStandalone.main(new String[]{workConfig, connectConfig});
    }



    private static String getFile(String path){
        return KafkaConnectApplication.class.getClassLoader().getResource(path).getFile().substring(1);

    }

}
