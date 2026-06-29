package com.example.projeto_calculadora.config;

import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Registra manualmente o console web do H2.
 *
 * Quando o JSF (JoinFaces) esta no projeto, a auto-configuracao do Spring Boot
 * que normalmente publica o console do H2 em /h2-console nao e ativada,
 * resultando em erro 404. Esta classe registra o servlet do console
 * diretamente, garantindo que /h2-console funcione.
 *
 * Acesse em: http://localhost:8080/h2-console
 *   JDBC URL: jdbc:h2:mem:obradb | Usuario: sa | Senha: (vazia)
 */
@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<JakartaWebServlet> h2ConsoleServlet() {
        ServletRegistrationBean<JakartaWebServlet> registration =
                new ServletRegistrationBean<>(new JakartaWebServlet(), "/h2-console/*");
        registration.setLoadOnStartup(1);
        // Permite abrir conexoes a partir de outras maquinas, se necessario
        registration.addInitParameter("webAllowOthers", "true");
        return registration;
    }
}
