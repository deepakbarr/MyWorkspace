package com.workspace.client.xml;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by deepak.barr on 30/06/15.
 */
public class MyLensClient {


    public static void main(String[] args) {
       String sessionHandle=createSession();
        System.out.println("sessionHandle = " + sessionHandle);

    }

    private static String createSession() {

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:9999/lensapi/session");

        MultivaluedMap formData = new MultivaluedMapImpl();
        formData.add("sessionconf", "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <conf>    <properties>       <entry>          <key>lens.query.result.parent.dir</key>          <value>hdfs://localhost:9000/tmp</value>       </entry>       <entry>          <key>lens.session.cluster.user</key>          <value>fk-dp-test</value>       </entry>       <entry>          <key>lens.query.enable.persistent.resultset</key>          <value>true</value>       </entry>       <entry>          <key>lens.query.hdfs.output.path</key>          <value>queryresult</value>       </entry>       <entry>          <key>lens.query.result.fs.read.url</key>          <value>http://localhost:50070/webhdfs/v1</value>       </entry>       <entry>          <key>lens.query.result.email.cc</key>          <value>username@flipkart.com</value>       </entry>       <entry>          <key>lens.query.enable.mail.notify</key>          <value>true</value>       </entry>       <entry>          <key>lens.query.enable.metrics.per.query</key>          <value>true</value>       </entry>    </properties> </conf>");
        formData.add("username", "lens");
        formData.add("password", "lens");
        ClientResponse clientResponse = webResource.queryParams(formData).header("FDP-Lens-App-Name","FlipQuery").header("FDP-Lens-Api-Key","ce5234ac-a24b-4fe4-8679-2ebac0ec941c").post(ClientResponse.class);
        String resp = clientResponse.getEntity(String.class);
        return resp;
    }

}
