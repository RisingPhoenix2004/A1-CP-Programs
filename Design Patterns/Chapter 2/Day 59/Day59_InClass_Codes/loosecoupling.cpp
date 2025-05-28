#include <iostream>
#include <string>
using namespace std;
#define interface struct

interface vehicle
{
  virtual void travel() = 0;
};

class Car : public vehicle
{
  public:
    void travel(){
      cout << "travel by Car" << endl;
    }
};

class Plane : public vehicle{
  public:
    void travel(){
      cout << "travel by Plane" << endl;
    }
};

class tourist {
  vehicle *vobj;
  public:
    void setVehicle(vehicle* V) {
      this->vobj = V;
    }
    void startJourney() {
      vobj->travel();
    }
};

int main()
{
  vehicle* vobj = new Car();   // replace Car with Plane and test
  tourist tobj;
  tobj.setVehicle(vobj);
  tobj.startJourney();
  return 0;
}
