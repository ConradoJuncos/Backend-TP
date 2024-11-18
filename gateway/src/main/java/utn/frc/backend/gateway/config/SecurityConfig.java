package utn.frc.backend.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
public class SecurityConfig {

    // Las rutas específicas tienen prioridad sobre las generales
    // /api/notificaciones/nueva se evalua antes que /api/notificaciones, entonces un empleado puede
    //   crear una nueva notificacion sin ser admin

//    Obtencion de un token con Postman:
//    POST a https://labsys.frc.utn.edu.ar/aim/realms/backend-tps/protocol/openid-connect/token
//    Token Name: tokenName
//    Grant Type: Password Credentials
//    Access Token URL: https://labsys.frc.utn.edu.ar/aim/realms/backend-tps/protocol/openid-connect/token
//    Client ID: cliente-tpi
//    Client Sectet: ZmiMMce6zh4xKHde1FFKbfkiThDyYpyn
//    Username: g148-A
//    Password: g148-B-backend
//    Client Authentication: Send as basic auth header
//    Despues hago la request con Bearer Token = el token que consigo


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(authorize -> authorize

                        // Rutas específicas para Empleado
                        .matchers(ServerWebExchangeMatchers.pathMatchers("/api/pruebas/crear")).hasRole("Empleado")
                        .matchers(ServerWebExchangeMatchers.pathMatchers("/api/notificaciones/crear")).hasRole("Empleado")

                        // Rutas específicas para Vehiculo
                        .matchers(ServerWebExchangeMatchers.pathMatchers("/api/posiciones/nueva")).hasRole("Vehiculo")

                        // Rutas específicas para Admin
                        .matchers(ServerWebExchangeMatchers.pathMatchers("/api/notificaciones")).hasRole("Admin")
                        .matchers(ServerWebExchangeMatchers.pathMatchers("/api/notificaciones/empleado/{idEmpleado}")).hasRole("Admin")
                        .matchers(ServerWebExchangeMatchers.pathMatchers("/api/pruebas/vehiculo/{idVehiculo}")).hasRole("Admin")

                        // Rutas protegidas por defecto
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }

    // Configura la extracción de roles desde el token JWT
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthoritiesClaimName("realm_access.roles");
        grantedAuthoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return authenticationConverter;
    }
}
