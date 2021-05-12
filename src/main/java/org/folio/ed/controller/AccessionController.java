package org.folio.ed.controller;


import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.folio.ed.domain.dto.AccessionItem;
import org.folio.ed.rest.resource.ItemBarcodesApi;
import org.folio.ed.service.RemoteStorageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/caiasoftService/")
public class AccessionController implements ItemBarcodesApi {

  private final RemoteStorageService remoteStorageService;

  @Override
  public ResponseEntity<AccessionItem> getAccessionItem(
      @ApiParam(required = true) @PathVariable("itemBarcode") String itemBarcode,
      @ApiParam(required = true) @PathVariable("remoteStorageConfigurationId") String remoteStorageConfigurationId,
      @ApiParam(required = true) @RequestHeader(value = "x-okapi-token") String xOkapiToken,
      @ApiParam(required = true) @RequestHeader(value = "x-okapi-tenant") String xOkapiTenant) {

    var headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    var accessionItem = remoteStorageService.getAccessionItem(itemBarcode, remoteStorageConfigurationId, xOkapiTenant, xOkapiToken);
    return new ResponseEntity<>(accessionItem, headers, HttpStatus.OK);
  }
}
