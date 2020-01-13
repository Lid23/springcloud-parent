package com.noodles.redis.v1.config;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noodles.log.MySlf4j;

/**
 * @filename RedissonClientTemplate
 * @description 分布式锁客户端
 * @autor Eric
 * @date 2019/6/1 21:51
 */
@Component
public class RedissonClientTemplate {

	@Autowired
	private RedissonClient redissonClient;
	/**锁默认失效时间(单位:秒)*/
	public static final long LOCK_EXPIRE = 20L;


	/**
	 * 加锁
	 * @param lockKey 锁名称
	 * @return org.redisson.api.RLock
	 * @author Eric
	 * @date 2019/6/3 8:41
	 */
	public RLock lock(String lockKey) {
		RLock lock = redissonClient.getLock(lockKey);
		lock.lock(LOCK_EXPIRE, TimeUnit.SECONDS);
		lock.lock();
		return lock;
	}


	/**
	 * 加锁
	 * @param lockKey 锁名称
	 * @param leaseTime 锁失效时间（单位：秒）
	 * @return org.redisson.api.RLock
	 * @author Eric
	 * @date 2019/6/3 8:42
	 */
	public RLock lock(String lockKey, long leaseTime) {
		RLock lock = redissonClient.getLock(lockKey);
		lock.lock(leaseTime, TimeUnit.SECONDS);
		return lock;
	}

	/**
	 * 加锁
	 * @param lockKey 锁名称
	 * @param unit 时间单位
	 * @param timeout 加锁时间（时间单位由unit确定）
	 * @return org.redisson.api.RLock
	 * @author Eric
	 * @date 2019/6/3 8:43
	 */
	public RLock lock(String lockKey, TimeUnit unit, long timeout) {
		RLock lock = redissonClient.getLock(lockKey);
		lock.lock(timeout, unit);
		return lock;
	}

	/**
	 * 加锁
	 * 获取锁定（如果可用）并立即返回值true。
	 * 如果锁定不可用，则此方法将立即返回值false
	 * @param lockKey 锁名称
	 * @param unit 时间单位
	 * @param waitTime 等待时间（时间单位由unit确定）
	 * @param leaseTime 失效时间（时间单位由unit确定）
	 * @return boolean
	 * @author Eric
	 * @date 2019/6/3 8:45
	 */
	public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
		RLock lock = redissonClient.getLock(lockKey);
		try {
			return lock.tryLock(waitTime, leaseTime, unit);
		} catch (InterruptedException e) {
			return false;
		}
	}

	/**
	 * 解锁
	 * @param lockKey 锁名称
	 * @return void
	 * @author Eric
	 * @date 2019/6/3 8:46
	 */
	public void unlock(String lockKey) {
		/**优化解锁代码避免出现：attempt to unlock lock, not locked by current thread by node id:xx异常*/
		RLock lock = redissonClient.getLock(lockKey);
		boolean locked = false;
		try {
			locked = lock.tryLock();
			if (locked) {
				lock.unlock();
			}
		} catch (Exception ex) {
			MySlf4j.textError("Redisson解锁异常：{0}", MySlf4j.ExceptionToString(ex));
		} finally {
			if (locked) {
				lock.unlock();
			}
		}
	}

	/**
	 * 解锁
	 * @param lock lock对象
	 * @return void
	 * @author Eric
	 * @date 2019/6/3 8:47
	 */
	public void unlock(RLock lock) {
		lock.unlock();
	}

}
