package concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ScatterGatherWithCountDownLatch {

    public Set<Integer> scatterGather(Set<Product> products) throws InterruptedException, ExecutionException, TimeoutException {
        var prices = Collections.synchronizedSet(new HashSet<Integer>());
        var countDownLatch = new CountDownLatch(products.size());
        for (var product : products) {
            new Task(product.getProductId(), product.getUrl(), prices, countDownLatch).run();
        }

        countDownLatch.await(10, TimeUnit.SECONDS);
        return prices;
    }

    public static class Task implements Runnable{
        private final String productId;
        private final String url;
        private final Set<Integer> prices;
        private final CountDownLatch countDownLatch;

        public Task(String productId, String url, Set<Integer> prices, CountDownLatch countDownLatch) {
            this.productId = productId;
            this.url = url;
            this.prices = prices;
            this.countDownLatch = countDownLatch;
        }


        @Override
        public void run() {
            int price = 0;
            // make http call
            prices.add(price);
            countDownLatch.countDown();
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
