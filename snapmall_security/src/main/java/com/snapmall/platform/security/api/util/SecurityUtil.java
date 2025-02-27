package com.snapmall.platform.security.api.util;

import com.snapmall.platform.common.util.HttpContextUtil;
import com.snapmall.platform.security.api.model.User;
import com.snapmall.platform.security.common.bean.UserInfoInTokenBO;
import com.snapmall.platform.security.common.util.AuthUserContext;

/**
 * @author chunming.ygy@gmail.com
 * @date 25/02/2025 20:57
 */
public class SecurityUtil {
    private static final String USER_REQUEST = "/p";

    public static User getUser() {
        if (!HttpContextUtil.getHttpServletRequest().getRequestURI().startsWith(USER_REQUEST)) {
            throw new RuntimeException("snapmall request error");
        }

        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
        User user = new User();
        if (userInfoInTokenBO == null) {
            return user;
        }

        user.setUserId(userInfoInTokenBO.getUserId());
        user.setUserType(userInfoInTokenBO.getUserType());
        user.setOpenId(userInfoInTokenBO.getOpenId());
        user.setIsEnabled(userInfoInTokenBO.getIsEnabled());
        return user;
    }
}
