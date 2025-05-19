# 📝 Memo Web Application

Spring Boot + React (Vite + TypeScript) 기반의 간단한 메모 웹 애플리케이션입니다. MariaDB를 사용하며, Docker를 통해 로컬 환경에서 손쉽게 실행할 수 있습니다.

---

## 🗂 프로젝트 구조

```
memo/
├── back/        # Spring Boot 백엔드 (Gradle)
├── front/       # Vite + React + TypeScript 프론트엔드
├── docker-compose.db.yml  # DB만 실행할 때 사용하는 Docker Compose
└── docker-compose.full.yml  # 전체 시스템(DB + 백엔드 + 프론트엔드 빌더) 실행용 Docker Compose
```

---

## 🚀 실행 방법

### **Docker Compose를 통한 실행**

Docker Compose를 사용하여 전체 또는 일부 서비스를 컨테이너 환경에서 실행하는 방법입니다.

#### 1️⃣ **DB만 실행 (docker-compose.db.yml)**

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

#### 2️⃣ **전체 서비스 실행 (docker-compose.full.yml)**

전체 시스템(DB + 백엔드 + 프론트엔드)을 실행하려면 아래 명령어를 사용하세요:

```bash
docker-compose -f docker-compose.full.yml up --build -d --force-recreate
```

이 명령어는 DB, 백엔드, 프론트엔드 빌더를 빌드하고 실행하며, 백엔드에서 프론트엔드 정적 파일을 서빙합니다.

* **백엔드 및 프론트엔드**: [http://localhost:8080](http://localhost:8080)

---

### **로컬에서 각각 실행**

Docker 없이 로컬 환경에서 백엔드와 프론트엔드를 개별적으로 실행하는 방법입니다. DB는 Docker Compose 또는 로컬 설치된 DB를 사용합니다.

#### 📦 백엔드 빌드 및 실행 (로컬 수동)

백엔드를 로컬에서 빌드하고 실행하려면 아래 명령어를 사용하세요:

```bash
cd back
./gradlew build
./gradlew bootRun
```
(참고: 로컬 실행 시 application.yml의 데이터소스 설정(localhost:3306 등)을 확인하세요.)

#### 🛠 프론트 개발 실행 (로컬 수동)

프론트를 로컬 개발 모드로 실행하려면 아래 명령어를 사용하세요:

```bash
cd front
npm install
npm run dev
```
(주의: 로컬 프론트 개발 시에는 백엔드 서버가 별도로 실행되어 있어야 합니다. 백엔드는 로컬에서 실행하거나 Docker Compose로 DB/백엔드만 실행하여 연결할 수 있습니다.)

---

## ⚙ 환경 변수

`application.yml` 혹은 Docker 환경 변수로 다음이 설정됩니다:

```yaml
spring.datasource.url=jdbc:mysql://db:3306/memo_db
spring.datasource.username=memo_user
spring.datasource.password=memo_pass
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
* [ ] DockerHub 이미지 배포
* [ ] CI/CD 구성

---

## 🧑‍💻 만든 사람

* 이상준 (백엔드 개발자)

---
## 📅 프로젝트 기간

> 시작: 2025-05-13
> 완료: 2025-05-19
