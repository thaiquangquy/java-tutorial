- An unfair lock does not guarantee the order in which threads waiting to lock the lock will be given access to lock it. That means, that a waiting thread could risk waiting forever, if other threads keep trying to lock the lock, and are given priority over the waiting thread. This situation can lead to starvation.
- The ReentrantLock behaviour is unfair by default. However, you can tell it to operate in fair mode via its constructor. The ReentrantLock class has a constructor that takes a boolean parameter specifying whether the ReentrantLock should provide fairness or not to waiting threads.
  - With that flag the order they try to acquire the lock will be considered when the lock is given
  - Useful when you have a lot of threads
- The method tryLock() with no parameters does not respect the fairness mode of the ReentrantLock. To get fairness, you must use the tryLock(long timeout, TimeUnit unit) method instead, like this: lock.tryLock(0, TimeUnit.SECONDS);

| Feature / Behavior                                           | `synchronized`                                                   | `Lock` (e.g. `ReentrantLock`)                                                      |
|--------------------------------------------------------------|------------------------------------------------------------------|------------------------------------------------------------------------------------|
| **Thread access order guarantee (Fairness)**                 | ❌ No fairness guarantee                                          | ✅ Can be fair with `new ReentrantLock(true)`                                       |
| **Timeout while acquiring lock**                             | ❌ Not supported                                                  | ✅ Supported via `tryLock(timeout, unit)`                                           |
| **Passing parameters to locking mechanism**                  | ❌ Not possible                                                   | ✅ Possible via method parameters like `tryLock(...)`                               |
| **Lock/unlock in different methods**                         | ❌ Must be in the same method                                     | ✅ `lock()` and `unlock()` can be in different methods                              |
| **Visibility / happens-before guarantee**                    | ✅ Provided automatically when entering/exiting the block         | ✅ Provided explicitly when calling `lock()` and `unlock()`                         |
| **Reentrancy**                                               | ✅ Always reentrant                                               | ✅ Reentrant by default (in `ReentrantLock`), ❌ optional otherwise by implement own |
| **Fairness configuration**                                   | ❌ Not configurable                                               | ✅ Fairness is configurable via constructor                                         |
