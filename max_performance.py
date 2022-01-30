import heapq
class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        eng=[[] for _ in range(n)]
        for i in range(n):
            eng[i].append(efficiency[i])
            eng[i].append(speed[i])
        eng=sorted(eng,reverse=True)
        total,best=0,0
        pq=[]
        heapify(pq)
        for i in range(n):
            total+=eng[i][1]
            heapq.heappush(pq,eng[i][1])
            while len(pq)>k:
                total-=heapq.heappop(pq)
            best=max(best,total*eng[i][0])
        return best%(10**9+7)
            
            
            
            
        
        