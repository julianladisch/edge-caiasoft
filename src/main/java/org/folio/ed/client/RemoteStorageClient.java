package org.folio.ed.client;

import org.folio.ed.domain.dto.AccessionItem;
import org.folio.ed.domain.dto.AccessionRequest;
import org.folio.ed.domain.dto.CheckInRequest;
import org.folio.ed.domain.dto.Configuration;
import org.folio.ed.domain.dto.ResultList;
import org.folio.ed.domain.dto.RetrievalQueueRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import static org.folio.spring.integration.XOkapiHeaders.TENANT;
import static org.folio.spring.integration.XOkapiHeaders.TOKEN;

@FeignClient(value = "remote-storage")
public interface RemoteStorageClient {

  @PostMapping(path = "/accessions", produces = "application/json")
  AccessionItem getAccessionItem (AccessionRequest accessionRequest, @RequestHeader(TENANT) String tenantId,
                                              @RequestHeader(TOKEN) String okapiToken);

  @PostMapping(path = "/retrieve/{remoteConfigurationId}/checkInItemByHoldId", produces = "application/json")
  ResponseEntity<String> checkInByHoldId (@PathVariable("remoteConfigurationId") String configurationId,
                                          CheckInRequest checkInRequest, @RequestHeader(TENANT) String tenantId,
                                          @RequestHeader(TOKEN) String okapiToken);
  @GetMapping("/configurations")
  ResultList<Configuration> getStorageConfigurations(@RequestHeader(TENANT) String tenantId,
                                                     @RequestHeader(TOKEN) String okapiToken);

  @GetMapping(path = "/retrievals", produces = "application/json")
  ResultList<RetrievalQueueRecord> getRetrievalsByQuery(@RequestParam("storageId") String storageId,
                                                        @RequestParam("retrieved") Boolean retrieved, @RequestParam("limit") int limit, @RequestHeader(TENANT) String tenantId,
                                                        @RequestHeader(TOKEN) String okapiToken);
  @PutMapping("/retrievals/barcode/{barcode}")
  ResponseEntity<String> setRetrievalByBarcode(@PathVariable("barcode") String barcode, @RequestHeader(TENANT) String tenantId,
                                               @RequestHeader(TOKEN) String okapiToken);
}
