## 이분 탐색이란

순차적  탐색보다 더 빠른 탐색을 위해 나온 탐색 방법.
시간복잡도도 순차적 탐색보다 낮다.



## 이분 탐색의 원리

정렬된 배열 안에서 특정 원소를 찾을 때 인덱스 i부터 j의 중간값과 비교
중간 값이 찾는 원소의 조건에 부합하지 않는다면 인덱스 i와 j를 다시 정한다.
인덱스를 다시 정할 때마다 탐색 범위가 반으로 줄어들기 때문에 불필요한 탐색을 줄일 수 있음.

<img src="https://github.com/Java-A1gorithm-study/A1goritm-study/assets/122192096/75aadf22-0f9b-460a-8381-b6fc33d618f8" width="357" height="287"/>

출처 : suk13574의 velog


## 이분 탐색 방법

1. 처음 인덱스는 0부터 끝까지다. 중간 인덱스를 mid로 잡는다.

2. mid의 값과 찾는 원소의 값을 비교한다.
   2-1. mid의 값 = 찾는 원소의 값) 탐색 종료
   2-2. mid의 값 < 찾는 원소의 값) 시작 지점인 left의 인덱스를 mid+1로 하여 2를 반복
   2-3. mid의 값 > 찾는 원소의 값) 종료 지점인 right의 인덱스를 mid-1로 하여 2를 반복

3. 2번을 반복했음에도 탐색 종료가 되지 않으면서 right < left가 된다면 해당 배열에 찾는 원소가 없는 것.



## 자바에서 이분 탐색을 구현하기

1. 반복문으로 구현하기

```
    1. 변수 설정
       left = 0
       right = arr.length - 1
       int mid

    2. 반복하기
       while문 안에서(반복 조건은 left <= right일 때)
       mid = (left + right) / 2; //mid는 탐색 인덱스의 시작과 끝의 절반.
       if (arr[mid] < n) left = mid + 1; // mid의 값 < 찾는 원소의 값이면,
       else if (arr[mid] > n) right = mid - 1; // mid의 값 > 찾는 원소의 값이면,
```

2. 재귀로 구현하기

```
   public void binarySearch(int[] arr, int n, int left, int right)

   if(left > right) return 0; // 재귀 탈출 조건

   int mid = (left + right) / 2; //mid는 탐색 인덱스의 시작과 끝의 절반.

   if (arr[mid] < n)
   return BSearchRecursive(arr, n, mid +1, right);
   else if (arr[mid] > n)
   return BSearchRecursive(arr, n, left, mid - 1);
   else
   return 0;
```


