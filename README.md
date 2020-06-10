## Thread
- Why multithread, to fullly utilize multi-core processing power. 

- 13.2 [Multithreading in Java Practical](https://www.youtube.com/watch?v=Xj1uYKa8rIw): ThreadDemo 
- 13.3 [Multithreading using Runnable Interface](https://www.youtube.com/watch?v=xvXbvrUUGMM): RunnableDemo
- 13.4 [MultiThreading using Lambda Expression](https://www.youtube.com/watch?v=VDYSgjPxu18): LambdaDemo

## Java Memory 
- [Java Memory Model](https://www.youtube.com/watch?v=Z4hMFBvCDV4)
1. out of order execution - compiler, JVM or CPU could possibly change the order of instructions to obtain better performance, while program semantic remain the same.
2. Field visibility (concurrency) - core,registers, L1 cache, L2 cache, L3 cache, RAM (--> increase size, increasing latency). JVM flushes the value of volatile variables to shared cache so that threads in other core (CPU) can load the latest value.
Java Memory Model is a specification which guarantees visibility of fields (aka happens before) amidst reordering of instructions.
3. Happens-Before relationship, write operations that happen before the following keywords/cases, are flushed to shared memory  
    1. volatile
    2. synchronized (method/block), should apply/lock on the same object, i.e. synchronized(obj1)
    3. Lock/ReentrantLock: lock(), unlock()
    3. Concurrent collections
    4. Thread operations (join, start)
    final fields (special behaviour)     

## Synchronized

- When you have data that is shared among threads, you will need to synchonized the read and write operations of that data.
- Why read operation need synchronized, but not write operation only, because you'll have to prevent dirty read. i.e. when data has been updated to 101, you don't want some other thread to read the old value, let's say 100. 
- 13.7 [Multithreading Synchronized Keyword](https://www.youtube.com/watch?v=RH7G-N2pa8M): CounterTest
- There are several ways to synchronized:
  1. synchronized method
  2. synchronized block
  3. atomic package: e.g. java.util.concurrent.atomic.AtomicInteger
  4. volatile keyword
  5. use thread-safe java built-in class: e.g. StringBuffer, ConcurrentHashMap

- why StringBuffer and StringBuilder are not thread-safe when append()
    -   StringBufferTest, StringBuilderTest
    
- [Synchronized Block And Synchronized Methods In Java](https://www.youtube.com/watch?v=Tyj5SPdbox8)

### A. Synchronized
1. *synchronized*, can be applied for methods or blocks, but not for classes or variables
2. if a method or block declared *synchronized*, then at a time, only one thread is allowed to execute that method or block on the given object.
3. adv: resolve data inconsistency problem
4. disadv: increase waiting time of threads and affect system performance

### B. Synchronized Block
1. you may lock on an object other than *this* which is more flexible. ***All synchronzied block should lock on the same object***
```$java
public void add(int value){
    Student s = new Student();
    synchronized(s){
        this.count += value;
    }
}
```

5. It is recommended not to use *sychronized*, unless special requirement.
6. Internally, synchronization is implemented by using lock concept.
7. Every object in Java has a unique lock.
8. If a thread wants to execute any *synchronized* method on the given object. First, it has to get the lock of that object, then it's allowed to execute any *synchronized* method of that object. If the *synchronized* method execution completes then the thread will release lock automatically.
9. While a thread executing any *synchronized* method, the remaining threads are not allowed to execute any *synchronized* method on that object simultaneously. But, they are allowed to execute non-*synchronized* method. ***Lock concept is implemented based on object but not based on method.***

### C. Class level lock
1. Every class in Java has a unique lock. 
2. If a thread wants to execute a static *synchronized* method then it required **class level lock**. Once a thread got **class level lock**, it is allowed to execute any static synchronized method of that class.
3. While a thread executing any static synchronized method, the remaining threads are not allowed to execute any static synchronized method of that class simultaneously.
4. But remaining threads are allowed to execute synchronized instance methods, normal static methods, normal instance methods simultaneously.
5. **class level lock** and **object lock** both are different and there is no relationship between these two.

### D. Synchronzied block
1. Minimize the number of lines that required synchronization
2. The main purpose/advantage of synchronized block is to reduce waiting time of thread and improve system performance.

### Important
- When a thread enters into **synchronized method** or **block**, it acquires lock and once it completes its task and exits ferom the synchronized method, it releases the lock.
- When thread enters into **synchronized instance method** or **block**, it acquires **object level lock**. When it enters into **synchronized static method** or **block**, it acquires **class level lock**.
- Java synchronization will throw *NullPointerException* if object used in synchronized block is *null*.
```$java
synchronized(INSTANCE)  // throw NullPointerException if INSTANCE is null 
```
- cannot apply *synchronized* keyword to variables
- In Java, *wait()*, *notify()*, and *notifyAll()* are important methods that are used in synchronization.
- Do not synchronize non-final field on synchronized block, because the reference to the non-final field may change anytime, and then different threads might synchronize on different objects. i.e. no synchronization at all.

## [Volatile vs AtomicInteger](https://www.youtube.com/watch?v=WH5UvQJizH0)

- if visibility problem, use ***volatile*** **alone** 
```$java
volatile boolean flag = false;
```
- if synchronization problem, use ***AtomicInteger*** or ***synchronized method/block*** 
```$java
volatile int value = 1; 

value++;    // volatile alone cannot solve, this is a synchronization problem
``` 
- has 3 steps, 
    1. read count
    2. set count + 1
    3. store new value to count
    
|#   |Thread-1   |Thread-2   |
|---|---|---|
|1  |read value (=1)   |   |
|2  |   |read value (=1)   |
|3  |add 1 and write (=2)   |   |
|4  |   |add 1 and write (=2)   |
    
```$java
volatile int value = 1; 

synchronized(obj){
    value++;    // use volatile + synchronized 
}
``` 

or use AtomicInteger
```$java
AtomicInteger value = new AtomicInteger(1); 

value.increment();    // read and write operations in this method are done atomically
```

```$java
incrementAndGet
decrementAndGet
addAndGet(int delta)
compareAndSet(int expectedValue, int newValue); // the value equals to expectedValue, then set to the newValue
```

### conclusion
- If Visibility problem, use volatile
- If compound operations, use Atomic variables

|Type   |Use Case   |
|---|---|
|Volatile   |Flags   |
|AtomicInteger, AtomicLong   |Counters   |
|AtomicReference   |Caches (building new cache in background and replacing atomically)   |
|AtomicReference   |Used by some internal classes   |
|AtomicReference   |non-blocking algorithms   |