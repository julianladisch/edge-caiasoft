package org.folio.ed.security;

import org.folio.edge.api.utils.security.AwsParamStore;
import org.folio.edge.api.utils.security.SecureStore;
import org.folio.edge.api.utils.security.SecureStoreFactory;

import java.util.Properties;

public class CaiaSoftSecureStoreFactory {

  public static SecureStore getSecureStore(String secureStoreType, Properties secureStoreProps) {
    if (AwsParamStore.TYPE.equals(secureStoreType)) {
      return new TenantAwareAWSParamStore(secureStoreProps);
    }
    return SecureStoreFactory.getSecureStore(secureStoreType, secureStoreProps);
  }
}
