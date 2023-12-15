## 우선 순위 큐란?
일반적인 큐의 구조인 FIFO(First In First Out)를 가지면서, 데이터가 들어오는데로 나가는 게 아니라
우선순위를 결정하고 그 우선순위가 높은 데이터부터 나가는 구조다. 

우선 순위 큐는 보통 Heap으로 구현하는 게 기본적이다.
힙은 우선 순위를 정하는 기준이 따라 달라진다. 
최대 값이 우선 순위라면 최대 힙을, 최솟 값이 우선 순위라면 최소 힙을 구성하면 된다.
데이터를 삽입할 때 힙을 만들고, 데이터를 꺼낼 땐 루트 노드를 얻어내고 루트 노드를 삭제하는데, 
이때 루트 노드를 삭제할 때는 빈 루트 노드 위치에 맨 마지막 노드를 삽입 후 아래로 내려가며 적절한 자리를 찾아 옮기는 방식으로 진행.

## 선행지식) 최대 힙? 최소 힙? 
출처 : https://innovation123.tistory.com/111

### <최소 힙>

#### 1. 정의
   
![image](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/122192096/fb6dd935-7c38-4f90-86e0-be9854ca9417)

최소 힙은 부모 노드의 key가 자식 노드의 key보다 작거나 같은 완전 이진 트리다. 

#### 2. 삽입 과정
   
![image](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/122192096/2e7aa9bd-7d9d-48ca-99bb-5af2217d50c0)

트리의 가장 끝 위치에 데이터를 삽입하고, 부모노드랑 key값 비교해서 작을 경우 부모 노드와 자리를 교체.

#### 3. 삭제 과정
   
![image](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/122192096/230a6fc6-9917-4de2-bf08-f3f5b986f46c)

최상위 노드를 반환하며 삭제. 
그리고 최상위에 가장 마지막 위치의 노드(최하위노드)를 위치시키고 자식노드와 비교하며 자리 교체함.

### <최대 힙>
#### 1. 정의
   
![image](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/122192096/fe9aaebe-760e-4981-ae8e-81cc3aba6a17)

최대 힙은 부모 노드의 key가 자식 노드의 key보다 크거나 같은 완전 이진트리다.

#### 2. 삽입 과정
   
![image](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/122192096/483a3860-54d9-460c-a155-983254af242c)

트리의 가장 끝 위치에 데이터를 삽입하고, 부모노드랑 key값 비교해서 클 경우 부모 노드와 자리를 교체.

#### 3. 삭제 과정
   
![image](https://github.com/Java-A1gorithm-study/A1goritm-study/assets/122192096/7dbc8256-daa0-41f4-a7e6-bdd6dc8eee76)

최상위 노드를 반환하며 삭제. 
그리고 최상위에 가장 마지막 위치의 노드(최하위노드)를 위치시키고 자식노드와 비교하며 자리 교체함. 


## 우선순위 큐의 특징

1. 큐의 기본 성질을 따르면서 우선순위의 요소를 먼저 꺼내서 처리함.
2. 내부 요소는 힙으로 구성된다.
3. 힙이라서 시간 복잡도는 NlogN이다.

## 우선순위 큐 사용

### 1. 선언
```
import java.util.PriorityQueue;
import java.util.Collections;

//낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

//높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
```

### 2. 넣기
```
// add(value) 메서드의 경우 만약 삽입에 성공하면 true를 반환, 
// 큐에 여유 공간이 없어 삽입에 실패하면 IllegalStateException을 발생
priorityQueueLowest.add(1);
priorityQueueLowest.add(10);
priorityQueueLowest.offer(100);

priorityQueueHighest.add(1);
priorityQueueHighest.add(10);
priorityQueueHighest.offer(100);
```

### 3. 삭제
```
// 첫번째 값을 반환하고 제거 비어있다면 null
priorityQueueLowest.poll();

// 첫번째 값 제거 비어있다면 예외 발생
priorityQueueLowest.remove(); 

// 첫번째 값을 반환만 하고 제거 하지는 않는다.
// 큐가 비어있다면 null을 반환
priorityQueueLowest.peek();

// 첫번째 값을 반환만 하고 제거 하지는 않는다.
// 큐가 비어있다면 예외 발생
priorityQueueLowest.element();

// 초기화
priorityQueueLowest.clear();
```

## 심화) Comparable과 Comparator의 이해

### <Comparable 인터페이스>

#### 1. 정의

Comparable과 Comparator 둘 다 객체를 비교할 수 있도록 만드는데 초점이 맞춰져 있다.


### <Comparator 인터페이스>

