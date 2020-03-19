package snowenterprises;



import java.io.*;
import java.text.DecimalFormat;
public class SnowEnterprises {
    //Sir Baquirin CC3 Lab Activity (01-21-19)

        public static SimpleEmployee Employee = new SimpleEmployee();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Name: ");
            Employee.setName(br.readLine());

            System.out.print("Enter Weekly Gross: ");
            Employee.setWeeklyGross(Float.parseFloat(br.readLine()));

            double netWeek = netWeekly(Employee.getWeeklyGross());
            
        
            DecimalFormat df = new DecimalFormat("####0.00");
            System.out.println("\n****SNOW ENTERPRISES****");
            System.out.println("Name:                  " +Employee.getName());
            System.out.println("Weekly Gross:          " +df.format(+Employee.getWeeklyGross()));
            System.out.println("Bonus:                 " +df.format(Employee.getBonusRate())); //cinompute nalang yung bonus dito HAHAHA System.out.println("Net Weekly Salary: "+ net week); // nacompute na yung netweeklySatary System.out.println("Classification: "+classification);
            System.out.println("Net Weekly Salary:     " +df.format(netWeek));
            System.out.println("Classification:        " + Employee.getClassification());
        
            Employee.setName(Employee.getName());
            Employee.setWeeklyGross(1039.37);
            Employee.setClassification('A');
            
            System.out.println("\nName          "+Employee.getName());
            System.out.println("Weekly Gross  "+Employee.getWeeklyGross());
            System.out.println("Classification "+Employee.getClassification());
          
            System.out.println();
        }
        
        public static double netWeekly(double grossWeeklySalary) {
            
            double netweeklySalary = Employee.getBonusRate() + Employee.getFixedSalary();
            
            Employee.setClassification(classify(netweeklySalary));
            
            return netweeklySalary;
        }

        public static char classify(double netWeeklySalary) {
            char employeeClass = ' ';
            char[] classification = {'A', 'B', 'C', 'D', 'E', 'F'};
            int[] x = {1500, 2000, 2500, 3000, 3500, 4000};
            int[] y = {1999, 2499, 2999, 3499, 3999, 9999};
            for (int i = 0; i < classification.length; i++) {
                if (netWeeklySalary >= x[i] && netWeeklySalary <= y[i]) {
                    employeeClass = classification[i];
                    
                }
            }
            return employeeClass;
        }

    }
