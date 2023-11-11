## 2주차 그래프 탐색 알고리즘 : BFS


시작하기에 앞서 BFS, DFS 알고리즘을 구글링 하다가 본 문구가 있는데 너무 기억에 남았다...!

_**DFS를 가장 쉽게 설명할 수 있는 말은 '한놈만 팬다' 이고**_

_**BFS를 가장 쉽게 설명할 수 있는 말은 '이놈패다가 저놈패는것'이다.**_


### 그래프
그래프를 표현하는 방법은 두 가지가 있다. 

인접 행렬 VS 연결 리스트


![image](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/131960164/b9a27c9c-3288-4bf4-82a7-1b546946bceb)

더 자세한 건 구글링 해보자


### 너비 우선 탐색 (BFS - Breadth-First Search)
![img](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/131960164/4a478765-61da-49c7-b8dc-8b9e93258a95)


### BFS의 개념
>루트 노드 혹은 임의의 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법이다.  
> 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 
> 방문한다. 즉, 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것이다.


사용하는 경우: 두 노드 사이의 최단 경로, 임의의 경로를 찾고 싶을 때 사용한다.

Ex) 지구상에 존재하는 모든 친구 관계를 그래프로 표현한 후 Ash와 Vanessa 사이에 존재하는 경로를 찾는 경우 어떻게 알고리즘을 짜는가?

DFS- 모든 친구 관계를 다 살펴봐야 할지도 모른다. 

BFS- Ash와 가까운 관계부터 탐색한다.


### BFS의 특징
BFS는 재귀적으로 동작하지 않는다.
BFS는 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 Queue를 사용한다.
즉, 선입선출 원칙으로 탐색하며, 일반적으로 큐를 이용해서 반복적 형태로 구현하는 것이 가장 잘 작동한다.

### BFS의 장단점
- 장점  
  - 너비를 우선으로 탐색하므로 답이 되는 경로가 여러 개인 경우에도 최단 경로를 얻을 수 있다.
  - 경로가 무한히 깊어져도 최단 경로를 반드시 찾을 수 있다.
  - 노드 수가 적고 깊이가 얕은 해가 존재할 때 유리하다.


- 단점
  - DFS와 달리 큐를 이용하여 다음에 탐색할 정점들을 저장하므로 더 큰 저장공간이 필요하다.

    
### BFS 구현
1. 정점 v 방문한다.
2. 정점 v에 인접한 정점 중 방문하지 않은 정점을 차례로 방문하면서 큐에 넣는다.
3. 인접한 정점 모두 방문했다면 큐에서 dqueue하여 받은 값 정점 v로 설정하고 2를 반복한다.
4. 큐가 공백이라면 탐색 완료한 것이다.

```
static boolean[] visit;
    //연결 리스트, 행렬 그래프 중 선택
	static LinkedList<Integer>[] graph;
	static int[][] graph;
    
// 시작 정점 v
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v); //시작 정점 큐에 넣기
		visit[v] = true; //시작 정점 방문
		
		while(!queue.isEmpty()) {
			int temp = queue.poll(); 
			System.out.println(temp);

			for(int nextV : graph[temp]) {
				if(!visit[nextV]) { 
					queue.add(nextV);
					visit[nextV] = true;
				}
			}
		}		
	}
```

```
출력
1 2 3 4 5 6 
```


### + Queue
https://coding-factory.tistory.com/602  
를 정리해보자










### 참고자료:
BFS 개념 참고: https://github.com/WeareSoft/tech-interview/blob/master/contents/algorithm.md

BFS 개념 참고: https://currygamedev.tistory.com/10#%F-%-F%--%A-%C-%A-%EB%--%--%EB%B-%--%--%EC%-A%B-%EC%--%A-%--%ED%--%--%EC%--%---BFS%---%--Breadth-First%--Search-

자바로 BFS 구현 참고: https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-BFS-DFS#-bfs-%EA%B5%AC%ED%98%84---java


Point 클래스 참고: https://blog.naver.com/whalsgh0520/221628681278