package org.folio.ed.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CaiaSoftRequestItem {
  private String barcode;
  @JsonProperty("request_type")
  private String requestType;
  @JsonProperty("request_id")
  private String requestId;
}
