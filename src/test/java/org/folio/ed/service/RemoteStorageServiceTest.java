package org.folio.ed.service;

import org.folio.ed.client.RemoteStorageClient;
import org.folio.ed.domain.dto.AccessionItem;
import org.folio.ed.domain.dto.AccessionRequest;
import org.folio.ed.domain.dto.ResultList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RemoteStorageServiceTest {

  @Mock
  private RemoteStorageClient remoteStorageClient;

  @InjectMocks
  private RemoteStorageService remoteStorageService;

  @Test
  void testGetAccessionItem() {
    var result = new ResultList<AccessionItem>();
    var accessionItem = new AccessionItem();
    accessionItem.setId("accession_id");
    result.setResult(Collections.singletonList(accessionItem));

    when(remoteStorageClient.getAccessionItem(isA(AccessionRequest.class), isA(String.class), isA(String.class)))
      .thenReturn(result);

    remoteStorageService.getAccessionItem("itemBarcode", "remoteStorageConfigurationId", "xOkapiTenant", "xOkapiToken");
    verify(remoteStorageClient, times(1)).getAccessionItem(isA(AccessionRequest.class), isA(String.class), isA(String.class));
  }
}
