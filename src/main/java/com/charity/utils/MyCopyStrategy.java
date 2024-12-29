package com.charity.utils;

import net.sf.ehcache.Element;
import net.sf.ehcache.store.compound.ReadWriteCopyStrategy;

import java.io.Serializable;

/**
 * 优化存储策略
 * <p>

 *
 * 
 */
public class MyCopyStrategy implements ReadWriteCopyStrategy<Element> {
    @Override
    public Element copyForWrite(Element value) {
        if (value != null) {
            Object temp = value.getObjectValue();
            return new Element(value.getObjectKey(), temp);
        }
        return value;
    }

    @Override
    public Element copyForRead(Element storedValue) {
        if (storedValue != null) {
            Object temp = storedValue.getObjectValue();
            return new Element(storedValue.getObjectKey(), temp);
        }
        return storedValue;
    }
}