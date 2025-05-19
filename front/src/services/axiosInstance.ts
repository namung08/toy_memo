import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: '/api',
  withCredentials: true,
  headers: {
    'Content-Type': 'application/json',
  },
});

// 응답 인터셉터 추가
axiosInstance.interceptors.response.use(
  (response) => response.data,
  (error) => {
    const message = error.response?.data?.message || '알 수 없는 오류가 발생했습니다.';
    return Promise.reject(new Error(message));
  }
);

export default axiosInstance; 