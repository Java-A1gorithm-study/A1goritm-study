# 트리

## 이진 트리를 탐색하는 방법에는 크게 4가지가 있다고 한다. 

### 1. 전위 순회
### 2. 중위 순회
### 3. 후위 순회
### 4. 레벨 순회(BFS)

## 1. 전위 순회 

전위, 중위, 후위 모두 dfs에 속하긴 하지만, 나는 그 중에서도 전위 순회를
우리가 평소에 기본적인 dfs를 설명할 때 보이던 예시와 같다고 생각한다. <br>

전위 순회는 다음과 같다. <br>
순서 : 루트 노드 > 왼쪽 자식 > 오른쪽 자식

사진

출처 : https://www.jiwon.me/binary-tree-traversal/


## 2. 중위 순회

중위 순회는 다음과 같다. <br>
순서 : 왼쪽 자식 > 루트 노드 > 오른쪽 자식

사진

출처 : https://www.jiwon.me/binary-tree-traversal/


## 3. 후위 순회

후위 순회는 다음과 같다. <br>
순서 : 왼쪽 자식 > 오른쪽 자식 > 루트 노드 

사진

출처 : https://www.jiwon.me/binary-tree-traversal/


## 4. 레벨 순회

레벨 순회는 다음과 같다. <br>
순서 : 루트 노드 > 그 다음 레벨의 노드(동일 레벨의 경우 좌측부터)

사진

출처 : https://www.jiwon.me/binary-tree-traversal/

