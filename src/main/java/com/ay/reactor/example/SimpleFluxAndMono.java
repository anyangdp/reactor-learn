package com.ay.reactor.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @Author anyang
 * @CreateTime 2020/11/20
 * @Des
 */
public class SimpleFluxAndMono {
    public static void main(String[] args) {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar", "132ff").map(i -> {
           if  (!i.equals("foobar")) {
               return i;
           } else {
               throw new RuntimeException("foobar");
           }
        });
        seq1.subscribe(n -> System.out.println(n), error -> {
            System.err.println("Error: " + error);
        });
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);

        Mono<String> noData = Mono.empty();
        Mono<String> data = Mono.just("foo");
        Flux<Integer> numbersFromFiveToSeven = Flux.range(10, 3);
        numbersFromFiveToSeven.subscribe(n -> {
            System.out.println(n);
        });
    }
}
