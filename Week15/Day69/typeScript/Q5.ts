class Rectangle {
  private base: number;
  private height: number;
  constructor() {
    this.base = 0;
    this.height = 0;
  }
  getBase() {
    return this.base;
  }
  setBase(base: number) {
    this.base = base;
  }
  getHeight() {
    return this.height;
  }
  setHeight(height: number) {
    this.height = height;
  }

  getPerimeter() {
    return (this.base + this.height) * 2;
  }
  getArea() {
    return this.base * this.height;
  }
}

let rect: Rectangle = new Rectangle();
rect.setBase(10);
rect.setHeight(20);
console.log(rect.getPerimeter(), rect.getArea());
