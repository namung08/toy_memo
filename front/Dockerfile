# 1단계: 빌드 환경 설정
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app
COPY . .

# Gradle Wrapper를 사용하는 경우
RUN ./gradlew clean build -x test --no-daemon

# 2단계: 실행 환경 설정
FROM eclipse-temurin:17-jre
WORKDIR /app

# 빌드된 jar 파일 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 포트 오픈
EXPOSE 8080

# 앱 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
