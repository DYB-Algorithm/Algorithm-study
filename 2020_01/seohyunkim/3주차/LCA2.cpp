#include <iostream>
#include <cstdio>
#include <vector>
#include <cmath>

#define swap(a,b){int t = a; a = b; b = t;}
#define MAX_NODE 100001

using namespace std;

int depth[MAX_NODE]; //����� ����
int ac[MAX_NODE][20]; //x�� 2^y ��° ����

typedef pair<int, int> pii;
vector<int> graph[MAX_NODE];

int max_level;

//DP(ac) �迭 ����� ����
void getTree(int here, int parent) {
	//here�� ���̴� �θ������ + 1
	depth[here] = depth[parent] + 1;

	//here�� 2^0��° ������ �θ���
	ac[here][0] = parent;

	//MAX_NODE�� log2�� ���� ������ ���ش�.
	max_level = (int)floor(log2(MAX_NODE));

	for (int i = 1; i <= max_level; i++)
	{
		//tmp �� here �� 2^(i-1) ��° �����϶�,
		//here �� 2^i��° ������ tmp�� 2^(i-1) ��° �����̴�.
		
		int tmp = ac[here][i - 1];
		ac[here][i] = ac[tmp][i - 1];
	}

	// dfs �˰���
	int len = graph[here].size();
	for (int i = 0; i < len; i++) {
		int there = graph[here][i];
		if (there != parent)
			getTree(there, here);
	}
}

int main(void) {
	int n, m;

	cin >> n;

	//����� �׷���
	for (int i = 0; i < n-1; i++) {
		int from, to;
		cin >> from >> to;
		graph[from].push_back(to);
		graph[to].push_back(from);
	}

	depth[0] = -1;

	getTree(1, 0);

	cin >> m;
	vector<int> ans;

	while (m--) {
		int a, b;
		cin >> a >> b;

		if (depth[a] != depth[b]) {

			//depth[b] >= depth[a]�� �ǵ��� swap 
			if (depth[a] > depth[b]) {
				swap(a, b);
			}

			for (int i = max_level; i >= 0; i--)
			{
				// b�� 2^i��° ������ a�� depth���� ũ�ų� ������ ��� ������ Ÿ����.
				if (depth[a] <= depth[ac[b][i]])
					b = ac[b][i];
			}
		}

		int lca = a;

		//a �� b �� depth �� ������. 
		//a �� b �� �ٸ��ٸ� ���̸� ��� �÷� ���δٸ� ����� ������ ������ ������ �ݺ��Ѵ�.
		if (a != b)
		{
			for (int i = max_level; i >= 0; i--)
			{
				if (ac[a][i] != ac[b][i])
				{
					a = ac[a][i];
					b = ac[b][i];
				}
				lca = ac[a][i];
			}
		}

		ans.push_back(lca);

	}

	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << "\n";
	}
	return 0;
}