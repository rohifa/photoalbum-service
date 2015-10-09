package com.mgu.photoalbum.converter;

public interface BiConverter<I1, I2, O> {

    O convert(I1 input1, I2 input2);
}