public class FullTimeStaffHire extends StaffHire {          
private double salary; 
private int weeklyFractionalHours; 
public FullTimeStaffHire(int vacancyNumber, String designation, String 
jobType, String staffName, String joiningDate, String qualification, String 
appointedBy, boolean joined, double salary, int weeklyFractionalHours)  
{ 
super(vacancyNumber, designation, jobType, staffName, joiningDate, 
qualification, appointedBy, joined); 
this.salary = salary; 
this.weeklyFractionalHours = weeklyFractionalHours; 
     } 
  
     public double getSalary()  
     {  
        return salary;
    }  
     public int getWeeklyFractionalHours()  
     {  
         return weeklyFractionalHours;  
    }
      public void setSalary(double newSalary)  
     { 
            
if (GetJoined())  
{ 
  
this.salary = newSalary; 
}
else  
{ 
System.out.println("The salary can't be set There is no staff at this position."); 
         
     } 
 
  
} 
     public void setWeeklyFractionalHours(int newHours) 
     { 
         
    this.weeklyFractionalHours = newHours; 
}
     @Override 
     public void display()  
     {              
super.display(); 
if (GetJoined()) { 
System.out.println("Salary: " + salary); 
System.out.println("Weekly Hours: " + weeklyFractionalHours);         
} 
   }  
}