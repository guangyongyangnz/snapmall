package com.snapmall.platform.security.common.util;

import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

/**
 * @author chunming.ygy@gmail.com
 * @date 25/02/2025 21:50
 */
public class PermissionUtil {
    public static boolean hasPermission(String permission) {
        if (!StringUtils.hasText(permission)) {
            return false;
        }

        return AuthUserContext.get().getPerms().stream().filter(StringUtils::hasText)
            .anyMatch(x -> PatternMatchUtils.simpleMatch(permission, x));
    }
}
