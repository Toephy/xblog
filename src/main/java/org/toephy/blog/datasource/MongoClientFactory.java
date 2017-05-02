package org.toephy.blog.datasource;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.toephy.blog.util.ResourcesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Toephy on 2017.5.2 15:27
 */
public class MongoClientFactory {
    private static final String RESOURCE_PATH = "mongo.properties";

    private static MongoClientFactory factory = new MongoClientFactory();

    private MongoClient mongoClient;

    private MongoClientFactory() {
        init();
    }

    public static MongoClient getClient() {
        return factory.getMongoClient();
    }

    private MongoClient getMongoClient() {
        return mongoClient;
    }

    private void init() {
        try {
            System.out.println("init MongoClient start...");
            long startTime = System.currentTimeMillis();
            Properties properties = ResourcesUtils.getResourceAsProperties(RESOURCE_PATH);
            String hostsString = properties.getProperty("hosts");

            String[] hostArray = hostsString.split(",");
            List<ServerAddress> serverAddressList = new ArrayList<ServerAddress>();
            for (String host : hostArray) {
                if (StringUtils.isNotBlank(host)) {
                    String[] serverPost = host.split(":");
                    serverAddressList.add(new ServerAddress(serverPost[0], Integer.valueOf(serverPost[1])));
                }
            }

            MongoClientOptions.Builder build = new MongoClientOptions.Builder();
            build.connectionsPerHost(MapUtils.getIntValue(properties, "connectionsPerHost", 50));
            build.maxWaitTime(MapUtils.getIntValue(properties, "maxWaitTime", 1000 * 60 * 2));
            build.connectTimeout(MapUtils.getIntValue(properties, "connectTimeout", 1000 * 10));
            build.socketTimeout(MapUtils.getIntValue(properties, "socketTimeout", 0));
            build.readPreference(ReadPreference.secondaryPreferred());
            MongoClientOptions options = build.build();

            mongoClient = new MongoClient(serverAddressList, options);

            long timeCost = System.currentTimeMillis() - startTime;
            System.out.println("init MongoClient completed in " + timeCost + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
