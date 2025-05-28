#include <iostream>
#include <string>
using namespace std;

// Low cohesiveness (as one class does everything)
class all {
  public:
    void writeToFile();
    void connectToDB();
    void generateReport();
    void displayCharts();
    void printData();    
};

// Higher cohesiveness as each class does a specific thing
class saveData {
  public:
    void writeToFile();  
};

class databaseConnection {
  public:
    void connectToDB();  
};

class reportGeneration {
  public:    
    void generateReport();
};

class chartsGeneration {
  public:  
    void displayCharts();
};

class printing {
  public:    
    void printData();
};

int main()
{
	return 0;
}
