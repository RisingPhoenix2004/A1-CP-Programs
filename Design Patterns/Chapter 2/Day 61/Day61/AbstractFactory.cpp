#include <iostream>
#include <cstring>
using namespace std;

// Abstract product: Shape
class Shape {
public:
    virtual void draw() = 0;
};

// Concrete shapes
class Square : public Shape {
public:
    void draw() { cout << "Inside Square::draw() method." << endl; }
};

class Circle : public Shape {
public:
    void draw() { cout << "Inside Circle::draw() method." << endl; }
};

// Abstract product: Button
class Button {
public:
    virtual void click() = 0;
};

// Concrete buttons for different OS
class LinuxButton : public Button {
public:
    void click() { cout << "LinuxButton clicked!" << endl; }
};

class WindowsButton : public Button {
public:
    void click() { cout << "WindowsButton clicked!" << endl; }
};

class MacButton : public Button {
public:
    void click() { cout << "MacButton clicked!" << endl; }
};

// Abstract Factory
class AbstractFactory {
public:
    virtual Shape* getShape(const char* shapeType) { return nullptr; }
    virtual Button* getButton(const char* osType) { return nullptr; }
};

// ShapeFactory implementation
class ShapeFactory : public AbstractFactory {
public:
    Shape* getShape(const char* shapeType) override {
        if (!shapeType) return nullptr;
        if (strcmp(shapeType, "CIRCLE") == 0)
            return new Circle();
        else if (strcmp(shapeType, "SQUARE") == 0)
            return new Square();
        return nullptr;
    }
};

// ButtonFactory implementation
class ButtonFactory : public AbstractFactory {
public:
    Button* getButton(const char* osType) override {
        if (!osType) return nullptr;
        if (strcmp(osType, "LINUX") == 0)
            return new LinuxButton();
        else if (strcmp(osType, "WINDOWS") == 0)
            return new WindowsButton();
        else if (strcmp(osType, "MAC") == 0)
            return new MacButton();
        return nullptr;
    }
};

// FactoryProducer to get factories
class FactoryProducer {
public:
    static AbstractFactory* getFactory(const char* choice) {
        if (strcmp(choice, "SHAPE") == 0)
            return new ShapeFactory();
        else if (strcmp(choice, "BUTTON") == 0)
            return new ButtonFactory();
        return nullptr;
    }
};

int main() {
    // Get ShapeFactory
    AbstractFactory* shapeFactory = FactoryProducer::getFactory("SHAPE");
    Shape* shape1 = shapeFactory->getShape("CIRCLE");
    if (shape1) shape1->draw();
    Shape* shape2 = shapeFactory->getShape("SQUARE");
    if (shape2) shape2->draw();

    // Get ButtonFactory
    AbstractFactory* buttonFactory = FactoryProducer::getFactory("BUTTON");
    Button* btn1 = buttonFactory->getButton("LINUX");
    if (btn1) btn1->click();
    Button* btn2 = buttonFactory->getButton("WINDOWS");
    if (btn2) btn2->click();
    Button* btn3 = buttonFactory->getButton("MAC");
    if (btn3) btn3->click();

    return 0;
}

/*
#include <iostream>
using namespace std;
#include<cstring>
#define interface struct

interface Shape 
{	
    virtual void draw() = 0;
};
interface Button 
{
    virtual void button() = 0;
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

class WindowsButton : public Button {
  public:
    void button() {
      cout << "Inside windows button method" << endl;
    }
};

class LinuxButton : public Button {
  public : 
    void button(){
      cout << "Inside linux button method " << endl;
    }
};

interface AbstractFactory 
{
   virtual Shape * getShape(char * shape) {return NULL; };
   virtual Button * getButton(char * button)  { return NULL; };
};



class ShapeFactory : public AbstractFactory 
{
  public:
    Shape * getShape(char * shapeType)
    {   
      if(shapeType == NULL) {
        return NULL;
      }		      
      if(stricmp(shapeType, "CIRCLE") == 0)
      {
        return new Circle();       
      }
      else if(stricmp(shapeType, "SQUARE") == 0)
      {
        return new Square();
      }    
      return NULL;
    }
};

class ButtonFactory : public AbstractFactory {
  public:
    Button * getButton(char * buttonType){
      if(buttonType == NULL) {
        return NULL;
      }
      if(stricmp(buttonType, "WINDOWS") == 0){
        return new WindowsButton();
      } else if (stricmp(buttonType , "LINUX") == 0)
      {
        return new LinuxButton();
      }
      return NULL;
    }
};

class FactoryProducer 
{
  public:
    static AbstractFactory * getFactory(const char * choice)
    {   
      if(stricmp(choice, "SHAPE") == 0)
      {
         return new ShapeFactory();         
      }
      else if(stricmp(choice , "BUTTON") == 0){
        return new ButtonFactory();
      }   
      return NULL;
   }
};

int main() 
{
  //get shape factory
  AbstractFactory * shapeFactory = FactoryProducer::getFactory("SHAPE");

  //get an object of Shape Circle
  Shape * shape1 = shapeFactory->getShape("CIRCLE");

  //call draw method of Shape Circle
  shape1->draw();

  //get an object of Shape Square 
  Shape * shape2 = shapeFactory->getShape("SQUARE");

  //call draw method of Shape Square
  shape2->draw();


  AbstractFactory * ButtonFactory = FactoryProducer::getFactory("BUTTON");

  Button * b1 = ButtonFactory->getButton("WINDOWS");

  b1->button();

  Button * b2 = ButtonFactory->getButton("LINUX");

  b2->button();

}
*/
