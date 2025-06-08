package multi_threading;

// This is an implementation of ThreadLocal

import java.util.HashMap;
import java.util.Map;

public class TenantContextHolder {
    private static final Map<String, String> contextMap = new HashMap<>();

    public static String getCurrentTenantId(String threadId) {
        return contextMap.getOrDefault(threadId, "");
    }

    public static void setCurrentTenantId(String threadId, String tenantId) {
        contextMap.put(threadId, tenantId);
    }
}
