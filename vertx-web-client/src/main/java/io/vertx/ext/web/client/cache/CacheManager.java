package io.vertx.ext.web.client.cache;

import io.vertx.ext.web.client.HttpResponse;

/**
 * Abstracts caching of HTTP requests and responses
 *
 * @author Alexey Soshin
 */
public interface CacheManager<K> {

  /**
   * Clears the cache completely
   */
  void flush();

  /**
   * Attempts to fetch value corresponding to request from cache
   *
   * @param cacheKey key based on HTTP request
   * @return cached HTTP response or Optional.empty
   */
  HttpResponse<Object> fetch(K cacheKey);

  /**
   * Puts new value in cache, where the key is based on request and value on response
   *
   * @param cacheKey key based on HTTP requests request that was issues
   * @param response HTTP response to be associated
   */
  void put(K cacheKey, HttpResponse<Object> response);

  /**
   * Removes value from cache corresponding to request key
   *
   * @param cacheKey key based on HTTP requests that should be removed from cache
   */
  void remove(K cacheKey);
}
