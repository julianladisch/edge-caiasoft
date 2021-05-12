package org.folio.ed.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessionRequest {
  private String remoteStorageId;
  private String itemBarcode;
}
