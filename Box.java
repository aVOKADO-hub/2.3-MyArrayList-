package org.example;

import java.util.Objects;

public class Box {
    private final int _width;
    private final int _length;
    private final int _height;

    public Box(int width, int length, int height) {
        this._width = width;
        this._length = length;
        this._height = height;
    }
    public int getVolume(){
        return this._width*this._height*this._length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return _width == box._width && _length == box._length && _height == box._height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_width, _length, _height);
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + _width +
                ", length=" + _length +
                ", height=" + _height +
                '}';
    }
}
