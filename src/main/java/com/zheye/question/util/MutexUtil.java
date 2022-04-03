package com.zheye.question.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fzq
 */
public class MutexUtil {

   private static final Map<Object, ReentrantLock> mutexCache = new ConcurrentHashMap<>();

    public static <T> void exec(T key, Runnable runnable) {
        ReentrantLock mutex4Key = null;
        ReentrantLock mutexInCache;

        //region 获取锁
        do {
            if (mutex4Key != null) {
                mutex4Key.unlock();
            }
            mutex4Key = mutexCache.computeIfAbsent(key, k -> new ReentrantLock());
            mutex4Key.lock();
            mutexInCache = mutexCache.get(key);
        } while (mutexInCache == null || mutexInCache != mutex4Key);
        //endregion

        try {
            runnable.run();
        } finally {
            if (mutex4Key.getQueueLength() == 0) {
                mutexCache.remove(key);
            }
            mutex4Key.unlock();
        }
    }
}
