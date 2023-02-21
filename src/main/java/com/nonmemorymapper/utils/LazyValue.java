package com.nonmemorymapper.utils;

import java.util.function.Supplier;

public class LazyValue implements Value {

    private final Supplier<Object> valueSupplier;
    private Object value;

    public LazyValue(Supplier<Object> valueSupplier) {
        this.valueSupplier = valueSupplier;
    }

    @Override
    public Object getValue() {
        if (value == null) {
            value = valueSupplier.get();
        }
        return value;
    }
}
