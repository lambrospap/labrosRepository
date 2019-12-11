import time
import multiprocessing

def details(arg):
    time.sleep(1)
    print("I slept 1 second and then did my work")
    print(arg, "has length of", len(arg))

if __name__ == '__main__':
    startTime = time.perf_counter()
    colors = ['red', 'blue', 'pink', 'green', 'yellow']
    processes = []

    for x in colors:
        p = multiprocessing.Process(target=details, args=[x])
        p.start()
        processes.append(p)
    for process in processes:
        process.join()
    endTime = time.perf_counter()
    ElapsedTime = endTime - startTime
    print("Elapsed time..", ElapsedTime)

