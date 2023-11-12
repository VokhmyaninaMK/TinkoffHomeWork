package edu.hw2;

public class Task2 {
    public static class Rectangle {
        protected int width;
        protected int height;

        public Rectangle() {
        }

        Rectangle(int height, int weight) {
            this.height = height;
            this.width = weight;
        }

        int getWidth() {
            return this.width;
        }

        int getHeight() {
            return this.height;
        }

        Rectangle setWidth(int width) {
            this.width = width;
            return this;
        }

        Rectangle setHeight(int height) {
            this.height = height;
            return this;
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        public Square() {
        }

        public Square(int side) {
            super(side, side);
        }

        @Override
        Rectangle setWidth(int width) {
            Rectangle newRectangle = new Rectangle();
            newRectangle.setWidth(width);
            newRectangle.setHeight(newRectangle.getHeight());
            return newRectangle;
        }

        @Override
        Rectangle setHeight(int height) {
            Rectangle newRectangle = new Rectangle();
            newRectangle.setHeight(height);
            newRectangle.setWidth(newRectangle.getWidth());
            return newRectangle;
        }

        void setSideLength(int length) {
            this.setWidth(length);
            this.setHeight(length);
        }
    }
}
