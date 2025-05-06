public class StaffHire

{

private int vacancyNumber;
 private String designation; 
 private String jobType; 
 private String staffName;
 private String joiningDate;
 private String qualification;
 private String appointedBy;
 private boolean joined;
 
 public StaffHire(
 int VacancyNumber,
 String Designation,
String JobType,
String StaffName,
String JoiningDate,
String Qualification,
String AppointedBy, 
boolean Joined
)
{


this.vacancyNumber = VacancyNumber ;
this.designation = Designation;
this.jobType = JobType ;
this.staffName = "";
this.joiningDate = "";
this.qualification = "";
this.appointedBy = "";
this.joined = false;
}

public void setVacancyNumber(){
}

public int GetVacancyNumber(){
      return vacancyNumber;
}

public void setDesignation(){
}

public String GetDesignation(){
        return designation;
    }
  public void SetJobType(){
    }
  
public String GetJobType(){
      return jobType;
}
public void SetStaffName(){
}

public String GetStaffName(){
       return staffName;  
    }
 public void SetJoiningDate(){
    }
 
public String GetJoiningDate(){
     return joiningDate;
    }
public void SetQualification(){
}
public String GetQualification(){
     return qualification;
}
public void SetAppointedBy(){
}
 public String GetAppointedBy(){
      return appointedBy;
    }
    
public void SetJoined(){
}

public boolean GetJoined(){
     return joined;     
    }


public void setStaffName(String staffName) 
{  
  this.staffName = staffName;  
} 
public void setJoiningDate(String joiningDate)  
{  
  this.joiningDate = joiningDate;  
} 
public void setQualification(String qualification)  
{  
  this.qualification = qualification;  
} 
public void setAppointedBy(String appointedBy)  
{  
  this.appointedBy = appointedBy;  
} 
public void setJoined(boolean joined)  
{  
  this.joined = joined;  
} 
public void amendJoinedStatus(boolean NewJoined) 
{ 
  if (this.joined != NewJoined) 
{ 
this.joined = NewJoined; 
System.out.println("Joined status has been amended " + NewJoined); 
        
} 
             
else 
{ 

System.out.println("Joined status is already"+ NewJoined);}
}
public void display()  
    
{ 
System.out.println("Vacancy Number: " + 
vacancyNumber); 
     
System.out.println("Designation: " + designation); 
         
System.out.println("Job Type: " + jobType); 
if (joined) { 
System.out.println("Staff Name: " + staffName); 
System.out.println("Joining Date: " + joiningDate); 
         
System.out.println("Qualification: " + qualification); 
       
System.out.println("Appointed By: " + appointedBy); 
}        
else { 
System.out.println("No staff has joined for this vacancy."); 
 
} 
}
}


