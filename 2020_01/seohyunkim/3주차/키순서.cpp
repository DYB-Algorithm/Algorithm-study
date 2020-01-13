#include <cstdio>
#define MAX_N 502
#define MAX_M 125751
#define INF 10000000

int a[MAX_N][MAX_N];
int n, m;
int sum[MAX_N] = {0,};
int d[MAX_N][MAX_N];
int ans[MAX_N] = { 0, };

void floydWarshall() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			d[i][j] = a[i][j];
		}
	}

	//k= 거처가는 노드
	for (int k = 0; k < n; k++) {
		//i= 출발노드
		for (int i = 0; i < n; i++) {
			//j= 도착노드
			for (int j = 0; j < n; j++) {
				//k를 거쳐서 가는 것이 빠르다면, 
				if (d[i][k] + d[k][j] < d[i][j]) {
					d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}
}


int main(void) {
	scanf("%d %d", &n, &m);

	while (m--) {
		int p, q;
		scanf("%d %d", &p, &q);
		a[p-1][q-1] = 1;
	}
	
	//배열 a 초기화
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j)
				a[i][j] = 0;

			else if (a[i][j] != 1) {
				a[i][j] = INF;
			}
		}
	}

	floydWarshall();
	int sum = 0;

	for (int i = 0; i < n; i++) {
        //가로
		for (int j = 0; j < n; j++) {
			if (d[i][j] >= 1 && d[i][j] != INF) {
				ans[i]++;
			}
		}
		//세로
		for (int j = 0; j < n; j++) {
			if (d[j][i] >= 1&&d[j][i]!=INF) {
				ans[i]++;
			}
		}
		if (ans[i] == n - 1) {
			sum++;
		}
	}

	printf("%d\n", sum);

	return 0;
}