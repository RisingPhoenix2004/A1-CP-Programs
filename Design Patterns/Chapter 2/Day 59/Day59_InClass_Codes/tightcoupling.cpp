#include <iostream>
#include <string>
using namespace std;

class Car 
{
  public:
    void travel(){
      cout << "travel by Car" << endl;
    }
};

class Plane 
{
  public:
    void travel(){
      cout << "travel by Plane" << endl;
    }
};

class tourist {
  // Will need to change this code when we change from Car to Plane
  Car c;
  public:
  void travel() {
    c.travel();
  }

};

int main()
{
  tourist obj;
  obj.travel();
  return 0;
}
