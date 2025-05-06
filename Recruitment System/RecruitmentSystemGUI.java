import java.awt.*; 
import java.util.ArrayList; 
import javax.swing.*; 

 public class RecruitmentSystemGUI { 
        
private JFrame frame; 
private ArrayList<StaffHire> staffList = new ArrayList<>(); 
public RecruitmentSystemGUI() { 
frame = new JFrame("Recruitment System"); 
frame.setSize(400, 300); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.setLocationRelativeTo(null); 
JPanel panel = new JPanel(); 
panel.setLayout(new GridLayout(5, 1, 10, 10)); 
JButton btnFullTime = new JButton("Full-Time Staff"); 
JButton btnPartTime = new JButton("Part-Time Staff"); 
JButton btnDisplay = new JButton("Display All Staff"); 
JButton btnExit = new JButton("Exit"); 
panel.add(btnFullTime); 
panel.add(btnPartTime); 
panel.add(btnDisplay); 
panel.add(btnExit); 
 
frame.add(panel); 
frame.setVisible(true); 
btnFullTime.addActionListener(e -> showFullTimeOptions()); 
btnPartTime.addActionListener(e -> showPartTimeOptions()); 
btnDisplay.addActionListener(e -> displayAll()); 
btnExit.addActionListener(e -> System.exit(0));
} 
     private void showFullTimeOptions() { 
     
String[] options = {"Add Staff", "Cancel"}; 
int choice = JOptionPane.showOptionDialog(null, "Select Full-Time Staff Option:", "Full-Time Options", 
JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
null, options, options[0]); 
if (choice == 0) { 
showFullTimeForm(); 
}
}      
private void showPartTimeOptions() { 
  
String[] options = {"Add Staff", "Terminate Staff", "Cancel"}; 
int choice = JOptionPane.showOptionDialog(null, "Select Part-Time Staff Option:", "Part-Time Options", 
JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
null, options, options[0]); 
         
if (choice == 0) { 
         
        showPartTimeForm();      
         
     } else if (choice == 1) { 
terminatePartTime(); 
} 
}
     private void showFullTimeForm() { 
                     
JTextField[] fields = createInputFields("Vacancy No", "Designation", "Job Type", "Staff Name", "Joining Date", "Qualification", "Appointed By", "Salary","Weekly Hours"); 
int result = JOptionPane.showConfirmDialog(null, fields, "Full-Time Staff Form", JOptionPane.OK_CANCEL_OPTION); 
if (result == JOptionPane.OK_OPTION) { 
try { 
int vacancyNo = Integer.parseInt(fields[0].getText()); 
for (StaffHire staff : staffList) { 
if (staff.GetVacancyNumber() == vacancyNo) { 
JOptionPane.showMessageDialog(null, "Vacancy Number already exists.");  
return; 
} 
}
FullTimeStaffHire fullTime = new FullTimeStaffHire(vacancyNo, fields[1].getText(), fields[2].getText(), "", "", "", "", false, 
Double.parseDouble(fields[7].getText()), 
                     
Integer.parseInt(fields[8].getText())
); 
fullTime.setStaffName(fields[3].getText()); 
fullTime.setJoiningDate(fields[4].getText()); 
fullTime.setQualification(fields[5].getText()); 
fullTime.setAppointedBy(fields[6].getText()); 
fullTime.setJoined(true); 
staffList.add(fullTime); 
JOptionPane.showMessageDialog(null, "Full-Time Staff Added!"); 
} catch (Exception e) { 
JOptionPane.showMessageDialog(null, "Invalid Input. Try Again."); 
} 
} 
}
private void showPartTimeForm(){ 
               
JTextField[] fields = createInputFields("Vacancy No", "Designation", "Job Type", "Staff Name", "Joining Date", "Qualification","Appointed By", "Working Hours", "Wages Per Hour", "Shift"); 
int result = JOptionPane.showConfirmDialog(null, fields, "Part-Time Staff Form", JOptionPane.OK_CANCEL_OPTION); 
if (result == JOptionPane.OK_OPTION) { 
try { 
int vacancyNo = Integer.parseInt(fields[0].getText()); 
for (StaffHire staff : staffList) { 
if (staff.GetVacancyNumber() == vacancyNo) { 
JOptionPane.showMessageDialog(null, "Vacancy Number already exists");
                         
return; 
        
} 
} 
PartTimeStaffHire partTime = new PartTimeStaffHire( vacancyNo,fields[1].getText(), fields[2].getText(), "", "", "", "", false, 
Integer.parseInt(fields[7].getText()), 
Double.parseDouble(fields[8].getText()),fields[9].getText() 
); 
partTime.setStaffName(fields[3].getText()); 
partTime.setJoiningDate(fields[4].getText()); 
partTime.setQualification(fields[5].getText()); 
partTime.setAppointedBy(fields[6].getText()); 
partTime.setJoined(true); 
staffList.add(partTime); 
JOptionPane.showMessageDialog(null, "Part-Time Staff Added!"); 
} catch (Exception e) { 
JOptionPane.showMessageDialog(null, "Invalid Input. Try Again."); 
} 
} 
} 
private void terminatePartTime() { 
String input = JOptionPane.showInputDialog("Enter Vacancy Number to Terminate:"); 
         
try { 
             
int vacancy = Integer.parseInt(input); 
               
for (StaffHire staff : staffList) { 
if (staff instanceof PartTimeStaffHire pts && 
pts.GetVacancyNumber() == vacancy) { 
                    
if (pts.GetJoined()) { 
                                                                  
pts.terminate(); 
JOptionPane.showMessageDialog(null, "Part-Time Staff terminated");
} else { 
JOptionPane.showMessageDialog(null, "This staff member has not joined yet."); 
                     
} 
        
return; 
} 
} 
JOptionPane.showMessageDialog(null, "No Part-Time Staff Found."); 
} catch (Exception e) { 
JOptionPane.showMessageDialog(null, "Invalid Input."); 
} 
} 
private void displayAll() { 
if (staffList.isEmpty()) { 
JOptionPane.showMessageDialog(null, "No staff to display."); 
return; 
} 
JFrame displayFrame = new JFrame("All Staff Details"); 
displayFrame.setSize(500, 400); 
         
displayFrame.setLocationRelativeTo(null); 
            
JTextArea textArea = new JTextArea(); 
textArea.setEditable(false); 
StringBuilder output = new StringBuilder(); 
for (StaffHire staff : staffList) { 
output.append("\n-----------------------------\n"); 
output.append(staff.getClass().getSimpleName()).append("\n"); 
output.append("Vacancy: ").append(staff.GetVacancyNumber()).append("\n"); 
             
output.append("Designation: ").append(staff.GetDesignation()).append("\n"); 
                            
output.append("Joined: ").append(staff.GetJoined()).append("\n"); 
if (staff.GetJoined()) { 
output.append("Staff Name: ").append(staff.GetStaffName()).append("\n"); 
         
} 
} 
textArea.setText(output.toString()); 
JScrollPane scrollPane = new JScrollPane(textArea); 
displayFrame.add(scrollPane); 
displayFrame.setVisible(true); 
} 
private JTextField[] createInputFields(String... labels) { 
JTextField[] fields = new JTextField[labels.length]; 
for (int i = 0; i < labels.length; i++) { 
    

 fields[i] = new JTextField(10); 


 fields[i].setBorder(BorderFactory.createTitledBorder(labels[i])); 
} 
return fields; 
} 
public static void main(String[] args) { 
SwingUtilities.invokeLater(RecruitmentSystemGUI::new); 
} 
} 





