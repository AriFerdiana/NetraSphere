package com.smartwaste.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Konfigurasi Springdoc OpenAPI (Swagger UI).
 *
 * <p>Menghasilkan dokumentasi API interaktif yang bisa diakses di
 * {@code http://localhost:8080/swagger-ui.html}. Mendukung autentikasi JWT
 * langsung dari Swagger UI (klik tombol "Authorize" dan masukkan token).</p>
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI smartWasteOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Smart Community Waste System API")
                .description("""
                    **Backend REST API** untuk Sistem Pengelolaan Sampah Komunitas Cerdas.
                    
                    ## Fitur Utama:
                    - 🔐 **RBAC** — Role-Based Access Control (Admin, Citizen, Collector)
                    - 🎮 **Green Wallet** — Gamifikasi poin berbasis setoran sampah
                    - 🤖 **IoT Ready** — Endpoint `/api/v1/iot/dump` untuk robot NetraDUMP
                    - 🧠 **AI Chatbot** — Integrasi Mistral AI untuk panduan daur ulang
                    
                    ## Cara Pakai:
                    1. Login via `POST /api/v1/auth/login`
                    2. Copy token dari response
                    3. Klik tombol **Authorize** dan paste token
                    """)
                .version("1.0.0")
                .contact(new Contact()
                    .name("Trinetra — Tubes PBO")
                    .email("trinetra@smartwaste.com"))
                .license(new License()
                    .name("MIT License"))
            )
            .servers(List.of(
                new Server().url("http://localhost:8080").description("Local Development"),
                new Server().url("https://api-sampah.trinetra.com").description("Production (Cloudflare Tunnel)")
            ))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new Components()
                .addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                        .name("bearerAuth")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("Masukkan JWT token yang didapat dari endpoint /api/v1/auth/login")
                )
            );
    }
}
