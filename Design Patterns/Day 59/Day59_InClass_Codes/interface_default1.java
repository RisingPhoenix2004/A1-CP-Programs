import static java.lang.Math.*;

interface Shape
{
  default double getDouble()
  {
    return 10;
  }
  double area();
}

class Circle implements Shape
{
  public double area()
  {
    double radius = getDouble();
    return (PI * radius * radius);
  }
}

class test 
{   	  
  public static void main(String[] args)
  {
    Circle obj = new Circle();
    System.out.println(obj.area());
  }
}
