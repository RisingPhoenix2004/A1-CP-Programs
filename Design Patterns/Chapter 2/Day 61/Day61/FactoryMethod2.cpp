#include <iostream>
using namespace std;

// Abstract base product
class Widget {
  public:
    virtual void draw() = 0;
};

// Concrete product family 1
class LinuxButton : public Widget {
  public:
    void draw() { cout << "LinuxButton\n"; }
};

// Concrete product family 2
class WindowsButton : public Widget {
  public:
    void draw() { cout << "WindowsButton\n"; }
};

// Concrete product family 3 (Mac support added)
class MacButton : public Widget {
  public:
    void draw() { cout << "MacButton\n"; }
};

// Abstract factory
class Factory {
  public:
    virtual Widget *create_button() = 0;
};

// Concrete factories
class LinuxFactory : public Factory {
  public:
    Widget *create_button() {
      return new LinuxButton;
    }
};

class WindowsFactory : public Factory {
  public:
    Widget *create_button() {
      return new WindowsButton;
    }
};

// Mac factory added
class MacFactory : public Factory {
  public:
    Widget *create_button() {
      return new MacButton;
    }
};

int main() {
  Factory *factory;

  factory = new LinuxFactory;
  Widget *w = factory->create_button();
  w->draw();

  factory = new WindowsFactory;
  w = factory->create_button();
  w->draw();

  factory = new MacFactory;
  w = factory->create_button();
  w->draw();

  return 0;
}
