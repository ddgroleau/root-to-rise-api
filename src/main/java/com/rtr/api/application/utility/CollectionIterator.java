package com.rtr.api.application.utility;

import com.rtr.api.application.dto.IngredientDto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionIterator {
    public static <T,K> Stream<T> distinctByKey(Stream<T> items, Function keyMapper) {
        return ((Map<K,T>)items.collect(Collectors.toMap(
                keyMapper,
                item -> item,
                (existing, replacement) -> existing
                )))
                .values()
                .stream();
    }
}
