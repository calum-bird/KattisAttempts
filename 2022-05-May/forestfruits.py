from queue import PriorityQueue

class Graph:
    def __init__(self, n):
        self.v = n
        self.edges = [[-1 for i in range(n)] for j in range(n)]
        self.visited = []

    def add_edge(self, s, d, w):
        self.edges[s][d] = w
        self.edges[d][s] = w

    def dijkstra(self, start_vertex):
        graph = self

        D = {v:float('inf') for v in range(graph.v)}
        D[start_vertex] = 0

        pq = PriorityQueue()
        pq.put((0, start_vertex))

        while not pq.empty():
            (_, current_vertex) = pq.get()
            graph.visited.append(current_vertex)

            for neighbor in range(graph.v):
                if graph.edges[current_vertex][neighbor] != -1:
                    distance = graph.edges[current_vertex][neighbor]
                    if neighbor not in graph.visited:
                        old_cost = D[neighbor]
                        new_cost = D[current_vertex] + distance
                        if new_cost < old_cost:
                            pq.put((new_cost, neighbor))
                            D[neighbor] = new_cost
        return D

(v, e, c, k, m) = [int(x) for x in input().split(" ")]

graph = Graph(v+1)

for _ in range(e):
    (a, b, w)= [int(x) for x in input().split(" ")]
    graph.add_edge(a, b, w)

f = [int(x) for x in input().split(" ")]
dist = graph.dijkstra(1)

print("========")
print(dist)
print("========")

picked = {}
for c in f:
    print("agh")

max = -1
day = 1
for key in dist:
    val = dist[key]
    if val > max:
        max = val