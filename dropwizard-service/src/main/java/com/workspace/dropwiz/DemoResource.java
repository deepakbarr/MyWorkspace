package com.workspace.dropwiz;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Created by deepak.barr on 19/2/15.
 */

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoResource {

  private Random rand = new Random();
  private String healthString;
  private String helloString;

  public DemoResource(DemoServiceConfiguration conf) {
    this.healthString = conf.getMessage().getHealth();
    this.helloString = conf.getMessage().getHello();

    System.out.println("healthString = " + healthString);
    System.out.println("helloString = " + helloString);
  }

  /**
   * http://localhost:8080/service/hello
   *
   * @return
   */
  @GET
  @Path("hello")
  public Output sayHello() {
    Output out = new Output();
    out.put("message", helloString);
    return out;
  }

  /**
   * http://localhost:8080/service/health
   *
   * @return
   */
  @GET
  @Path("health")
  public Output health() {
    Output out = new Output();
    out.put("health", healthString);
    return out;
  }

  /**
   * http://localhost:8080/service/health
   *
   * @return
   */
  @GET
  @Path("print")
  public Output printText(@QueryParam("text") String text) {
    Output out = new Output();
    out.put("text", text);
    return out;
  }


  //  http://localhost:8080/service/health

  @GET
  @Path("test")
  public String testAPI(@QueryParam("sleep") String sleep) {

    try {

      SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm:ss.SSS");

      final String logFile = "/var/log/request.log";

      File file = new File(logFile);
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write("REQUEST :  received at " + formatter.format(new Date()) + "\n");
      Thread.sleep(Integer.parseInt(sleep));
      String response = "RESPONSE :  sent at " + formatter.format(new Date());
      bw.write(response + "\n");
      bw.close();

      return response;
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR";
    }
  }


  @GET
  @Path("fast")
  public String fastTestAPI() {

    try {
      Thread.sleep(rand.nextInt(70));
      return "OK";
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR";
    }
  }

  @GET
  @Path("slow")
  public String slowTestAPI() {

    try {
      Thread.sleep(rand.nextInt(300) + 100);
      return "OK";
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR";
    }
  }

  @GET
  @Path("getjson")
  public TestBean getJson() {
    TestBean tb = new TestBean();
    tb.setF1("AAAA");
    tb.setF2(Arrays.asList(new String[]{"1","2"}));
    tb.setF3("CCCC");
    return tb;
  }

  @POST
  @Path("postjson")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public TestBean postJson(TestBean tb) {
    return tb;
  }
}


