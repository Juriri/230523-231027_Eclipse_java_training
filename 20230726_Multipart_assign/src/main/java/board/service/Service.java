package board.service;

import java.util.List;

import model.Board;

public interface Service {
	void writeBoard(Board board);	//�� �ۼ�

	Board getBoard(int num);	//�� �˻�

	List getAll();				//�� ��ü �˻�

	void editBoard(Board board);	//�� ����

	void delBoard(int num);		//�� ����
}
