
package classrecord;

import java.util.*;
public class ClassRecord {

    static int n = 2;
    
    
    static String[] idNumber = new String[n];
    static String[] Fname = new String[n];
    static String[] Lname = new String[n];
    static String[] Mname= new String[n];
    
    static double[] midGrade = new double[n];
    static double[] finGrade = new double[n];
    
    static int[] FGrade = new int[n];
    
    
    public static void main(String[] args) {    
          Scanner SC = new Scanner(System.in);
   
          //initialization of midterm scores
          double [] mlab = new double[n];
          double [] mcs = new double[n];
          double [] midExam = new double[n];
          
          double [] flab = new double[n];
          double [] fcs = new double[n];
          double [] finExam = new double[n]; 
          
          //initialization of grades
          double [] midGrade = new double [n];
          double [] finGrade = new double [n];
          
          //initialization for the final grades
          int[] Fmgrade = new int[n];
          int[] Ffgrade = new int[n];
          int[] Grade = new int[n];
                  
          String[] status = new String[n];        
                  
          for (int i = 0; i < n; i++){ 
          System.out.println("STUDENT #"+(i+1));
          System.out.print("Enter your ID Number: ");
          idNumber[i] = SC.nextLine();
          
           System.out.print("Enter your LAST name: ");
          Lname[i] = SC.nextLine();   
          
          System.out.print("Enter your FIRST name: ");
          Fname[i] = SC.nextLine();
          
  
          System.out.print("Enter your MIDDLE initial:");
          Mname[i] = SC.nextLine();
          
          //MIDTERMS
          System.out.print("Enter your marks in MIDTERM Laboratory Scores:  ");
          mlab[i] = SC.nextDouble();
           
          System.out.print("Enter your Class Standing for the Midterms: ");
          mcs[i] = SC.nextDouble();
          
          System.out.print("Enter your Midterm Exam : ");
          midExam[i] = SC.nextDouble();
          
         //FINALS
          System.out.print("\nEnter your marks in Finals Laboratory:  ");
          flab[i] = SC.nextDouble();
          
          System.out.print("Enter your Class Standing for the Finals: ");
          fcs[i] = SC.nextDouble();
          
          System.out.print("Enter your Final Exam Score: ");
          finExam[i] = SC.nextDouble();
          SC.nextLine();

          }
          //Computation Grades
          for (int i = 0; i<n ; i++){
              midGrade[i]= ((mcs[i]*0.33)+(mlab[i]*0.33)+(midExam[i]*0.34));
              finGrade[i]= ((fcs[i]*0.33)+(mlab[i]*0.33)+(finExam[i]*0.34));
                   
           Fmgrade[i] = convert(midGrade[i]);
           Ffgrade[i] = convert(finGrade[i]);
           Grade[i] = (int) Math.round((Fmgrade[i]/2.0)+(Ffgrade[i]/2.0));
           if(Grade[i] >= 75){
               status[i] = "PASSED";
           }else{
               status[i] = "FAILED";
           }
        }
          //printing of output
          System.out.printf("%10s%13s%10s%3s%7s%7s%7s%10s%n", "ID Number","Last Name", "Name", "MI", "Mid", "Fin", "Grade", "Remarks");
        
        for(int i = 0; i < n; i++){
          System.out.printf("%10s%13s%10s%3s%7s%7s%7s%10s%n", idNumber[i], Lname[i], Fname[i], Mname[i], midGrade[i], finGrade[i], Grade[i], status[i]);
        } 
        		
		System.out.print(n);
		String ans;
                boolean valid;
                do{
                    valid=false;
                    ans="";
                    System.out.println("Enter ID number of Students: ");
                    String id = SC.nextLine();
                    for(int i = 0; i < n; i++){
                        if(idNumber[i].equals(id)){
                            print(i);
                            valid = true;
                            break;
                        }
                    }
                    if(valid==false){
                        System.out.println("ID number not found!!");
                        ans = "y";
                        continue;
                        
                }
                    System.out.print("Check again?[y/n]:   ");
                    ans = SC.nextLine();
                }while(ans.toLowerCase().equals("y"));
}
    static void print(int id){
        System.out.printf("%nName of Students: %s %s. %s%n", Fname[id],Mname[id],Lname[id]);
        System.out.println("Midterm Grade: " +midGrade[id]);
        System.out.println("Finals Grade: " +finGrade[id]);
        System.out.println("GRADE: "+ FGrade[id]);
        System.out.println();

		
    }
     static int convert(double g){
        int grade = 1;
        if(g < 7 && g >= 0){
            grade = 70;
        }else if(g < 19){
            grade = 71;
        }else if(g < 31){
            grade = 72;
        }else if(g < 43){
            grade = 73;
        }else if(g < 50){
            grade = 74;
        }else if(g < 51.5){
            grade = 75;
        }else if(g < 53){
            grade = 76;
        }else if(g < 55){
            grade = 77;
        }else if(g < 57){
            grade = 78;
        }else if(g < 59){
            grade = 79;
        }else if(g < 61){
            grade = 80;
        }else if(g < 63){
            grade = 81;
        }else if(g < 65){
            grade = 82;
        }else if(g < 67){
            grade = 83;
        }else if(g < 69){
            grade = 84;
        }else if(g < 71){
            grade = 85;
        }else if(g < 73){
            grade = 86;
        }else if(g < 75){
            grade = 87;
        }else if(g < 77){
            grade = 88;
        }else if(g < 79){
            grade = 89;
        }else if(g < 81){
            grade = 90;
        }else if(g < 83){
            grade = 91;
        }else if(g < 85){
            grade = 92;
        }else if(g < 87){
            grade = 93;
        }else if(g < 89){
            grade = 94;
        }else if(g < 91){
            grade = 95;
        }else if(g < 93){
            grade = 96;
        }else if(g < 95){
            grade = 97;
        }else if(g < 97){
            grade = 98;
        }else{
            grade = 99;
        }
        return grade;
    }
}



