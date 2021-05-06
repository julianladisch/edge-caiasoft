package org.folio.ed.client;

import org.folio.ed.domain.dto.AccessionItem;
import org.folio.ed.domain.dto.AccessionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static org.folio.spring.integration.XOkapiHeaders.TENANT;
import static org.folio.spring.integration.XOkapiHeaders.TOKEN;

@FeignClient(value = "remote-storage")
public interface RemoteStorageClient {

  @PostMapping(path = "/accessions", produces = "application/json")
  AccessionItem getAccessionItem (AccessionRequest accessionRequest, @RequestHeader(TENANT) String tenantId,
                                              @RequestHeader(TOKEN) String okapiToken);
}
