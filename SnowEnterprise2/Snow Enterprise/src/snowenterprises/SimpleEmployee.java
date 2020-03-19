

package snowenterprises;


public class SimpleEmployee {

    
    
    public String Name;
       
    public double FixedSalary;

    public char Classification;
    
    public double WeeklyGross;
    
    public double BonusRate;
    
    
    public SimpleEmployee(){
        
        this.FixedSalary = 1500;
        this.BonusRate = 0.085;
       
    }
    
    public void setName(String empname){
        this.Name = empname;
    }
    public void setWeeklyGross(double weeklysales){
        this.WeeklyGross = weeklysales;
        BonusRate = WeeklyGross * BonusRate;
    }
    public void setClassification(char classif){
        this.Classification = classif;
    }
    
    public String getName(){
        return Name;
        
    }
    public double getWeeklyGross(){
        return WeeklyGross;
        
    }     
    public double getFixedSalary(){
        return FixedSalary;
        
    }
    public char getClassification(){
        return Classification;
        
    }
    public double getBonusRate(){
        return BonusRate;
    }
}