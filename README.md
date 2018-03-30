## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  | 10000000           | 0.1355          |
| Using ReentrantLock     | 10000000           | 0.8335          |
| Syncronized method      | 10000000           | 0.7572          |
| AtomicLong for total    | 10000000           | 0.3805          |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)

1.1 The total it doesn't always zero. It's can be positive number or negative number between the limit. 

1.2 The average runtime is 0.01355 sec.

1.3 I think the threads don't finished at the same time, for example.
(threads-0 is positive number ,threads-1 is negative number)

If threads-0 is finish before threads-1 the results is positive number.
If threads-1 is finish before threads-0 the results is negative number.
If threads-0 and threads-1 have finished in the same time results is zero.

## 2. Implications for Multi-threaded Applications

Banking application can be withdraw, deposit or transfer money more than one action if you used application at same time like A withdraw 1000 Baht at the same time of B. they will get 2000 Baht from bank.

## 3. Counter with ReentrantLock

answer questions 3.1 - 3.4

3.1 It always zero,the average runtime is 0.83353 sec.(3 runtime)

3.2 Just change object to CounterWithLock.

3.3 ReentrantLock is lock the object for one threads to working.When finished the job it'll unlock the object for 	other threads to run. we're used ReentrantLock in object CounterWithLock that a subclass of Counter.

3.4 we're write "finally {lock.unlock();}" because when threads have finished running the method it'll unlock object 	to other threads to run.(Maybe the same threads will run code in object again)



## 4. Counter with synchronized method

answer question 4

4.1 total is zero ,and the average run 3 times is 0.75718 sec.

4.2 because we're used synchronized to object.

4.3 We're synchronized for modifier class for run one threads at the time.

## 5. Counter with AtomicLong

answer question 5

5.1 AtomicLong is create a object long that can update value automatically. 

5.2 We'll used AtomicLong(or AtomicDouble, AtomicInteger) when the program has threads to run the code that have long 	value(or double, int) that thread share the same object, because AtomicXXX has faster than synchronized or lock.

## 6. Analysis of Results

answer question 6

6.1 AtomicLong is fastest.
	ReentrantLock is slowest.
6.2 i think use the ReentrantLock is a better way for this situation because ReentrantLock do the same thing at 	synchronized but Lock can unlock cross the method that useful than synchronized and better than AtomicXXX, 	because AtomicXXX need class to know the object of variable for example.

the application have 4 threads and add item to store that have two method sortItem() and 	addItem() that 	we want to run one thread only for List. If i'm used AtomicXXX it'll be 	a 	hard code.Than if i'm used synchronized it's actually work but if you want to lock 	one thread in sortItem() and unlock when finished addItem() it's pretty useful than 	synchronized to used ReentrantLock.

		
	

## 7. Using Many Threads (optional)

