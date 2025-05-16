import React, {useEffect, useState} from 'react';
import type {Memo} from '../types/memo';

interface MemoFormProps {
  memo?: Memo;
  onSubmit: (title: string, content: string) => void;
  onCancel: () => void;
}

const MemoForm: React.FC<MemoFormProps> = ({ memo, onSubmit, onCancel }) => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');

  useEffect(() => {
    if (memo) {
      setTitle(memo.title);
      setContent(memo.content);
    }
  }, [memo]);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!title.trim() || !content.trim()) {
      alert('제목과 내용을 모두 입력해주세요.');
      return;
    }
    onSubmit(title, content);
    setTitle('');
    setContent('');
  };

  return (
    <form onSubmit={handleSubmit} className="memo-form">
      <h2>{memo ? '메모 수정' : '새 메모 작성'}</h2>
      <div className="form-group">
        <label htmlFor="title">제목</label>
        <input
          type="text"
          id="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="메모 제목을 입력하세요"
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="content">내용</label>
        <textarea
          id="content"
          value={content}
          onChange={(e) => setContent(e.target.value)}
          placeholder="메모 내용을 입력하세요"
          rows={6}
          required
        />
      </div>
      <div className="form-actions">
        <button type="submit">{memo ? '수정' : '저장'}</button>
        <button type="button" onClick={onCancel}>취소</button>
      </div>
    </form>
  );
};

export default MemoForm;
