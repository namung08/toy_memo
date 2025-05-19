# 빌드 단계
FROM node:18-alpine as build

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# 최종 이미지 단계 (빌드 결과만 남김)
FROM alpine as final
WORKDIR /app
COPY --from=build /app/dist /app/dist
