import React, {useEffect, useState} from 'react';
import type {Memo} from './types/memo';
import MemoList from './components/MemoList';
import MemoForm from './components/MemoForm';
import {memoService} from './services/memoService';
import './App.css';

const App: React.FC = () => {
  const [memos, setMemos] = useState<Memo[]>([]);
  const [selectedMemo, setSelectedMemo] = useState<Memo | undefined>(undefined);
  const [isFormVisible, setIsFormVisible] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const fetchMemos = async () => {
    try {
      setIsLoading(true);
      setError(null);
      const data = await memoService.getMemos();
      setMemos(data);
    } catch (err) {
      setError('메모를 불러오는데 실패했습니다.');
      console.error('Failed to fetch memos:', err);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    fetchMemos();
  }, []);

  const handleCreateMemo = async (title: string, content: string) => {
    try {
      setIsLoading(true);
      setError(null);
      await memoService.createMemo(title, content);
      await fetchMemos();
      setIsFormVisible(false);
    } catch (err) {
      setError('메모 생성에 실패했습니다.');
      console.error('Failed to create memo:', err);
    } finally {
      setIsLoading(false);
    }
  };

  const handleUpdateMemo = async (title: string, content: string) => {
    if (!selectedMemo) return;

    try {
      setIsLoading(true);
      setError(null);
      await memoService.updateMemo(selectedMemo.id, title, content);
      await fetchMemos();
      setSelectedMemo(undefined);
      setIsFormVisible(false);
    } catch (err) {
      setError('메모 수정에 실패했습니다.');
      console.error('Failed to update memo:', err);
    } finally {
      setIsLoading(false);
    }
  };

  const handleDeleteMemo = async (id: number) => {
    if (!window.confirm('메모를 삭제하시겠습니까?')) return;

    try {
      setIsLoading(true);
      setError(null);
      await memoService.deleteMemo(id);
      await fetchMemos();
    } catch (err) {
      setError('메모 삭제에 실패했습니다.');
      console.error('Failed to delete memo:', err);
    } finally {
      setIsLoading(false);
    }
  };

  const handleMemoSelect = (memo: Memo) => {
    setSelectedMemo(memo);
    setIsFormVisible(true);
  };

  if (error) {
    return <div className="error-message">{error}</div>;
  }

  return (
    <div className="app">
      <header className="app-header">
        <h1>메모장</h1>
        <button onClick={() => setIsFormVisible(true)} disabled={isLoading}>
          새 메모
        </button>
      </header>

      <main className="app-main">
        {isLoading && <div className="loading">로딩 중...</div>}
        {!isLoading && (
          isFormVisible ? (
            <MemoForm
              memo={selectedMemo}
              onSubmit={selectedMemo ? handleUpdateMemo : handleCreateMemo}
              onCancel={() => {
                setIsFormVisible(false);
                setSelectedMemo(undefined);
              }}
            />
          ) : (
            <MemoList
              memos={memos}
              onMemoSelect={handleMemoSelect}
              onMemoDelete={handleDeleteMemo}
            />
          )
        )}
      </main>
    </div>
  );
};

export default App;
