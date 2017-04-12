import com.datastax.driver.core.*;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.common.base.Stopwatch;
import utils.Importer;

import java.io.File;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;


public class application {

    public static void main(String[] args) {

        if(args.length == 0){
            System.out.println("No command line arguments specified.");
            return;
        }

        // Get the file name
        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("Could not find file: " + args[0]);
            return;
        }
        else {
            System.out.println("Import data from ==> " + args[0]);
        }

        String fileName = args[0];

        String host = "localhost";
        if (args.length > 1){
            host = args[1];
        }

        System.out.println("Using host = " + host);

        // Open a connection to Cassandra
        Session session;
        Cluster cluster;
        try {
            cluster = Cluster.builder()
                        .addContactPoint(host)
                        .withRetryPolicy(DefaultRetryPolicy.INSTANCE)
                        .build();
            session = cluster.connect("ai_stackexchange_com");
        }catch (Throwable throwable){
            System.out.println("ErrorMessage = " + throwable.getMessage());
            throwable.printStackTrace();
            return;
        }
        System.out.println("Connected to :" + host);

        Importer importer = new Importer();
        importer.usesImporter(fileName, session);

        cluster.close();
    }
}
