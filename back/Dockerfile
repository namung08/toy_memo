FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

# 프론트엔드 빌드 결과 복사
COPY --from=memo-frontend_builder /app/dist /app/static

# Spring Boot 정적 파일 경로 설정 (application.yml에 추가 필요)
# environment:
#   SPRING_WEB_RESOURCES_STATIC_LOCATIONS: "classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/,file:/app/static/"

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
