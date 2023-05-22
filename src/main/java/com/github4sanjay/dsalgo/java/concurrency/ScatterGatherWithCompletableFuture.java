package com.github4sanjay.dsalgo.java.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ScatterGatherWithCompletableFuture {

  public Set<Integer> scatterGather(Set<Product> products)
      throws InterruptedException, ExecutionException, TimeoutException {
    var prices = Collections.synchronizedSet(new HashSet<Integer>());
    var list = new CompletableFuture[prices.size()];
    int count = 0;
    for (var product : products) {
      var future =
          CompletableFuture.runAsync(new Task(product.getProductId(), product.getUrl(), prices));
      list[count] = future;
      count++;
    }

    CompletableFuture.allOf(list).get(10, TimeUnit.SECONDS);
    return prices;
  }

  public static class Task implements Runnable {
    private final String productId;
    private final String url;
    private final Set<Integer> prices;

    public Task(String productId, String url, Set<Integer> prices) {
      this.productId = productId;
      this.url = url;
      this.prices = prices;
    }

    @Override
    public void run() {
      int price = 0;
      // make http call
      prices.add(price);
    }
  }

  public static class Product {
    private final String productId;
    private final String url;

    public Product(String productId, String url) {
      this.productId = productId;
      this.url = url;
    }

    public String getProductId() {
      return productId;
    }

    public String getUrl() {
      return url;
    }
  }
}
