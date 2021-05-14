package org.folio.ed.service;

import lombok.RequiredArgsConstructor;
import org.folio.ed.domain.dto.Configuration;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaiaSoftIntegrationService {

  private final IntegrationFlowContext integrationFlowContext;
  private final CaiaSoftSecurityManagerService sms;
  private final RemoteStorageService remoteStorageService;

  @Scheduled(fixedDelayString = "${configurations.update.timeframe}")
  public void updateIntegrationFlows() {
    removeExistingFlows();
    var tenantsUsersMap = sms.getCaiaSoftTenantsUserMap();
    for (String tenantId : tenantsUsersMap.keySet()) {
      for (Configuration configuration : remoteStorageService.getCaiaSoftConfigurations(tenantId, sms.getConnectionParameters(tenantId).getOkapiToken())) {
        createFlows(configuration);
      }
    }
  }

  private void createFlows(Configuration configuration) {
  }

  public void removeExistingFlows() {
    integrationFlowContext.getRegistry().keySet().forEach(key -> {
      integrationFlowContext.getRegistrationById(key).stop();
      integrationFlowContext.remove(key);
    });
  }
}
