import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
   


@SuppressWarnings("deprecation") //was getting message about adding a depreciation warning
public class CalculatorController {

	//--------BUTTONS------------------------
    @FXML
    private Button Equal;

    @FXML
    private Button Add;

    @FXML
    private Button Nine;

    @FXML
    private Button Zero;

    @FXML
    private Button One;

    @FXML
    private Button Two;

    @FXML
    private Button Three;

    @FXML
    private Button Six;

    @FXML
    private Button Five;

    @FXML
    private Button Four;

    @FXML
    private Button Seven;

    @FXML
    private Button Eight;

    @FXML
    private Button Divide;

    @FXML
    private Button Clear;
//-------SCREEN1 and SCREEN2 LABELS ---------------
    @FXML
    private Label Screen2;

    @FXML
    private Label Screen1;
    
    
    
    private String Str ="",  PrevText=""; // string variables 
    private Boolean Cop=false ,update=false; // update screen
    private double Rez;
    private ScaleTransition Sc;
    

    @FXML
    void Clear(ActionEvent event){
        scale(event);
        Screen1.setText("");
         Screen2.setText("");
         PrevText ="";
         Cop=false;
         update=false;
      
  }

    @FXML
    void SetAdd(ActionEvent event){
        
        scale(event);
        
       if(Cop){
          
           calculate();
           Screen1.setText(String.valueOf(Rez));
       }else if(!Screen1.getText().equals(""))
          {
                 Rez = Double.valueOf(Screen1.getText()).doubleValue();
                 PrevText = Screen2.getText();
                 Cop=true;
          }else{
                 Screen1.setText("0");
               }
       
       Str =  "+";
       update= true;
    
      Screen2.setText(PrevText+ Str);
      PrevText =Screen2.getText();
   }

    @FXML
    void SetDivide(ActionEvent event) {
        scale(event);
        if(Cop){
             calculate();
             Screen1.setText(String.valueOf(Rez));
         }else if(!Screen1.getText().equals(""))
            {
                   Rez = Double.valueOf(Screen1.getText()).doubleValue();
                   PrevText = Screen2.getText();
                   Cop=true;
            }else{
                   Screen1.setText("0");
                 }
         
         Str =  "/";
         update= true;
      
        Screen2.setText(PrevText+ Str);
          PrevText =Screen2.getText();
     }

     

    @FXML
    void SetEqual(ActionEvent event) {
        
        scale(event);
        
          calculate();
          Cop = false;
          Screen2.setText(PrevText +" = "+ Rez);
          PrevText="";
          update= true;
       
          
            
      }

    @FXML
    void SetNumber(ActionEvent event) {
        
   String Str = ((Button)event.getSource()).getText();
  
   
    scale(event);
   if (update)
   {
      
       update= false;
   }
   else {
        if(!Screen1.getText().equals("0"))
  
      Str = Screen1.getText()+ Str;
  
  }
     Screen1.setText(Str);
     
      Screen2.setText(PrevText + Str );
   
    
  }
    
 
public void scale(ActionEvent event) { // function
        
        Sc = ScaleTransitionBuilder.create()
                 .node((Button)event.getSource())
                .duration(Duration.seconds(0.1))
                .toX(0.8)
                .toY(0.8)
                .cycleCount(2)
                .autoReverse(true)
                .build();
        Sc.play();
     }

public void calculate(){ // calculations function
    
	 if (Str.equals("+"))
	     {
	     Rez =Rez + Double.valueOf(Screen1.getText()).doubleValue();
	    Screen1.setText(String.valueOf(Rez));
	      PrevText = Screen2.getText();
	    Screen2.setText(PrevText+"+");
	     }
	  if (Str.equals("-"))
	     {
	     Rez =Rez - Double.valueOf(Screen1.getText()).doubleValue();
	     Screen1.setText(String.valueOf(Rez));
	      PrevText = Screen2.getText();
	    Screen2.setText(PrevText+"-");
	     }
	   if (Str.equals("*"))
	     {
	     Rez =Rez * Double.valueOf(Screen1.getText()).doubleValue();
	      
	     Screen1.setText(String.valueOf(Rez));
	      PrevText = Screen2.getText();
	    Screen2.setText(PrevText+"*");
	     }
	    if (Str.equals("/"))
	     {
	         try{
	               Rez =Rez /Double.valueOf(Screen1.getText()).doubleValue();
	              
	               Screen1.setText(String.valueOf(Rez));
	               PrevText = Screen2.getText();
	               Screen2.setText(PrevText+"/");
	             }catch(ArithmeticException e){
	                        Screen1.setText("division par 0 impossible");
	                        }         
	     }
	    if (Str.equals("%"))
	     {
	         try{
	               Rez =Rez % Double.valueOf(Screen1.getText()).doubleValue();
	               
	               Screen1.setText(String.valueOf(Rez));
	               PrevText = Screen2.getText();
	               Screen2.setText(PrevText+"%");
	             }catch(ArithmeticException e){
	                        Screen1.setText("division par 0 impossible");
	                        }         
	     }
	      
	 }

}
