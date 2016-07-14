package com.example.administrator.okhttpdemo.cache;

import java.io.File;
import java.io.IOException;

import android.content.Context;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

/**
 * https://www.zhihu.com/question/38215672/answer/75374451
 * 
 * @author Administrator
 * 
 */

public class AppOkHttpClient extends OkHttpClient {

	private final String HTTP_CACHE_FILENAME = "HttpCache";

	public AppOkHttpClient(Context Context) {
		File httpCacheDirectory = new File(Context.getCacheDir().getAbsolutePath(), HTTP_CACHE_FILENAME);
		Cache cache;
		cache = new Cache(httpCacheDirectory, 10 * 1024);
		setCache(cache);
		networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);
	}

	private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
		@Override
		public Response intercept(Chain chain) throws IOException {
			Response originalResponse = chain.proceed(chain.request());
			return originalResponse.newBuilder().removeHeader("Pragma")
					.header("Cache-Control", String.format("max-age=%d", 60))
					.build();
		}
	};
}
