#include <iostream>
#include <vector>
#include <cstdio>
#include <queue>
#define MAX 32001

using namespace std;

int n, inDegree[MAX];
vector<int> a[MAX];

//위상정렬은 빠삭하게 알아둬야 한다.

void topologySort() {
	int result[MAX];
	queue<int> q;

	//진입차수 0인 노드를 큐에 삽입.
	for (int i = 1; i <= n; i++) {
		if (inDegree[i] == 0)
			q.push(i);
	}

	for (int i = 1; i <= n; i++) {
		//사이클 발생
		if (q.empty()) {
			return;
		}

		int x = q.front();

		q.pop();

		result[i] = x;

		for (int j = 0; j < a[x].size(); j++) {
			int y = a[x][j];
			
			//새롭게 진입차수가 0이 된 정점을 큐에 삽입한다.
			if (--inDegree[y] == 0)
				q.push(y);
		}
	}

	for (int i = 1; i <= n; i++) {
		printf("%d ", result[i]);
	}

}

int main(void) {
	//위상 정렬
	//순서대로 해야하는 과정들을 알고리즘화. 답이 여러개 
	//방향이 있는 그래프, 사이클이 존재하면 안됨.
	
	//1. 진입차수가 0인 정점을 큐에 삽입.
	//2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거
	//3. 간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입한다.
	//4. 큐가 빌 때까지 2~3번 과정을 계속 반복한다.
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