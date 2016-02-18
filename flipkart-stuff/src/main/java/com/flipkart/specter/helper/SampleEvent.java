package com.flipkart.specter.helper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.seraph.schema.BaseSchema;

/**
 * Created by deepak.barr on 28/12/15.
 */


public class SampleEvent extends BaseSchema {

  @JsonProperty("eventData")
  private String eventData;

  @JsonIgnore
  private String schemaVersion = TestConstants.testSchemaVersion;

  public SampleEvent() {
    eventData = TestConstants.testEventDataString;
  }

  public String getEventData() {
    return eventData;
  }

  public void setEventData(String eventData) {
    this.eventData = eventData;
  }

  @Override
  public void validate() throws Exception {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public String getSchemaVersion() {
    return schemaVersion;  //To change body of implemented methods use File | Settings | File Templates.
  }
}

class TestConstants {

  public final static String testSchemaVersion = "2.3";

  public final static String testEventId = "f7917a55-3580-4304-849c-ee8ea55431f0";

  public final static long testEventTimeEpoch = 1423744933525l;

  public final static String testEventTime = "2015-02-12T18:12:13+05:30";

  public final static String testEventDataString = "some random sample data";

  public final static boolean test = false;
}


