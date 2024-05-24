package propertysys.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTUtils {
    /**
     * 生成token  header.payload.singature
     */

    // TODO:JWT密钥不能硬编码 (application.yml中)
    private static String SING;


    private static Integer expireTime;


    public void setSING(String SING) {
        JWTUtils.SING = SING;
    }

    public void setExpireTime(Integer expireTime) {
        JWTUtils.expireTime = expireTime;
    }

    public static String getToken(String userId, String email) {

        Calendar instance = Calendar.getInstance();
        // 单位分钟
        instance.add(Calendar.MINUTE, expireTime);

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        // payload
        Map<String, String> payload = new HashMap<>();
        payload.put("id",userId);
        payload.put("email",email);
        payload.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(instance.getTime())  //指定令牌过期时间
                .sign(Algorithm.HMAC256(SING));  // sign
        return token;
    }
    /**
     * 验证token  合法性
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

}
