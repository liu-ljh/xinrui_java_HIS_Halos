import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;

public class TokenGenerator {

    // 确保这个密钥与系统配置一致
    private static final String SECRET_KEY = "XinruiSecretKeyForHS256AlgorithmMustBeAtLeast32Bytes!";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public static String generateTestToken() {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date exp = new Date(nowMillis + 3600000); // 1小时后过期

        Map<String, Object> claims = new HashMap<>();
        claims.put("tenant_id", "000000"); // 确保与系统中的租户ID一致
        claims.put("user_id", "1");        // 确保与系统中的用户ID一致

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static void main(String[] args) {
        String token = generateTestToken();
        System.out.println("Token: " + token);
        System.out.println("Authorization Header: Bearer " + token);

        // 验证token
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println("验证成功:");
            System.out.println("Tenant ID: " + claims.get("tenant_id"));
            System.out.println("User ID: " + claims.get("user_id"));
        } catch (Exception e) {
            System.out.println("Token验证失败: " + e.getMessage());
        }
    }
}
