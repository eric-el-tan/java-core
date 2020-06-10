

## Thread
- Why multithread, to fullly utilize multi-core processing power. 

- 13.2 [Multithreading in Java Practical](https://www.youtube.com/watch?v=Xj1uYKa8rIw): ThreadDemo 
- 13.3 [Multithreading using Runnable Interface](https://www.youtube.com/watch?v=xvXbvrUUGMM): RunnableDemo
- 13.4 [MultiThreading using Lambda Expression](https://www.youtube.com/watch?v=VDYSgjPxu18): LambdaDemo

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