package org.folio.ed.security;

import org.apache.commons.lang3.StringUtils;
import org.folio.edge.api.utils.security.AwsParamStore;
import org.folio.edge.api.utils.security.EphemeralStore;
import org.folio.edge.api.utils.security.VaultStore;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaiaSoftSecureStoreFactoryTest {

  @Test
  void testGetSecureStore() {
    var properties = new Properties();
    properties.put(AwsParamStore.PROP_REGION, "us-east-1");
    var secureStore = CaiaSoftSecureStoreFactory.getSecureStore(AwsParamStore.TYPE, properties);
    assertTrue(secureStore instanceof TenantAwareAWSParamStore);
    secureStore = CaiaSoftSecureStoreFactory.getSecureStore(EphemeralStore.TYPE, properties);
    assertTrue(secureStore instanceof EphemeralStore);
    secureStore = CaiaSoftSecureStoreFactory.getSecureStore(VaultStore.TYPE, properties);
    assertTrue(secureStore instanceof VaultStore);
    secureStore = CaiaSoftSecureStoreFactory.getSecureStore(null, properties);
    assertTrue(secureStore instanceof EphemeralStore);
    secureStore = CaiaSoftSecureStoreFactory.getSecureStore(StringUtils.EMPTY, properties);
    assertTrue(secureStore instanceof EphemeralStore);
  }
}
