package com.miniprogram.www.util;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.Claim;
import com.miniprogram.www.entity.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    /** token秘钥 backups:JKKLJOoasdlfj */
    public static final String SECRET = "JKKLJOoasdlfj";
    /** token 过期时间: 7天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 7;

    public static String createWxToken(Student student) {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        String token = JWT.create()
                .withClaim("id", student.getId()) // payload
                .withClaim("openid", student.getOpenid())
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature

        return token;
    }

    public static Map<String, Claim> verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        if (jwt == null) throw new RuntimeException("token验证异常！");
        return jwt.getClaims();
    }

    public static int getUserId(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim user_id_claim = claims.get("id");

        if (user_id_claim == null) {
            throw new RuntimeException("id不能为空！");
        }
        return Integer.valueOf(user_id_claim.asInt());
    }
}
