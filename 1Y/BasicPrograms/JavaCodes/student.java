class Student {
    int id;
    String name;
    int age;

    void DisplayDetails (){
   System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }

    
    public static void main(String[] args) {
        
        Student s1 = new Student();
		s1.DisplayDetails();
		}
		
      


    }