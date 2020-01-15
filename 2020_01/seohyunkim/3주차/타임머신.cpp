#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

const int INF = 10001;    //Ž������ ���� ���� ���Ѵ�� ���� 
const int MAX_V = 502;

int adj[MAX_V][MAX_V];
int dist[MAX_V];

int S = 1;
bool cycle = false;

int main()
{
	int V, E;     //V:��尹��, E:��������, S:������, T:���� 
	int a, b, c;            //(a,b) = c (����ġ) 

	cin >> V >> E;

	for (int i = 1; i <= V; i++)
		for (int j = 1; j <= V; j++)
			adj[i][j] = INF;

	for (int i = 1; i <= V; i++)
		dist[i] = INF;

	for (int j = 0; j < E; j++) {
		scanf_s("%d %d %d", &a, &b, &c);
		adj[a][b] = min(adj[a][b], c);
		printf("%d %d %d\n", a, b, adj[a][b]);
		//cout << a << " " << b << " " << adj[a][b]<<"\n";
	}

	adj[S][S] = 0;        //�������� ���������� �ϱ����� 0�� �Ҵ� 
	dist[S] = 0;        //dist�迭�� ����ġ�� ����� 

	int* isChanged = new int[V + 1];

	for (int v = 1; v <= V; v++) {
		for (int w = 1; w <= V; w++) {
			if (adj[v][w] != INF) {
				if (dist[v] > dist[w] + adj[v][w]) {
					dist[v] = dist[w] + adj[v][w];
					isChanged[v] = 1;
				}
				
			}
		}
	}

	for (int v = 1; v <= V; v++) {
		for (int w = 1; w <= V; w++) {
			if (adj[v][w] != INF) {
				if (dist[v] > dist[w] + adj[v][w]) {
					dist[v] = dist[w] + adj[v][w];
					if (isChanged[v] == 1) {
						cycle = true;
					}
				}

			}
		}
	}

	

	if (cycle)
		printf("-1\n");

	else {
		for (int i = 2; i <= V; i++) {
			if (dist[i] != INF) {
				cout << dist[i] << "\n";
			}
			else if (dist[i] == INF) {
				printf("-1\n");
			}
		}
	}
}