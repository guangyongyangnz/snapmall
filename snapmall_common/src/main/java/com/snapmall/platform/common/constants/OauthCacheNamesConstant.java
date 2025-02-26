package com.snapmall.platform.common.constants;

/**
 * @author chunming.ygy@gmail.com
 * @date 26/02/2025 22:02
 */
public class OauthCacheNamesConstant {

    public static final String OAUTH_PREFIX = "mall4j_oauth:";

    public static final String OAUTH_TOKEN_PREFIX = OAUTH_PREFIX + "token:";

    public static final String ACCESS = OAUTH_TOKEN_PREFIX + "access:";

    public static final String REFRESH_TO_ACCESS = OAUTH_TOKEN_PREFIX + "refresh_to_access:";

    public static final String UID_TO_ACCESS = OAUTH_TOKEN_PREFIX + "uid_to_access:";

    public static final String USER_INFO = OAUTH_TOKEN_PREFIX + "user_info:";

}
