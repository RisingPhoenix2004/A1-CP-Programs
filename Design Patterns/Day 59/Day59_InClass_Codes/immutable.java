/* How to create read only objects that can be shared and used by multiple classes.
1) Use a constructor to set all properties of the object
2) Mark all instance variables private and final
3) Don't define any setter methods
4) Don't allow any referenced mutable objects to be modified or accessed directly
5) Prevent methods from being overridden
*/

final class Contacts {
  private final String name;
  private final String mobile;

  public Contacts(String name, String mobile) {
    this.name = name;
    this.mobile = mobile;
  }

  public String getName(){
    return name;
  }

  public String getMobile(){
    return mobile;
  }
}

class test {
  public static void main(String[] args) {
    Contacts obj = new Contacts("Ram", "9876543210");
    System.out.println(obj.getName());
    System.out.println(obj.getMobile());
  }
}