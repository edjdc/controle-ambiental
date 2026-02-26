# Dependency Audit Report

## 1. Summary
- **Project type:** Java/Spring microservices monorepo (7 Maven services): `api-gateway`, `eureka-server`, `oauth2-server`, `ativos-service`, `monitoramento-service`, `config-server`, `seguranca-service`.
- **Dependency files found:** 7 `pom.xml` files; no Node/Python/Go manifests.
- **Direct dependencies audited:** 38 unique Maven dependencies (direct only, transitives ignored).
- **Main findings:**
  - Multiple **known CVEs** in direct dependencies (`commons-io`, `h2`, `postgresql`, `nimbus-jose-jwt`).
  - Legacy stack components in active use: `spring-security-oauth2-autoconfigure`, `spring-cloud-starter-netflix-zuul`, `spring-cloud-starter-netflix-hystrix`, `spring-cloud-starter-oauth2`, `springfox`.
  - Several dependencies are **unmaintained >1 year** by Maven Central metadata timestamps.
  - No lockfile mechanism in repo (standard Maven), which increases reproducibility/supply-chain drift risk.

## 2. Critical Issues
- **CVE exposure (direct dependencies):**
  - `com.h2database:h2:1.4.199` includes critical advisories (e.g., `CVE-2022-23221`, `CVE-2021-42392`).
  - `org.postgresql:postgresql:42.2.5` includes critical/high advisories (e.g., `CVE-2024-1597`, `CVE-2022-31197`, `CVE-2022-21724`).
  - `com.nimbusds:nimbus-jose-jwt:7.4` includes critical/high/moderate advisories (`CVE-2019-17195`, `CVE-2023-52428`, `CVE-2025-53864`).
  - `commons-io:commons-io:2.6` includes `CVE-2024-47554` and `CVE-2021-29425`.
- **Deprecated/legacy core dependencies:**
  - `spring-security-oauth2-autoconfigure` is from Spring Security OAuth, which reached EOL on **June 1, 2022**.
  - Spring Cloud Netflix components including Zuul/Hystrix were put into maintenance mode (announced **December 12, 2018**).
- **Single points of failure with risky dependencies:**
  - `api-gateway` depends on Zuul (`@EnableZuulProxy`) as ingress chokepoint.
  - `oauth2-server` centralizes token issuance/validation using legacy OAuth2 stack and vulnerable JOSE library.
  - Resource-server OAuth2 configuration is replicated across multiple services.

## 3. Dependencies

| Dependency | Current Version | Latest Version (Stable) | Status |
| ---------- | --------------- | ----------------------- | ------ |
| org.springframework.boot:spring-boot-starter-web | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-starter-security | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-starter-data-jpa | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-starter-jdbc | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-starter-actuator | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-actuator | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-devtools | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-starter-test | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.boot:spring-boot-configuration-processor | 2.1.5.RELEASE | 4.0.3 | Outdated |
| org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure | 2.1.2.RELEASE | 2.6.8 | **Legacy (EOL)** |
| org.springframework.cloud:spring-cloud-starter-config | 2.1.1.RELEASE | 5.0.1 | Outdated |
| org.springframework.cloud:spring-cloud-config-server | 2.1.1.RELEASE | 5.0.1 | Outdated |
| org.springframework.cloud:spring-cloud-starter-netflix-eureka-client | 2.1.1.RELEASE | 5.0.1 | Outdated |
| org.springframework.cloud:spring-cloud-starter-netflix-eureka-server | 2.1.1.RELEASE | 5.0.1 | Outdated |
| org.springframework.cloud:spring-cloud-starter-openfeign | 2.1.1.RELEASE | 5.0.1 | Outdated |
| org.springframework.cloud:spring-cloud-starter-netflix-hystrix | 2.1.1.RELEASE | 2.2.10.RELEASE | **Legacy (Maintenance mode)** |
| org.springframework.cloud:spring-cloud-starter-netflix-zuul | 2.1.1.RELEASE | 2.2.10.RELEASE | **Legacy (Maintenance mode)** |
| org.springframework.cloud:spring-cloud-starter-oauth2 | 2.1.2.RELEASE | 2.2.5.RELEASE | **Legacy (Unmaintained)** |
| commons-io:commons-io | 2.6 | 2.21.0 | **Outdated + Vulnerable** |
| io.springfox:springfox-swagger2 | 2.9.2 | 3.0.0 | **Legacy (Unmaintained)** |
| io.springfox:springfox-swagger-ui | 2.9.2 | 3.0.0 | **Legacy (Unmaintained)** |
| com.nimbusds:nimbus-jose-jwt | 7.4 | 10.8 | **Outdated + Vulnerable** |
| org.postgresql:postgresql | 42.2.5 | 42.7.10 | **Outdated + Vulnerable** |
| org.flywaydb:flyway-core | 5.2.4 | 12.0.2 | Outdated |
| org.projectlombok:lombok | 1.18.8 | 1.18.42 | Outdated |
| org.mapstruct:mapstruct | 1.3.0.Final | 1.6.3 | Outdated |
| com.querydsl:querydsl-core | 4.2.1 | 5.1.0 | Outdated |
| com.querydsl:querydsl-jpa | 4.2.1 | 5.1.0 | Outdated |
| com.querydsl:querydsl-apt | 4.2.1 | 5.1.0 | Outdated |
| com.h2database:h2 | 1.4.199 | 2.4.240 | **Outdated + Vulnerable** |
| org.apache.httpcomponents:httpclient | 4.5.8 | 4.5.14 | Outdated |
| io.cucumber:cucumber-java8 | 4.2.0 | 7.34.2 | Outdated |
| io.cucumber:cucumber-core | 4.2.0 | 7.34.2 | Outdated |
| io.cucumber:cucumber-junit | 4.2.0 | 7.34.2 | Outdated |
| io.cucumber:cucumber-spring | 4.2.0 | 7.34.2 | Outdated |
| org.springframework.data:spring-data-envers | 2.1.8.RELEASE | 4.0.3 | Outdated |
| org.springframework.security:spring-security-test | 5.1.5.RELEASE | 7.0.3 | Outdated |
| org.glassfish.jaxb:jaxb-runtime | 2.3.1 | 4.0.6 | Outdated |

## 4. Risk Analysis

| Severity | Dependency | Issue | Details |
| -------- | ---------- | ----- | ------- |
| Critical | com.h2database:h2 | CVE-2022-23221 | Arbitrary code execution in H2 Console (GHSA-45hx-wfhj-473x). |
| Critical | com.h2database:h2 | CVE-2021-42392 | RCE in H2 Console (GHSA-h376-j262-vhq6). |
| Critical | org.postgresql:postgresql | CVE-2024-1597 | SQL injection advisory affecting older pgjdbc lines (GHSA-24rp-q3w6-vc56). |
| Critical | com.nimbusds:nimbus-jose-jwt | CVE-2019-17195 | Critical improper exceptional-condition handling (GHSA-f6vf-pq8c-69m4). |
| High | com.nimbusds:nimbus-jose-jwt | CVE-2023-52428 | DoS vulnerability (GHSA-gvpg-vgmx-xg6w). |
| High | org.postgresql:postgresql | CVE-2022-31197 | SQL injection risk in `ResultSet.refreshRow()` path (GHSA-r38f-c4h4-hqq2). |
| High | commons-io:commons-io | CVE-2024-47554 | DoS on untrusted XML input handling (GHSA-78wr-2p64-hpwj). |
| High | org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure | Deprecated/EOL | Spring Security OAuth EOL on June 1, 2022; no long-term maintenance. |
| High | spring-cloud-starter-netflix-zuul / hystrix | Maintenance mode | Spring Cloud Netflix modules announced in maintenance mode; aging edge/security surface. |
| Medium | commons-io:commons-io | CVE-2021-29425 | Path traversal/input validation issue (GHSA-gwrp-pvrq-jmwv). |
| Medium | com.nimbusds:nimbus-jose-jwt | CVE-2025-53864 | DoS on deeply nested JSON (GHSA-xwmg-2g98-w7v9). |
| Medium | io.springfox:springfox-* | Unmaintained | Latest release stream stale since 2020 (Maven metadata timestamps). |
| Medium | com.querydsl:querydsl-* | Unmaintained >1 year | Latest stable line age exceeds 1 year (metadata indicates 2024 updates). |
| Low | com.h2database:h2 / org.glassfish.jaxb:jaxb-runtime | License/legal nuance | Dual-license obligations (MPL/EPL or EPL/EDL) require compliance checks in distribution flows. |

## 5. Unverified Dependencies
| Dependency | Current Version | Reason Not Verified |
| ----------- | --------------- | ------------------- |
| org.springframework.boot:spring-boot-starter-* | 2.1.5.RELEASE | Advisory attribution at starter coordinate level is indirect (most CVEs land on transitives). |
| org.springframework.cloud:spring-cloud-starter-* | 2.1.1/2.1.2.RELEASE | Same starter/BOM indirection; component-level vulnerability mapping requires transitive resolution. |
| org.mapstruct:mapstruct | 1.3.0.Final | License not declared directly in module POM (inherited metadata path). |
| com.querydsl:querydsl-core | 4.2.1 | License not declared directly in module POM (inherited metadata path). |
| org.flywaydb:flyway-core | 5.2.4 | License metadata not explicit in artifact POM used for this audit pass. |
| org.apache.httpcomponents:httpclient | 4.5.8 | CVE sources differ across databases for exact affected sub-ranges in 4.x line. |

## 6. Critical File Analysis (Top 10)

| File (relative path) | Risky Dependency Concentration | Why Critical |
| --- | --- | --- |
| `oauth2-server/src/main/java/com/github/edjdc/oauthserver/config/security/AuthorizationServerConfiguration.java` | Legacy OAuth2 + Nimbus JWT | Core token issuance/signing; compromise impacts all authenticated services. |
| `oauth2-server/src/main/java/com/github/edjdc/oauthserver/config/security/jwt/JwtCustomHeadersAccessTokenConverter.java` | Nimbus JWT | Handles JWT encoding path directly; vulnerable parser/signing behavior is high-impact here. |
| `oauth2-server/src/main/java/com/github/edjdc/oauthserver/config/security/ResourceServerConfiguration.java` | Legacy OAuth2 resource-server config | Central auth boundary for oauth service endpoints. |
| `api-gateway/src/main/java/com/github/edjdc/apigateway/ApiGatewayApplication.java` | Zuul (maintenance mode) | Single ingress point with legacy gateway stack; outage/exploit has platform-wide blast radius. |
| `api-gateway/src/main/java/com/github/edjdc/apigateway/config/ResourceServerConfiguration.java` | Legacy OAuth2 resource-server | Edge auth policy at gateway level affects all routed traffic. |
| `seguranca-service/src/main/java/com/github/edjdc/seguranca/config/FeignConfig.java` | Legacy OAuth2 Feign interceptor | Service-to-service auth token propagation; failure breaks downstream integrations. |
| `seguranca-service/src/main/java/com/github/edjdc/seguranca/repository/RegistroBarragemClientFallbackFactory.java` | Hystrix fallback (maintenance mode) | Circuit-breaker fallback behavior for cross-service calls; reliability and incident behavior concentrated here. |
| `seguranca-service/src/main/java/com/github/edjdc/seguranca/config/Swagger2Config.java` | Springfox (unmaintained) | API documentation/security scheme exposure for security service endpoints. |
| `monitoramento-service/src/main/java/com/github/edjdc/monitoramento/config/Swagger2Config.java` | Springfox (unmaintained) | Documentation/security exposure in monitoring APIs. |
| `ativos-service/src/main/java/com/github/edjdc/ativos/config/Swagger2Config.java` | Springfox (unmaintained) | Documentation/security exposure in assets APIs. |

## 7. Integration Notes
- **Core platform:** all services are on Spring Boot `2.1.5.RELEASE` parent + Spring Cloud `Greenwich.SR1`.
- **Service discovery/config coupling:** Config Server + Eureka clients are used broadly, increasing shared-failure risk.
- **Auth coupling:** Legacy OAuth2 resource-server annotations are present in multiple services; auth-server is a central dependency.
- **Gateway coupling:** Zuul gateway is a single system integration choke point.
- **Inter-service calls:** `seguranca-service` uses Feign + Hystrix fallback for calls to `monitoramento-service`.
- **Data layer:** PostgreSQL + JPA + Flyway + QueryDSL used in business services; vulnerable JDBC version is directly declared via BOM-managed runtime.
- **Docs layer:** Springfox is configured in 3 services, multiplying legacy surface area.
- **Testing/runtime deps:** H2 and Cucumber versions are substantially behind current stable lines.

## 8. Action Plan
1. Prioritize remediation of direct CVE-bearing dependencies currently used in auth/token and database paths (`nimbus-jose-jwt`, `postgresql`, `h2`, `commons-io`).
2. Decommission legacy auth/gateway stack components with explicit EOL/maintenance status (`spring-security-oauth2-autoconfigure`, Zuul, Hystrix, Spring Cloud OAuth2 starter).
3. Replace unmaintained documentation stack (`springfox`) with a maintained OpenAPI toolchain to reduce long-lived exposure.
4. Standardize a modern Spring baseline across all services to reduce dependency drift and remove release-train fragmentation.
5. Add dependency governance controls: automated SBOM generation, continuous CVE/license scanning, and policy gates for unmaintained packages.
6. Validate license obligations for dual-license components (`h2`, `jaxb-runtime`) and inherited-license artifacts before redistribution.

## 9. Final Step
Do you want me to save this report to a file? If so, please provide the path and file name.

### Sources
- Spring Security OAuth EOL announcement: https://spring.io/blog/2022/06/01/spring-security-oauth-reaches-end-of-life
- Spring Cloud Netflix maintenance mode announcement: https://spring.io/blog/2018/12/12/spring-cloud-greenwich-rc1-available-now
- Netflix Hystrix maintenance mode context: https://github.com/Netflix/Hystrix#hystrix-status
- Springfox release history: https://github.com/springfox/springfox/releases
- Spring Boot BOM used for current-version resolution: https://repo.maven.apache.org/maven2/org/springframework/boot/spring-boot-dependencies/2.1.5.RELEASE/spring-boot-dependencies-2.1.5.RELEASE.pom
- Spring Cloud Greenwich BOM used for current-version resolution: https://repo.maven.apache.org/maven2/org/springframework/cloud/spring-cloud-dependencies/Greenwich.SR1/spring-cloud-dependencies-Greenwich.SR1.pom
- Maven metadata (latest-version and last-updated checks):
  https://repo.maven.apache.org/maven2/commons-io/commons-io/maven-metadata.xml
  https://repo.maven.apache.org/maven2/com/nimbusds/nimbus-jose-jwt/maven-metadata.xml
  https://repo.maven.apache.org/maven2/org/postgresql/postgresql/maven-metadata.xml
  https://repo.maven.apache.org/maven2/com/h2database/h2/maven-metadata.xml
  https://repo.maven.apache.org/maven2/io/springfox/springfox-swagger2/maven-metadata.xml
  https://repo.maven.apache.org/maven2/org/springframework/cloud/spring-cloud-starter-netflix-zuul/maven-metadata.xml
  https://repo.maven.apache.org/maven2/org/springframework/cloud/spring-cloud-starter-netflix-hystrix/maven-metadata.xml
- OSV/GHSA vulnerability records used for CVE mapping and severity:
  https://osv.dev/vulnerability/GHSA-gwrp-pvrq-jmwv
  https://osv.dev/vulnerability/GHSA-78wr-2p64-hpwj
  https://osv.dev/vulnerability/GHSA-h376-j262-vhq6
  https://osv.dev/vulnerability/GHSA-45hx-wfhj-473x
  https://osv.dev/vulnerability/GHSA-v7wg-cpwc-24m4
  https://osv.dev/vulnerability/GHSA-24rp-q3w6-vc56
  https://osv.dev/vulnerability/GHSA-r38f-c4h4-hqq2
  https://osv.dev/vulnerability/GHSA-f6vf-pq8c-69m4
  https://osv.dev/vulnerability/GHSA-gvpg-vgmx-xg6w
  https://osv.dev/vulnerability/GHSA-xwmg-2g98-w7v9
