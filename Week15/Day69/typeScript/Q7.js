var __extends =
  (this && this.__extends) ||
  (function () {
    var extendStatics = function (d, b) {
      extendStatics =
        Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array &&
          function (d, b) {
            d.__proto__ = b;
          }) ||
        function (d, b) {
          for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p];
        };
      return extendStatics(d, b);
    };
    return function (d, b) {
      if (typeof b !== "function" && b !== null)
        throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
      extendStatics(d, b);
      function __() {
        this.constructor = d;
      }
      d.prototype = b === null ? Object.create(b) : ((__.prototype = b.prototype), new __());
    };
  })();
var Rectangle = /** @class */ (function () {
  function Rectangle(base, height) {
    this.base = base;
    this.height = height;
    if (base < 0 || height < 0) throw new Error("길이는 양수이어야 함.");
  }
  Rectangle.prototype.getPerimeter = function () {
    return (this.base + this.height) * 2;
  };
  Rectangle.prototype.getArea = function () {
    return this.base * this.height;
  };
  return Rectangle;
})();
var Square = /** @class */ (function (_super) {
  __extends(Square, _super);
  function Square(base) {
    return _super.call(this, base, base) || this;
  }
  return Square;
})(Rectangle);
var rect;
var square;
try {
  rect = new Rectangle(-10, 20);
  square = new Square(-10);
  console.log(rect.getPerimeter(), rect.getArea());
  console.log(square.getPerimeter(), square.getArea());
} catch (e) {
  console.log(e);
}
