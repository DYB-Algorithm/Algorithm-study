#include <cstdio>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

int parent[1000002];
int level[1000002];

#define swap(a,b) {int temp; temp=a; a=b; b=temp;}

//find
int find(int u) {
	//루트노드면
	if (parent[u] == u)
		return u;

	//아니면 자신의 루트를 찾으러 간다
	return parent[u] = find(parent[u]);
}

//Union
void merge(int u, int v) {
	u = find(u); //v 의 루트
	v = find(v); //u 의 루트 

	if (u == v) {
		return;
	}

	//u가 v보다 더 깊은 트리면 swap
	if (level[u] > level[v]) {
		swap(u, v);
	}

	//u의 루트가 v가 되도록 하나로 합쳐준다.
	parent[u] = v;

	//u와 v의 깊이가 같을 때 v의 깊이를 늘려준다.
	if (level[u] == level[v]) {
		++level[v];
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);

	//Union-find
	int n, m;
	scanf("%d %d", &n, &m);

	//초기화 과정
	for (int i = 1; i <= n; i++) {
		parent[i] = i;
		level[i] = 1;
	}

	vector<string> v;

	for (int i = 0; i < m; i++) {
		int cmd, a, b;
		scanf("%d %d %d", &cmd, &a, &b);
		
		// a와 b가 같은 집합에 속해있냐 = 루트노드가 같냐
		if (cmd == 1) {
			if (find(a)==find(b))
				v.push_back("YES");
			else
				v.push_back("NO");
		}

		//a와 b를 합쳐라
		else if(cmd==0) {
			merge(a, b);
		}
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << "\n";
	}
}