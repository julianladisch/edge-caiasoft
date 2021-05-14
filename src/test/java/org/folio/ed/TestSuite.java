package org.folio.ed;

import org.folio.ed.controller.AccessionControllerTest;
import org.folio.ed.security.SecureTenantsProducerTest;
import org.folio.ed.security.TenantAwareAWSParamStoreTest;
import org.folio.ed.service.RemoteStorageServiceTest;
import org.junit.jupiter.api.Nested;

public class TestSuite {

  @Nested
  class AccessionControllerTestNested extends AccessionControllerTest {
  }

  @Nested
  class RemoteStorageServiceTestNested extends RemoteStorageServiceTest {
  }
  @Nested
  class TenantAwareAWSParamStoreTestNested extends TenantAwareAWSParamStoreTest {
  }

  @Nested
  class SecureTenantsProducerTestNested extends SecureTenantsProducerTest {
  }
}
