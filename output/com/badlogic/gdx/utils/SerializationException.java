/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;

public class SerializationException
extends RuntimeException {
    private StringBuilder trace;

    public SerializationException() {
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(Throwable cause) {
        super("", cause);
    }

    public boolean causedBy(Class type) {
        return this.causedBy(this, type);
    }

    private boolean causedBy(Throwable ex, Class type) {
        Throwable cause = ex.getCause();
        if (cause == null || cause == ex) {
            return false;
        }
        if (type.isAssignableFrom(cause.getClass())) {
            return true;
        }
        return this.causedBy(cause, type);
    }

    @Override
    public String getMessage() {
        if (this.trace == null) {
            return super.getMessage();
        }
        StringBuilder sb = new StringBuilder(512);
        sb.append(super.getMessage());
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append("Serialization trace:");
        sb.append(this.trace);
        return sb.toString();
    }

    public void addTrace(String info) {
        if (info == null) {
            throw new IllegalArgumentException("info cannot be null.");
        }
        if (this.trace == null) {
            this.trace = new StringBuilder(512);
        }
        this.trace.append('\n');
        this.trace.append(info);
    }
}

