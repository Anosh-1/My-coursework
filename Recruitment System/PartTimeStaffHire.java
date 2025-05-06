public class PartTimeStaffHire extends StaffHire {            
private int workingHour; 
private double wagesPerHour; 
private String shifts; 
private boolean terminated; 
public PartTimeStaffHire(int vacancyNumber, String designation, String 
jobType, String staffName, String joiningDate, String qualification, String 
appointedBy, boolean joined, int workingHour, double wagesPerHour, String 
shifts)  
{ 
super(vacancyNumber, designation, jobType, staffName, joiningDate, 
qualification, appointedBy, joined); 
setStaffName(staffName); 
setJoiningDate(joiningDate); 
setQualification(qualification); 
setAppointedBy(appointedBy); 
setJoined(joined); 
this.workingHour = workingHour; 
this.wagesPerHour = wagesPerHour; 
this.shifts = shifts; 
this.terminated = false; 
     } 
  
     public int getWorkingHour()  
     {  
         return workingHour;
     } 
      
  
     public double getWagesPerHour()  
     {  
         return wagesPerHour; 
             }      
 
     public String getShifts()  
     {  
         return shifts; 
     } 
      
 
     public boolean isTerminated()  
     {  
         return terminated;
     } 
 
     public void setShifts(String newShifts) { 
         
if (GetJoined()) { 
this.shifts = newShifts; 
} else { 
System.out.println("Cannot change shifts. Staff has not joined."); 
} 
     } 
  
     public void terminate() { 
           
if (!terminated) {
setStaffName(""); 
setJoiningDate(""); 
setQualification(""); 
setAppointedBy(""); 
setJoined(false); 
terminated = true; 
System.out.println("Staff terminated."); 
} 
else
{

System.out.println("Staff is already terminated."); 
}
}

     @Override 
     public void display() { 
super.display(); 
if (GetJoined()) { 
System.out.println("Wages Per Hour: " + wagesPerHour); 
System.out.println("Working Hours Per Day: " + workingHour); 
System.out.println("Shifts: " + shifts); 
System.out.println("Income Per Day: " + (wagesPerHour * workingHour)); 
System.out.println("Terminated: " + terminated);
}
}
}
