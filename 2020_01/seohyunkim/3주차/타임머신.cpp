#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

const int INF = 10001;    //탐색하지 않은 구간 무한대로 설정 
const int MAX_V = 502;

int adj[MAX_V][MAX_V];
int dist[MAX_V];

int S = 1;
bool cycle = false;

int main()
{
	int V, E;     //V:노드갯수, E:엣지갯수, S:시작점, T:끝점 
	int a, b, c;            //(a,b) = c (가중치) 

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

	adj[S][S] = 0;        //시작점을 기준점으로 하기위해 0을 할당 
	dist[S] = 0;        //dist배열은 가중치가 저장됨 

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