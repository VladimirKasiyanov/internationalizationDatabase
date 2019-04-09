package com.kasiyanov.internationalizationdatabase.entity;

import java.util.Set;

public interface Item<T extends Attribute> {

    Set<T> getAttributes();
}
