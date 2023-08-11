/*
 * package Chapter7;
 * 
 * class Parent { int x=100; Parent() { this(200); } Parent(int x) { this.x = x;
 * } int getX() { return x; } } class Child extends Parent { int x = 3000;
 * Child() { this(1000); } Child(int x) { this.x = x; } }
 * 
 * public class Q7 {
 * 
 * public static void main(String[] args) { Child c = new Child();
 * System.out.println("x="+c.getX()); }
 * 
 * } // 생성자 순서 Parent(int x) Parent() Child(int x) Child()
 * 
 * 
 * Q8 a Q9 c 오버라이딩을 할 수 없음.
 * 
 */