# 해당 노드의 부모 노드가 무엇인지 찾기
def find_parent(parent, x):
    
    # 해당 노드가 소속 집단의 부모 노드가 아니라면 부모노드 찾기
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    
    return parent[x]

# 같은 집단 = 노드들이 하나로 연결 됨
# 두 개의 노드를 연결해주는 함수
def union(parent, x, y):
    
    a = find_parent(parent, x)
    b = find_parent(parent, y)
    
    # 다른 노드와 연결시 숫자가 더 작은 노드를 부모 노드로 함
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
        
def solution(n, costs):
    answer = 0
    parent = []
    
    # 처음엔 자기 자신이 부모 노드라 해당 노드 값을 부모 노드값으로 
    for i in range(n):
        parent.append(i)
    
    # 비용이 적은 것 부터 추가하기 위해 비용 기준 오름차순 정렬
    # 이중 리스트라 안의 원소에 접근해서 변경
    # 비용의 순서가 맨뒤에 있어서 reverse 
    for cost in costs:
        cost.reverse() 
    # 이중 리스트 sort하면 원소 리스트의 앞 순서 인덱스 기준 정렬 = 비용 순
    costs.sort()
    
    for cost in costs:
        c, y, x = cost
        
        # 두 노드가 같은 집단이 아닌 경우만 연결
        # 부모 노드를 같게 해줘서 연결, 비용 계산
        if find_parent(parent, x) != find_parent(parent, y):
            union(parent, x, y)
            answer += c

    return answer