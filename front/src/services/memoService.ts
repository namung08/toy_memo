import type {Memo} from '../types/memo';
import axiosInstance from './axiosInstance';

export const memoService = {
  async getMemos(): Promise<Memo[]> {
    const response = await axiosInstance.get<any>('/memo/list');
    return response.data;
  },

  async getMemo(id: number): Promise<Memo> {
    const response = await axiosInstance.get<any>(`/memo/${id}`);
    return response.data;
  },

  async createMemo(title: string, content: string): Promise<void> {
    await axiosInstance.post('/memo/create', { title, content });
  },

  async updateMemo(id: number, title: string, content: string): Promise<void> {
    await axiosInstance.put(`/memo/update/${id}`, { title, content });
  },

  async deleteMemo(id: number): Promise<void> {
    await axiosInstance.delete(`/memo/delete/${id}`);
  },
};
