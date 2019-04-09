package com.kasiyanov.internationalizationdatabase.entity;

import java.io.Serializable;

public interface Attribute<T extends Serializable> {

    T getName();
}
