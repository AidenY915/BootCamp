var Rectangle = /** @class */ (function () {
    function Rectangle() {
        this.base = 0;
        this.height = 0;
    }
    Rectangle.prototype.getBase = function () {
        return this.base;
    };
    Rectangle.prototype.setBase = function (base) {
        this.base = base;
    };
    Rectangle.prototype.getHeight = function () {
        return this.height;
    };
    Rectangle.prototype.setHeight = function (height) {
        this.height = height;
    };
    Rectangle.prototype.getPerimeter = function () {
        return (this.base + this.height) * 2;
    };
    Rectangle.prototype.getArea = function () {
        return this.base * this.height;
    };
    return Rectangle;
}());
var rect = new Rectangle();
rect.setBase(10);
rect.setHeight(20);
console.log(rect.getPerimeter(), rect.getArea());
