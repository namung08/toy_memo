import type {Memo} from '../types/memo';

const API_BASE_URL = '/api/memo';

interface ApiResponse<T> {
  success: boolean;
  data: T;
  message: string | null;
}

export const memoService = {
  async getMemos(): Promise<Memo[]> {
    const response = await fetch(`${API_BASE_URL}/list`);
    const result = await response.json() as ApiResponse<Memo[]>;
    return result.data;
  },

  async getMemo(id: number): Promise<Memo> {
    const response = await fetch(`${API_BASE_URL}/${id}`);
    const result = await response.json() as ApiResponse<Memo>;
    return result.data;
  },

  async createMemo(title: string, content: string): Promise<void> {
    await fetch(`${API_BASE_URL}/create`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ title, content }),
    });
  },

  async updateMemo(id: number, title: string, content: string): Promise<void> {
    await fetch(`${API_BASE_URL}/update/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ title, content }),
    });
  },

  async deleteMemo(id: number): Promise<void> {
    await fetch(`${API_BASE_URL}/delete/${id}`, {
      method: 'DELETE',
    });
  },
};
