# Memo Web Application <img src="img/memo-icon.png" alt="" width="30">

---

- 이 프로젝트는 **Spring Boot와 React(Vite + TypeScript)**를 활용한 현대적인 메모 웹 애플리케이션입니다.

<h1>Modern Memo Web Application using Spring Boot and React v1.0</h1>

---

> **SeSAC**  
> **개발기간 : 2025.05.13 - 2025.05.19**

# 개발자 <img src="img/developer-icon.png" alt="" width="30">

---

|                              **이상준**                               |
| :-------------------------------------------------------------------: |
| ![profile.png](https://avatars.githubusercontent.com/u/113490780?v=4) |
|               [@namung08](https://github.com/namung08)                |
|                    안산대학교 컴퓨터 정보학과 졸업                    |

# 프로젝트 소개 <img src="img/info-icon.png" alt="" width="30">

---

- **메모 관리** : 사용자가 일상적인 메모를 효율적으로 관리할 수 있는 기능을 제공합니다.
- **상태 관리** : 메모의 작성/수정 상태를 쉽게 관리할 수 있습니다.
- **데이터 저장** : MariaDB를 활용하여 사용자의 메모 데이터를 안전하게 저장합니다.
- **반응형 디자인** : 모든 디바이스에서 최적화된 사용자 경험을 제공합니다.
- **컨테이너화** : Docker Compose를 활용하여 개발 및 배포 환경을 컨테이너화했습니다.
- **Cursor 활용** : Cursor를 통해 프론트엔드 페이지 및 Docker 설정을 구성했습니다.
- **배포 최적화** : 초기 Nginx 배포 시도 및 CORS 문제 해결 과정을 통해 실제 운영 환경에서 발생할 수 있는 문제를 해결했습니다.

# 시작 가이드 <img src="img/guide-icon.png" alt="" width="30">

---

- **프로그래밍 언어** : [Java](https://www.java.com/), [TypeScript](https://www.typescriptlang.org/)
- **프레임워크** : [Spring Boot](https://spring.io/projects/spring-boot), [React 19](https://react.dev/)
- **빌드 도구** : [Maven](https://maven.apache.org/), [Vite](https://vitejs.dev/)
- **패키지 매니저** : [npm](https://www.npmjs.com/)
- **데이터베이스** : [MariaDB](https://mariadb.org/)
- **컨테이너화** : [Docker](https://www.docker.com/), [Docker Compose](https://docs.docker.com/compose/)
- **사용 툴** : [VS Code](https://code.visualstudio.com/), [Cursor](https://cursor.sh/)

```bash
git clone https://github.com/namung08/memo_web_application.git
cd memo_web_application
docker-compose up -d
```

# 기술 스택 📚

---

<div align=center> 
<h3>Environment</h3>
    <img src="https://img.shields.io/badge/VS Code-007ACC?style=for-the-badge&logo=Visual Studio Code&logoColor=white">
    <img src="https://img.shields.io/badge/Cursor-00A8E8?style=for-the-badge&logo=Cursor&logoColor=white">
<h3>Config</h3>
<img src="https://img.shields.io/badge/npm-CB3837?style=for-the-badge&logo=npm&logoColor=white">
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Apache Maven&logoColor=white">
<h3>Development</h3>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white">
<img src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=TypeScript&logoColor=white">
<img src="https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=Vite&logoColor=white">
<h3>Database</h3>
<img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=MariaDB&logoColor=white">
<h3>Container</h3>
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white">
<img src="https://img.shields.io/badge/Docker Compose-2496ED?style=for-the-badge&logo=Docker Compose&logoColor=white">
<h3>Communication </h3>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>

# 화면 구성 <img src="img/screen-icon.png" alt="" width="30">

---

| **메인 화면**             | **메모 작성**               |**메모 수정**             |
| ------------------------- | --------------------------- |------------------------- |
| ![main.png](img/main.png) | ![write.png](img/write.png) | ![edit.png](img/edit.png) |





# 주요 기능 <img src="img/feature-icon.png" alt="" width="30">

---

## ⭐️ 메모 관리 기능

- 새로운 메모 작성
- 기존 메모 수정
- 메모 삭제

## ⭐️ 상태 관리 기능

- 메모 작성/수정 상태 관리
- 진행 상태에 따른 시각적 표시

## ⭐️ 데이터 저장 기능

- MariaDB를 활용한 데이터 영구 저장
- 페이지 새로고침 시에도 데이터 유지

## ⭐️ 컨테이너화 기능

- Docker Compose를 활용한 개발 및 배포 환경 컨테이너화
- Cursor를 통한 프론트엔드 페이지 및 Docker 설정 구성

## ⭐️ 배포 최적화 기능

- 초기 Nginx 배포 시도 및 CORS 문제 해결
- React 페이지를 정적 파일로 빌드하여 Spring Boot 애플리케이션에서 서빙

# 프로젝트 구조 <img src="img/structure-icon.png" alt="" width="30">

---
