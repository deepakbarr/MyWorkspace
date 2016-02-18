package fkint.bigfoot.dg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.seraph.schema.BaseSchema;

/**
 * Created by deepak.barr on 28/12/15.
 */

public class cosmos_audit_event extends BaseSchema {
  @JsonProperty("id")
  private String id="id";
  @JsonProperty("source_type")
  private String source_type="source_type";
  @JsonProperty("source_name")
  private String source_name="source_name";
  @JsonProperty("start_time_ms")
  private Long start_time_ms=System.currentTimeMillis();
  @JsonIgnore
  private String schemaVersion="1.0";

  @Override
  public void validate() throws Exception {
  }

  @Override
  public String getSchemaVersion() {
    return schemaVersion;
  }
}
