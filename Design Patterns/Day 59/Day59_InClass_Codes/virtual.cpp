#include <iostream>
using namespace std;
class Shape{
	public:
	void draw() {
		cout<<"Shape called";
	};
};
class Circle : public Shape
{
	public:
		void draw(){
			cout<<"Circle";
	}
};
class Rectangle : public Shape
{
	public:
		void draw(){
			cout<<"Rectangle";
	}
};
int main(){
	Shape *s = new Rectangle();
	s->draw();
	return 0;
}
