#include <iostream>
#include <vector>
#include <cstdio>
#include <queue>
#define MAX 32001

using namespace std;

int n, inDegree[MAX];
vector<int> a[MAX];

//���������� �����ϰ� �˾Ƶ־� �Ѵ�.

void topologySort() {
	int result[MAX];
	queue<int> q;

	//�������� 0�� ��带 ť�� ����.
	for (int i = 1; i <= n; i++) {
		if (inDegree[i] == 0)
			q.push(i);
	}

	for (int i = 1; i <= n; i++) {
		//����Ŭ �߻�
		if (q.empty()) {
			return;
		}

		int x = q.front();

		q.pop();

		result[i] = x;

		for (int j = 0; j < a[x].size(); j++) {
			int y = a[x][j];
			
			//���Ӱ� ���������� 0�� �� ������ ť�� �����Ѵ�.
			if (--inDegree[y] == 0)
				q.push(y);
		}
	}

	for (int i = 1; i <= n; i++) {
		printf("%d ", result[i]);
	}

}

int main(void) {
	//���� ����
	//������� �ؾ��ϴ� �������� �˰���ȭ. ���� ������ 
	//������ �ִ� �׷���, ����Ŭ�� �����ϸ� �ȵ�.
	
	//1. ���������� 0�� ������ ť�� ����.
	//2. ť���� ���Ҹ� ���� ����� ��� ������ ����
	//3. ���� ���� ���Ŀ� ���������� 0�� �� ������ ť�� �����Ѵ�.
	//4. ť�� �� ������ 2~3�� ������ ��� �ݺ��Ѵ�.
	int m;
	int c, d;

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		inDegree[i] = 0;
	}

	while (m--) {
		cin >> c >> d;
		a[c].push_back(d);
		inDegree[d]++;
		
	}

	topologySort();

}