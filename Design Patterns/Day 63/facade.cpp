#include <iostream>
using namespace std;
#define interface struct

interface Shape 
{	
    virtual void draw() = 0;
};

class Square : public Shape 
{
  public:
    void draw() {
      cout << "Inside Square::draw() method." << endl;
  }
};

class Circle : public Shape 
{
  public:
    void draw() {
      cout << "Inside Circle::draw() method." << endl;
  }
};

class Rectangle : public Shape 
{
  public:
    void draw() {
      cout << "Inside Rectangle::draw() method." << endl;
  }
};

class Hexagon : public Shape 
{
  public:
    void draw() {
      cout << "Inside Hexagon::draw() method." << endl;
  }
};

class ShapeMaker {
  private:
    Shape *circle;
    Shape *rectangle;
    Shape *square;
    Shape *hexagon;
  
  public:
    ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
      hexagon = new Hexagon();
    }

    void drawCircle(){
      circle->draw();
    }

    void drawRectangle(){
      rectangle->draw();
    }

    void drawSquare(){
      square->draw();
    }

    void drawHexagon(){
      hexagon->draw();
    }


};

int main() 
{
  ShapeMaker shapeMaker; 

  shapeMaker.drawCircle();
  shapeMaker.drawRectangle();
  shapeMaker.drawSquare();
  shapeMaker.drawHexagon();
  return 0;
}