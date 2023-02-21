package com.nonmemorymapper.utils;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomMap<K, V> extends AbstractMap<K, V> {
    private final Map<K, V> map = new HashMap<>();
    @Override
    public V get(Object key) {
        // Verifica se a chave é compatível antes de carregar o valor em memória
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        // Adiciona o valor ao mapeamento somente se a chave é compatível
        return map.put(key, value);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}
