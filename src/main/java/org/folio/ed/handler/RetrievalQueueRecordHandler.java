package org.folio.ed.handler;

import lombok.RequiredArgsConstructor;
import org.folio.ed.domain.dto.Configuration;
import org.folio.ed.domain.dto.RetrievalQueueRecord;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RetrievalQueueRecordHandler {

  public Object handle(RetrievalQueueRecord record, Configuration configuration) {
    return null;
  }
}
