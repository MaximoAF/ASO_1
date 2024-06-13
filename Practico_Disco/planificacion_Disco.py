import random

# Generar solicitudes de disco aleatorias
def generate_requests(num_requests, max_cylinder):
    return [random.randint(0, max_cylinder) for _ in range(num_requests)]

# FCFS
def fcfs(requests, start):
    distance = 0
    current = start
    for request in requests:
        distance += abs(request - current)
        current = request
    return distance

# SSTF
def sstf(requests, start):
    distance = 0
    current = start
    requests = requests[:]
    while requests:
        closest = min(requests, key=lambda x: abs(x - current))
        distance += abs(closest - current)
        current = closest
        requests.remove(closest)
    return distance

# SCAN
def scan(requests, start, max_cylinder):
    distance = 0
    current = start
    direction = 1
    sorted_requests = sorted(requests)
    while sorted_requests:
        if direction == 1:
            to_process = [r for r in sorted_requests if r >= current]
        else:
            to_process = [r for r in sorted_requests if r <= current][::-1]

        if to_process:
            for request in to_process:
                distance += abs(request - current)
                current = request
                sorted_requests.remove(request)
        else:
            if direction == 1:
                distance += abs(max_cylinder - current)
                current = max_cylinder
            else:
                distance += abs(current)
                current = 0
            direction *= -1
    return distance

# C-SCAN
def cscan(requests, start, max_cylinder):
    distance = 0
    current = start
    sorted_requests = sorted(requests)
    to_process = [r for r in sorted_requests if r >= current]

    for request in to_process:
        distance += abs(request - current)
        current = request

    if sorted_requests:
        distance += abs(max_cylinder - current) + max_cylinder
        current = 0
        to_process = [r for r in sorted_requests if r < current]
        for request in to_process:
            distance += abs(request - current)
            current = request

    return distance

# Parámetros de la simulación
num_requests = 10
max_cylinder = 200
start_position = 50

requests = generate_requests(num_requests, max_cylinder)

# Resultados de la simulación
print(f"Solicitudes de disco: {requests}")
print(f"Posición inicial: {start_position}")
print(f"FCFS: {fcfs(requests, start_position)}")
print(f"SSTF: {sstf(requests, start_position)}")
print(f"SCAN: {scan(requests, start_position, max_cylinder)}")
print(f"C-SCAN: {cscan(requests, start_position, max_cylinder)}")
