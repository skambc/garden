package com.skambc.memcached;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

public class TestSpymemcached {
	public static void main(String[] args) throws Exception {
		String address = "192.168.71.128:11211";
		MemcachedClient client = new MemcachedClient(
				new BinaryConnectionFactory(), AddrUtil.getAddresses(address));
		
		String key = "magic_words";
		int exp = 3600;
		String o = "hello";
		// set
		OperationFuture<Boolean> setFuture = client.set(key, exp, o);
		if (setFuture.get()) {
			System.out.println(client.get("userId"));
			// get
			System.out.println(client.get(key));
			// append
			client.append(key, " the world!");
			System.out.println(client.get(key));
			// prepend
			client.prepend(key, "Stone, ");
			System.out.println(client.get(key));

			// replace
			o = "This is a test for spymemcached.";
			OperationFuture<Boolean> replaceFuture = client
					.replace(key, exp, o);
			if (replaceFuture.get()) {
				System.out.println(client.get(key));

				// delete
//				client.delete(key);
//				System.out.println(client.get(key));
			}
		}

		client.shutdown();
	}

}
