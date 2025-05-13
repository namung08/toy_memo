# 📝 Memo Web Application

Spring Boot + React (Vite + TypeScript) 기반의 간단한 메모 웹 애플리케이션입니다. MariaDB를 사용하며, Docker를 통해 로컬 환경에서 손쉽게 실행할 수 있습니다.

---

## 🗂 프로젝트 구조

```
memo/
├── back/        # Spring Boot 백엔드 (Gradle)
├── front/       # Vite + React + TypeScript 프론트엔드
├── docker-compose.db.yml  # DB만 실행할 때 사용하는 Docker Compose
└── docker-compose.full.yml  # 전체 시스템(DB + 백 + 프론트) 실행용 Docker Compose
```

---

## 🚀 실행 방법

### 1️⃣ **DB만 실행 (docker-compose.db.yml)**

DB만 실행하려면 아래 명령어를 사용하세요:

```bash
docker-compose -f docker-compose.db.yml up -d
```

* **MariaDB에 로컬에서 접속 시**:

    * Host: `localhost`
    * Port: `3306`
    * User: `memo_user`
    * Password: `memo_pass`
    * Database: `memo_db`

DB만 실행하는 경우, 다른 서비스들은 별도로 실행할 필요가 없습니다.

### 2️⃣ **전체 서비스 실행 (docker-compose.full.yml)**

전체 시스템(DB + 백엔드 + 프론트엔드)을 실행하려면 아래 명령어를 사용하세요:

```bash
docker-compose -f docker-compose.full.yml up --build
```

* **백엔드**: [http://localhost:8080](http://localhost:8080)
* **프론트엔드**: [http://localhost:3000](http://localhost:3000)

이 명령어는 DB, 백엔드, 프론트엔드를 모두 실행합니다.

---

## ⚙ 환경 변수

`application.yml` 혹은 Docker 환경 변수로 다음이 설정됩니다:

```yaml
spring.datasource.url=jdbc:mariadb://db:3306/memo_db
spring.datasource.username=memo_user
spring.datasource.password=memo_pass
```

---

## 📦 백엔드 빌드 방법 (로컬 수동)

백엔드를 로컬에서 빌드하려면 아래 명령어를 실행하세요:

```bash
cd back
./gradlew build
```

---

## 🛠 프론트 빌드 방법 (로컬 수동)

프론트를 로컬에서 빌드하려면 아래 명령어를 실행하세요:

```bash
cd front
npm install
npm run dev
```

---

## 🧼 정리 및 종료

실행된 Docker 서비스를 종료하려면 아래 명령어를 실행하세요:

```bash
docker-compose -f docker-compose.full.yml down
```

DB만 종료하려면:

```bash
docker-compose -f docker-compose.db.yml down
```

---

## ✅ TODO

* [ ] 로그인 기능 추가
* [ ] 메모 CRUD 기능 구현
* [ ] DockerHub 이미지 배포
* [ ] CI/CD 구성

---

## 🧑‍💻 만든 사람

* 이상준 (백엔드 개발자)

---
## 📅 프로젝트 기간

> 시작: 2025-05-13
