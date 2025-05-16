import React from 'react';
import type {Memo} from '../types/memo';

interface MemoListProps {
  memos: Memo[];
  onMemoSelect: (memo: Memo) => void;
  onMemoDelete: (id: number) => void;
}

const MemoList: React.FC<MemoListProps> = ({ memos, onMemoSelect, onMemoDelete }) => {
  return (
    <div className="memo-list">
      <h2>메모 목록</h2>
      <div className="memo-grid">
        {memos.map((memo) => (
          <div key={memo.id} className="memo-card">
            <h3>{memo.title}</h3>
            <p>{memo.content.length > 100 ? `${memo.content.slice(0, 100)}...` : memo.content}</p>
            <div className="memo-card-footer">
              <span>{new Date(memo.updatedAt).toLocaleDateString()}</span>
              <div className="memo-card-actions">
                <button onClick={() => onMemoSelect(memo)}>수정</button>
                <button onClick={() => onMemoDelete(memo.id)}>삭제</button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default MemoList;
