package library;
import static java.awt.SystemColor.info;
import static java.awt.SystemColor.text;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.*;
import javafx.beans.Observable;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.* ;
import java.sql.*;
import java.util.logging.*;
import javafx.scene.input.KeyCode;

public class Library extends Application{
      private  BorderPane border = new BorderPane();
      private VBox VBoxCenter = new VBox();
      private VBox AddVBox = new VBox(10);
      private GridPane AddProfPane = new GridPane();
         private  GridPane AddBookPane = new GridPane();
        private GridPane AddStudentPane = new GridPane();
           private       GridPane ReportPane = new GridPane();
private VBox vb = new VBox();

private String valueComoBox= null;
private HBox hbox1 = new HBox();
private HBox hbox2 = new HBox();
private HBox hbox3 = new HBox();
private VBox vbox = new VBox();

 private HBox hbx = new HBox(10);

        private GridPane BorrPane = new GridPane();
        private GridPane RetPane = new GridPane();
        
private String tempStu ="";
private String tempProf ="";
private String tempBook ="";

private Integer isStuBorr=0;
private Integer isProfBorr=0;
private Integer isBookBorr=0;

private Integer stnumber =0;
private Integer profnumber =0;
private Integer booknumber =0;

private TextArea ChDelete = new TextArea();
   private  TextField ListRet =new TextField();

        ///// delete gride pane
       private GridPane DeleteStudentPane = new GridPane();
       private GridPane DeleteProfPane = new GridPane();
       private GridPane DeleteBookPane = new GridPane();

                
      private Button btAdd = new Button("Add");
      private Button btDelete = new Button("Delete");
      private Button btBorRet = new Button("Borr/Ret");
      private Button btReports = new Button("Reports");
      private Button btExit = new Button("Exit");

      private ResultSet result = null ;

 private ComboBox<String> comboBox = new ComboBox<>();
 
   private ObservableList<String> items = 
      FXCollections.observableArrayList();
   private ObservableList<String> itemsBook = 
      FXCollections.observableArrayList(); 
   private String info[] = new String[200];
     private HBox HBoxCenter = new HBox(10);

      private TextField StudentName =new TextField();
      private TextField StudnetNumber =new TextField();

      
       private TextField BookName =new TextField();
      private TextField BookNumber =new TextField();
      private TextField Bookauthor =new TextField();
      private TextField publication =new TextField();
      
       private TextField ProfName =new TextField();
      private TextField ProfNumber =new TextField();
            private TextField ProfCollage =new TextField();
            
      private TextField Search =new TextField();

            
            private Button btAddStudent = new Button("Add Student");
            private Button btAddProf = new Button("Add Professor");
            private Button btAddBook = new Button("Add Book");

      private Label ChLabel = new Label("");
      private Label DeleteLabel = new Label("");
      
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
             border.setStyle("-fx-background-color:white;-fx-border-color:Black;-fx-border-width:2px;");
    comboBox.setPrefWidth(200);
        ChDelete.setPrefSize(650, 200);

      StackPane TopPane = new StackPane();

      Label Text = new Label("An-Najah National University Library");
     Text.setStyle("-fx-text-fill:black;-fx-font-size:25;-fx-font-weight:Bolder;-fx-font-family:serif;");
     TopPane.setStyle("-fx-background-color:orange;-fx-border-color:Black;-fx-border-width:2px;");
     TopPane.getChildren().add(Text);  
      border.setTop(TopPane); 
      

      VBoxCenter.setPadding(new Insets(11.5, 12.5, 13.5, 100));
             
            
      VBoxCenter.setStyle("-fx-border-color:Black;-fx-border-width:2px;");
      btAdd.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btDelete.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btBorRet.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btReports.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btExit.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");

                 btAdd.setPrefSize(120, 50);
                btDelete.setPrefSize(120, 50);
                btBorRet.setPrefSize(120, 50);
                btReports.setPrefSize(120, 50);
                btExit.setPrefSize(120, 50);

      HBoxCenter.getChildren().addAll(btAdd,btDelete,btBorRet,btReports,btExit);  
      VBoxCenter.getChildren().addAll(HBoxCenter,AddVBox);
      border.setCenter(VBoxCenter); 

      
      btAdd.setOnAction(e -> {
                btAdd.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:orange;-fx-border-color:#ff5c11;");
      btDelete.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btBorRet.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btReports.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btExit.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
                Add();
     
       
          
});
      
      btDelete.setOnAction(e -> {
      btDelete.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:orange;-fx-border-color:#ff5c11;");
       btAdd.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btBorRet.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btReports.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btExit.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      Delete();
      
});
      
      btBorRet.setOnAction(e -> {
      btBorRet.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:orange;-fx-border-color:#ff5c11;");
  btAdd.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btDelete.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btReports.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btExit.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
BorrRet();
      
      });
      
      btReports.setOnAction(e -> {
       btReports.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:orange;-fx-border-color:#ff5c11;");
  btAdd.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btDelete.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btBorRet.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btExit.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
Report();
      });
      
      btExit.setOnAction(e -> {
      btExit.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:orange;-fx-border-color:#ff5c11;");
      btAdd.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btDelete.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btBorRet.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btReports.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");

      BorrPane.getChildren().clear();
   RetPane.getChildren().clear();
   AddProfPane.getChildren().clear();
           AddStudentPane.getChildren().clear();
           AddBookPane.getChildren().clear();
            AddVBox.getChildren().clear();
  DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
                items.clear();
                   vbox.getChildren().clear();
                vb.getChildren().clear();
      hbox1.getChildren().clear();
      hbox2.getChildren().clear();
      hbox3.getChildren().clear();
                hbx.getChildren().clear();
});      

  
    Scene scene = new Scene(border,950,620);
    primaryStage.setTitle("ShowBorderPane");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  //////////////////////// report 
    private void Report() {
                          hbx.getChildren().clear();

              vbox.getChildren().clear();
            BorrPane.getChildren().clear();
   RetPane.getChildren().clear();
   AddProfPane.getChildren().clear();
           AddStudentPane.getChildren().clear();
           AddBookPane.getChildren().clear();
            AddVBox.getChildren().clear();
  DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
                items.clear();
                Search.clear();
                vb.getChildren().clear();
            ReportPane.setPadding(new Insets(11.5, 12.5, 225, 14.5));
ReportPane.setStyle("-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:black;");
      ComboBox<String> comboBoxUser = new ComboBox<>();
comboBoxUser.setPrefWidth(200);

       Button btBookBorr = new Button("Borrowed Books");///////Borrowed Books
       Button btDeleteBook = new Button("Deleted Books");//////Deleted Books
       Button btAvBook = new Button("Available Books");////////Available Books
       Button btCurrentUser = new Button("Current User");//////////////The users in the DataData Base
       Button btDeletedUser = new Button("Deleted User");//////// deleted user
       Button btBorrUser = new Button("Borrowed users");////////  user borrowed book
       
      btBookBorr.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btDeleteBook.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
       btAvBook.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btCurrentUser.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
   btDeletedUser.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
   btBorrUser.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
          
      TextArea Report = new TextArea();
         Report.setPrefSize(650, 200);
      btBookBorr.setPrefSize(150, 30);
      btDeleteBook.setPrefSize(150, 30);
      btAvBook.setPrefSize(150, 30);
      btCurrentUser.setPrefSize(150, 30);
      btDeletedUser.setPrefSize(150, 30);
      btBorrUser.setPrefSize(150, 30);

          HBox hbox= new HBox(10);     
          HBox hbox2= new HBox(10);     
VBox vbox = new VBox(10);
          hbox.setPadding(new Insets(20, 1, 1, 0));
     hbox2.setPadding(new Insets(20, 1, 1, 0));
VBoxCenter.getChildren().clear();

hbox.getChildren().addAll(btBookBorr,btDeleteBook,btAvBook);
hbox2.getChildren().addAll(btCurrentUser,btDeletedUser,btBorrUser);
AddVBox.getChildren().addAll(hbox,hbox2);
AddVBox.setPadding(new Insets(20, 1, 1, 100));
VBoxCenter.setPadding(new Insets(11.5, 12.5, 13.5, 100));
            VBoxCenter.getChildren().addAll(HBoxCenter,AddVBox);

      ///////////////////////////////// الكتب المستعارة
      btBookBorr.setOnAction(e -> {
            items.clear();
                vb.getChildren().clear();    
    try{

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

//String sqlStu = "select stname,stnumber,NoOfStBorr from student where flagStu=0&&isStuborr=1";
String sqlRep = "select bookname,booknumber,bookauthor,publication from book where isbookborr=1";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlRep);

 result = preparedStatement.executeQuery();

String Temp = ""; 
while(result.next()) {
String bookname = result.getString(1);
Integer  booknumber = result.getInt(2);
String bookauhtor = result.getString(3);
String  publication = result.getString(4);

Temp =Temp+"\n Book Name: "+bookname+"  || Book Number: "+booknumber+"  || Book author: "+bookauhtor+"  || Publication Book:"+publication+" \n"; 
 
}
 HBox hboxBorr = new HBox();
 HBox HboxBorr2 = new HBox();

Label lb = new Label();
lb.setText("All books borrowed");
   lb.setStyle("-fx-text-fill:Black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-background-color:white;");
HboxBorr2.getChildren().add(lb);
//lb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
HboxBorr2.setPadding(new Insets(11.5, 20, 1, 30));
 
hboxBorr.setPadding(new Insets(1, 12.5, 50, 20));

    Report.setText(Temp);
    hboxBorr.getChildren().add(Report);
    vb.getChildren().addAll(HboxBorr2,hboxBorr);
    
border.setBottom(vb);    
        
    }catch (Exception ex) {
ex.printStackTrace();
}
   });
       
      btDeleteBook.setOnAction(e -> {
              items.clear();
                vb.getChildren().clear();
               
    try{

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlRep = "select bookname,booknumber,bookauthor,publication from book where flagBook=1";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlRep);

 result = preparedStatement.executeQuery();

String Temp = ""; 
while(result.next()) {
String bookname = result.getString(1);
Integer  booknumber = result.getInt(2);
String bookauhtor = result.getString(3);
String  publication = result.getString(4);

Temp =Temp+"\n Book Name: "+bookname+"  || Book Number: "+booknumber+"  || Book author: "+bookauhtor+"  || Publication Book:"+publication+" \n"; 
 
}
 HBox hboxBorr = new HBox();
 HBox HboxBorr2 = new HBox();
//VBox vb = new VBox();

Label lb = new Label();
lb.setText("All books Deleted");
   lb.setStyle("-fx-text-fill:Black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-background-color:white;");
HboxBorr2.getChildren().add(lb);
//lb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
HboxBorr2.setPadding(new Insets(11.5, 20, 1, 30));
 
hboxBorr.setPadding(new Insets(1, 12.5, 50, 20));

    Report.setText(Temp);
    hboxBorr.getChildren().add(Report);
    vb.getChildren().addAll(HboxBorr2,hboxBorr);
    
border.setBottom(vb);    
  
      
      }catch (Exception ex) {
ex.printStackTrace();
}
});
  
      btAvBook.setOnAction(e -> {
           items.clear();
                vb.getChildren().clear();
     try{

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlRep = "select bookname,booknumber,bookauthor,publication from book where flagBook=0 && isbookborr=0";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlRep);

 result = preparedStatement.executeQuery();

String Temp = ""; 
while(result.next()) {
String bookname = result.getString(1);
Integer  booknumber = result.getInt(2);
String bookauhtor = result.getString(3);
String  publication = result.getString(4);

Temp =Temp+"\n Book Name: "+bookname+"  || Book Number: "+booknumber+"  || Book author: "+bookauhtor+"  || Publication Book:"+publication+" \n"; 
 
}
 HBox hboxBorr = new HBox();
 HBox HboxBorr2 = new HBox();
//VBox vb = new VBox();

Label lb = new Label();
lb.setText("All books are available to borrow");
   lb.setStyle("-fx-text-fill:Black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-background-color:white;");
HboxBorr2.getChildren().add(lb);
//lb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
HboxBorr2.setPadding(new Insets(11.5, 20, 1, 30));
 
hboxBorr.setPadding(new Insets(1, 12.5, 50, 20));

    Report.setText(Temp);
    hboxBorr.getChildren().add(Report);
    vb.getChildren().addAll(HboxBorr2,hboxBorr);
    
border.setBottom(vb);    
        
      
      
      }catch (Exception ex) {
ex.printStackTrace();
}
});
  
          btCurrentUser.setOnAction(e -> {
               items.clear();
                vb.getChildren().clear();
     try{

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

//String sqlStu = "select stname,stnumber,NoOfStBorr from student where flagStu=0&&isStuborr=1";
String sqlRep = "select stname,stnumber,NoOfStBorr from student where flagStu=0 ";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlRep);

 result = preparedStatement.executeQuery();

String Temp = "Current STUDENTS \n"; 
while(result.next()) {
String stuname = result.getString(1);
Integer  stunumber = result.getInt(2);
Integer NoStuBook = result.getInt(3);

Temp =Temp+"\n Student Name: "+stuname+"  || Student Number: "+stunumber+"  || Number of borrowed books : "+NoStuBook+" \n"; 
 
}
String sql = "select profname,profnumber,NoOfProfBorr,profcollage from professor where flagProf=0 ";

    preparedStatement = connection.prepareStatement(sql);
Temp =Temp+"\n Current PROFESSORS : \n"; 

 result = preparedStatement.executeQuery();

while(result.next()) {
String pname = result.getString(1);
Integer  pnumber = result.getInt(2);
Integer NoPBook = result.getInt(3);
String pcollage = result.getString(4);

Temp =Temp+"\n Professor Name: "+pname+"  || Professor Number: "+pnumber+"  || Number of borrowed books: "+NoPBook+
        "  || Collage: "+pcollage+" \n"; 
 
}

 HBox hboxBorr = new HBox();
 HBox HboxBorr2 = new HBox();
//VBox vb = new VBox();

Label lb = new Label();
lb.setText("All books are available to borrow");
   lb.setStyle("-fx-text-fill:Black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-background-color:white;");
HboxBorr2.getChildren().add(lb);
//lb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
HboxBorr2.setPadding(new Insets(11.5, 20, 1, 30));
 
hboxBorr.setPadding(new Insets(1, 12.5, 50, 20));


    Report.setText(Temp);
    hboxBorr.getChildren().add(Report);
    vb.getChildren().addAll(HboxBorr2,hboxBorr);
       
border.setBottom(vb);    
        
      
      
      }catch (Exception ex) {
ex.printStackTrace();
}
});
   
            btDeletedUser.setOnAction(e -> {
                 items.clear();
                vb.getChildren().clear();
      try{

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlRep = "select stname,stnumber,NoOfStBorr from student where flagStu=1 ";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlRep);

 result = preparedStatement.executeQuery();

String Temp = "Deleted STUDENTS \n"; 
while(result.next()) {
String stuname = result.getString(1);
Integer  stunumber = result.getInt(2);
Integer NoStuBook = result.getInt(3);

Temp =Temp+"\n Student Name: "+stuname+"  || Student Number: "+stunumber+" \n"; 
 
}
String sql = "select profname,profnumber,NoOfProfBorr,profcollage from professor where flagProf=1 ";

    preparedStatement = connection.prepareStatement(sql);
Temp =Temp+"\n Deleted PROFESSORS: \n"; 

 result = preparedStatement.executeQuery();

while(result.next()) {
String pname = result.getString(1);
Integer  pnumber = result.getInt(2);
Integer NoPBook = result.getInt(3);
String pcollage = result.getString(4);

Temp =Temp+"\n Professor Name: "+pname+"  || Professor Number: "+pnumber+" || Collage: "+pcollage+" \n"; 
 
}
 HBox hboxBorr = new HBox();
 HBox HboxBorr2 = new HBox();
//VBox vb = new VBox();

Label lb = new Label();
lb.setText("All books are available to borrow");
   lb.setStyle("-fx-text-fill:Black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-background-color:white;");
HboxBorr2.getChildren().add(lb);
//lb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
HboxBorr2.setPadding(new Insets(11.5, 20, 1, 30));
 
hboxBorr.setPadding(new Insets(1, 12.5, 50, 20));


    Report.setText(Temp);
    hboxBorr.getChildren().add(Report);
    vb.getChildren().addAll(HboxBorr2,hboxBorr);
       
border.setBottom(vb);    
        
      
      
      }catch (Exception ex) {
ex.printStackTrace();
}
});
    
   btBorrUser.setOnAction(e -> {
               items.clear();
                vb.getChildren().clear();
                hbx.getChildren().clear();
 try{
     String infoUser[] = new String[200];
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlStu = "select stname,stnumber,NoOfStBorr from student where flagStu=0 && isstuborr=1 ";


   PreparedStatement preparedStatement = connection.prepareStatement(sqlStu);

   
 result = preparedStatement.executeQuery();


int i = 0;
 while(result.next()) {
String stname = result.getString(1);
Integer  stnumber = result.getInt(2);
Integer NoStuBook = result.getInt(3);

System.out.println(stnumber+"-"+stname);

   infoUser[i] = stnumber+"-"+stname;

i++;
 }  

String sqlProf = "select profname,profnumber,NoOfProfBorr,profcollage from professor where flagProf=0 && isprofborr=1 ";


    preparedStatement = connection.prepareStatement(sqlProf);

 result = preparedStatement.executeQuery();

 while(result.next()) {
String Profname = result.getString(1);
Integer  Profnumber = result.getInt(2);
Integer NoPBook = result.getInt(3);
String pcollage = result.getString(4);
System.out.println(Profnumber+"-"+Profname);
   infoUser[i] = Profnumber+"-"+Profname;

i++;
 }  
 
items=  FXCollections.observableArrayList(infoUser);
 comboBoxUser.setItems(items);

   Label SUser = new Label("Search User :");
        //TextField SearchUser =new TextField();
        hbx.getChildren().addAll(SUser,Search,comboBoxUser);

hbx.setPadding(new Insets(11.5, 20, 231, 30));
 hbx.setStyle("-fx-border-color:red");
       
border.setBottom(hbx);    
        
      
      
      }catch (Exception ex) {
ex.printStackTrace();
}
});
            Search.setOnKeyReleased(e -> {
         items.clear();
                vb.getChildren().clear();

     String infoUser[] = new String[200];

       String stName =Search.getText();
       System.out.println(stName);
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

//String sql = "select stname, stnumber from student  where stname like '"+stName+"%'" ;
String sqlStu = "select stname,stnumber from student  where stname like '"+stName+"%' && flagStu=0 && isstuborr=1";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlStu);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String stname = result.getString(1);
Integer stnumber = result.getInt(2);
   infoUser[i] =stnumber+"-"+stname;

i++;
 } 
 String sqlProf = "select profname,profnumber from professor where profname like '"+stName+"%' && flagProf=0 && isprofborr=1";
    preparedStatement = connection.prepareStatement(sqlProf);

 result = preparedStatement.executeQuery();
 while(result.next()) {
String profname = result.getString(1);
Integer profnumber = result.getInt(2);
   infoUser[i] =profnumber+"-"+profname;

i++;
 } 
items=  FXCollections.observableArrayList(infoUser);
 comboBoxUser.setItems(items);

 
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });

            comboBoxUser.setOnAction(e -> {
String UserValue=comboBoxUser.getValue();
  //  items.clear();
    Report.clear();
                vb.getChildren().clear();

try{
//infoUser=null;
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");


String Temp ="";

String sqlStu = "select stname,stnumber from student where flagStu=0 && isstuborr=1 ";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlStu);

 result = preparedStatement.executeQuery();

 while(result.next()) {
String stname = result.getString(1);
Integer  stnumber = result.getInt(2);

System.out.println(stnumber+"-"+stname);

   String infoUser = stnumber+"-"+stname;

if(infoUser.equalsIgnoreCase(UserValue)){
 String Sql = "select borrbookname,borrbooknum,retdate,borrdate from borrowbook where borrnum='"+stnumber+"' ";
    preparedStatement = connection.prepareStatement(Sql);
result = preparedStatement.executeQuery();
while(result.next()) {
    
String bookName = result.getString(1);
Integer  bookNumber = result.getInt(2);
String RDate = result.getString(3);
String BDate = result.getString(4);

 Temp=Temp+"Title Book :"+bookName+"  || Book Number :"+bookNumber+"  || Borrowed Date :"+BDate+"  || Return Date :"+RDate+"\n";
}
}
    
 }
 
//////////////////////////////////////////////////
String sqlProf = "select profname,profnumber from professor where flagProf=0 && isprofborr=1 ";


    preparedStatement = connection.prepareStatement(sqlProf);

 result = preparedStatement.executeQuery();

 while(result.next()) {
String profname = result.getString(1);
Integer  profnumber = result.getInt(2);

   String infoUser = profnumber+"-"+profname;

if(infoUser.equalsIgnoreCase(UserValue)){
    
 String Sql = "select borrbookname,borrbooknum,retdate,borrdate from borrowbook where borrnum='"+profnumber+"' ";
    preparedStatement = connection.prepareStatement(Sql);
result = preparedStatement.executeQuery();

 while(result.next()) {
String bookName = result.getString(1);
Integer  bookNumber = result.getInt(2);
String RDate = result.getString(3);
String BDate = result.getString(4);

 Temp=Temp+"Title Book :"+bookName+"  || Book Number :"+bookNumber+"  || Borrowed Date :"+BDate+"  || Return Date :"+RDate+"\n";
}
    
}
 
 } 
  Report.setText(Temp);

//VBox vb = new VBox();

   Label SUser = new Label("Search User :");
        TextField SearchUser =new TextField();

        HBox hbx = new HBox(10);
         HBox HboxBorr2 = new HBox();
     hbx.getChildren().addAll(SUser,SearchUser,comboBoxUser);
     HboxBorr2.getChildren().add(Report);
vb.getChildren().addAll(hbx,HboxBorr2);
HboxBorr2.setPadding(new Insets(1, 12.5, 50, 50));
hbx.setPadding(new Insets(11.5, 20,13.5, 30));
       
border.setBottom(vb);    
        
      
      
 }catch (Exception ex) {
ex.printStackTrace();
}
});

    }
    
      //////////////////////////////////////// Borr/Ret
  private void BorrRet() {
      BorrPane.getChildren().clear();
      RetPane.getChildren().clear();
      AddProfPane.getChildren().clear();
      AddStudentPane.getChildren().clear();
      AddBookPane.getChildren().clear();
      AddVBox.getChildren().clear();
      DeleteStudentPane.getChildren().clear();
      DeleteProfPane.getChildren().clear();
      DeleteBookPane.getChildren().clear();
      ReportPane.getChildren().clear();
      items.clear();
         vbox.getChildren().clear();
         vb.getChildren().clear();
                hbx.getChildren().clear();

       Button Borr = new Button("Borrow a Book");
       Button Ret = new Button("Return Book");
 
      Borr.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      Ret.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      
      Borr.setPrefSize(120, 30);
      Ret.setPrefSize(120, 30);

       AddVBox.setPadding(new Insets(11.5, 1, 1, 260));
AddVBox.getChildren().addAll(Borr,Ret);

      
      ///////////////////////////////// Borr
      Borr.setOnAction(e -> {
          
    try{
          Borr();
    }catch (Exception ex) {
ex.printStackTrace();
}
   });
      
///////////////////////////////////   Ret
      Ret.setOnAction(e -> {
          
    try{
          Ret();
    }catch (Exception ex) {
ex.printStackTrace();
}
});
  
  }
  ////////////////////////////////////////////////////////////////
  private void Ret()throws ClassNotFoundException{
         vb.getChildren().clear();
         BorrPane.getChildren().clear();
         RetPane.getChildren().clear();
         AddProfPane.getChildren().clear();
         AddStudentPane.getChildren().clear();
         AddBookPane.getChildren().clear();
         AddVBox.getChildren().clear();
         DeleteStudentPane.getChildren().clear();
         DeleteProfPane.getChildren().clear();
         DeleteBookPane.getChildren().clear();
         ReportPane.getChildren().clear();
         items.clear();
            vbox.getChildren().clear();
                hbx.getChildren().clear();

           Button btRet = new Button("Return Book");
  ComboBox<String> comboBoxUser = new ComboBox<>();
      String infouser[] = new String[200];

      comboBoxUser.setPrefWidth(200);

Label ChRet = new Label();

    HBox hbox = new HBox();
    
    RetPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

    RetPane.setHgap(5.5);
    RetPane.setVgap(5.5);
    
        Label SearchRet = new Label("Search for User :");
    RetPane.setHalignment(SearchRet,HPos.RIGHT);
    RetPane.add(SearchRet, 0, 3);
    RetPane.add(Search, 1, 3);
       // comboBoxUser
       
    RetPane.setHalignment(btRet,HPos.RIGHT);
    RetPane.add(btRet, 5, 3);
    
     
 hbox.getChildren().add(ListRet);
     hbox.setPadding(new Insets(11.5, 12.5, 50, 120));

     RetPane.setHalignment(ListRet,HPos.RIGHT);
    RetPane.add(hbox, 0, 4);
    ListRet.setPrefSize(650, 200);

    RetPane.add( comboBoxUser, 4,3);
    
vb.getChildren().addAll(RetPane,hbox);
  vb.setStyle("-fx-background-color:white;-fx-border-width:3px;-fx-border-color:black;");

// comboBoxUser
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlUser = "select borrname,borrnum,borrbookname from borrowbook";


   PreparedStatement preparedStatement = connection.prepareStatement(sqlUser);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String username = result.getString(1);
Integer  usernumber = result.getInt(2);
String booknames = result.getString(3);

   infouser[i] = usernumber+"-"+username;
i++;
 }
 
 items=  FXCollections.observableArrayList(infouser);
 comboBoxUser.setItems(items);
        }catch (Exception ex) {
ex.printStackTrace();
} 
        ////////////////////////////////////////////////////////////////////////
       btRet.setOnAction(e -> {
String UserValue = comboBoxUser.getValue();
ListRet.clear();

              try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

 String sqlBorr = "select stname,stnumber,NoOfStBorr from student";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlBorr);
 result = preparedStatement.executeQuery();
 while(result.next()) {
String stuname = result.getString(1);
Integer  stunumber = result.getInt(2);
  Integer NoOfBorr = result.getInt(3);
   String infoSt = stunumber+"-"+stuname;
              
        if(UserValue.equalsIgnoreCase(infoSt)){
             
                 String bookNo="";
            String sqlBook = "select borrbooknum from borrowbook where borrnum='"+stunumber+"'";
 preparedStatement = connection.prepareStatement(sqlBook);
 result = preparedStatement.executeQuery();
           while(result.next()) {
           bookNo  = result.getString(1);
           }   
            NoOfBorr--;
   connection.prepareStatement("update student set  NoOfStBorr='"+NoOfBorr+"'where stnumber='"+stunumber+"'").executeUpdate();
   connection.prepareStatement("update book set  isbookborr= 0 where booknumber='"+bookNo+"'").executeUpdate();
 connection.prepareStatement("delete from borrowbook where borrbooknum='"+bookNo+"'").executeUpdate();
if(NoOfBorr==0){
 connection.prepareStatement("update student set  isstuborr=0 where stnumber='"+stunumber+"'").executeUpdate();
   
}
   ChRet.setText("The book was successfully returned");
ChRet.setStyle("-fx-Text-Fill:Green;-fx-font-size:15;");
        }
        
 }
 
 ////////////////////////////////////////////////////////////////////////////////
  String sqlProf = "select profname,profnumber,NoOfProfBorr from professor";

    preparedStatement = connection.prepareStatement(sqlProf);
 result = preparedStatement.executeQuery();
 while(result.next()) {
String profname = result.getString(1);
Integer  profnum = result.getInt(2);
Integer  NoProfBorr = result.getInt(3);

   String infoProf = profnum+"-"+profname;
  
        if(UserValue.equalsIgnoreCase(infoProf)){
                 String bookNo="";
            String sqlBook = "select borrbooknum from borrowbook where borrnum='"+profnum+"'";
 preparedStatement = connection.prepareStatement(sqlBook);
 result = preparedStatement.executeQuery();
           while(result.next()) {
           bookNo  = result.getString(1);
           }   
            NoProfBorr--;
               connection.prepareStatement("update professor set  NoOfProfBorr='"+NoProfBorr+"'where profnumber='"+profnum+"'").executeUpdate();
   connection.prepareStatement("update book set  isbookborr= 0 where booknumber='"+bookNo+"'").executeUpdate();
 connection.prepareStatement("delete from borrowbook where borrbooknum='"+bookNo+"'").executeUpdate();
 if(NoProfBorr==0){
 connection.prepareStatement("update professor set  isprofborr=0 where profnumber='"+profnum+"'").executeUpdate();
   
}
   ChRet.setText("The book was successfully returned");
ChRet.setStyle("-fx-Text-Fill:Green;-fx-font-size:15;");
        }
        
 }
 
 
 
 /////////////
     RetPane.add(ChRet, 2, 0);
items.clear();
      String sqlUser = "select borrname,borrnum,borrbookname from borrowbook";


    preparedStatement = connection.prepareStatement(sqlUser);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String username = result.getString(1);
Integer  usernumber = result.getInt(2);
String booknames = result.getString(3);

   infouser[i] = usernumber+"-"+username;
i++;
 }
 
 items=  FXCollections.observableArrayList(infouser);
 comboBoxUser.setItems(items);
 
 
 }catch(Exception ex){
         ex.printStackTrace();
         }
 
 });
       
   comboBoxUser.setOnAction(e -> {
String UserValue = comboBoxUser.getValue();
ListRet.clear();

              try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlStu = "select borrname,borrnum,borrbooknum,borrbookname,retdate,borrdate from borrowbook";


   PreparedStatement preparedStatement = connection.prepareStatement(sqlStu);
String  TempRet="";
 result = preparedStatement.executeQuery();
 while(result.next()) {
String username = result.getString(1);
Integer  usernumber = result.getInt(2);
Integer  booknumber = result.getInt(3);
String bookname = result.getString(4);
String BorrDate = result.getString(5);
String  RetDate = result.getString(6);

   String infoUser = usernumber+"-"+username;
  
        if(UserValue.equalsIgnoreCase(infoUser)){
        TempRet="Name : "+username+ "  ||  Number : "+usernumber+"  ||  Titel Book : "+bookname+"  ||  Book Number : "
              +booknumber +"  ||  Date Borrowed : "+BorrDate+"  ||  Date Return : "+RetDate;
           
        }
   
   
 }
ListRet.setText(TempRet);
      
 }catch(Exception ex){
         ex.printStackTrace();
         }
 
 });
       Search.setOnKeyReleased(e -> {
     items.clear();
     ListRet.clear();

     String infoUser[] = new String[200];

       String UserName =Search.getText();
       System.out.println(UserName);
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlUser = "select borrname,borrnum from borrowbook where borrname like'"+UserName+"%'";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlUser);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
        UserName = result.getString(1);
Integer UserNumber = result.getInt(2);
   infoUser[i] =UserNumber+"-"+UserName;

i++;
 } 
items=  FXCollections.observableArrayList(infoUser);
 comboBoxUser.setItems(items);

 
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
        
        
      border.setBottom(vb);
  }
  //////////////////////////////////////////////////////////////////////////
   private void Borr()throws ClassNotFoundException{
        AddProfPane.getChildren().clear();
        AddStudentPane.getChildren().clear();
        AddBookPane.getChildren().clear();
        AddVBox.getChildren().clear();
        DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
        ReportPane.getChildren().clear();
        items.clear();
        BorrPane.getChildren().clear();
        RetPane.getChildren().clear();
           vbox.getChildren().clear();
           comboBox.setValue("");
           itemsBook.clear();
                           hbx.getChildren().clear();

           Button btBorr = new Button("Borrow Book");
  ComboBox<String> comboBoxUser = new ComboBox<>();
comboBoxUser.setPrefWidth(200);
      String infouser[] = new String[200];

Label ChBorr = new Label();
  BorrPane.setStyle("-fx-background-color:white;-fx-border-width:3px;-fx-border-color:black;");

    HBox hbox = new HBox();
    hbox.getChildren().clear();

    BorrPane.setPadding(new Insets(11.5, 12.5, 225, 14.5));

    BorrPane.setHgap(5.5);
    BorrPane.setVgap(5.5);
    
        Label SearchSt = new Label("Search for User :");
    BorrPane.setHalignment(SearchSt,HPos.RIGHT);
    BorrPane.add(SearchSt, 0, 3);
    BorrPane.add(Search, 1, 3);
       // comboBoxUser
       
    BorrPane.setHalignment(btBorr,HPos.RIGHT);
    BorrPane.add(btBorr, 4, 10);
    
    BorrPane.add( comboBoxUser, 4,3);
    
        Label SearchB = new Label("Search for Book :");
        TextField SearchBook =new TextField();

    BorrPane.setHalignment(SearchSt,HPos.RIGHT);
    BorrPane.add(SearchB, 0, 6);
    BorrPane.add(SearchBook, 1, 6);
      
 Label DBorr = new Label("Date of Borrow :");
        TextField Dateborr =new TextField();

    BorrPane.setHalignment(DBorr,HPos.RIGHT);
    BorrPane.add(DBorr, 0, 9);
    BorrPane.add(Dateborr, 1,9);

 Label DRet = new Label("Date of Return :");
        TextField RateRet =new TextField();

    BorrPane.setHalignment(DRet,HPos.RIGHT);
    BorrPane.add(DRet,0, 10);
    BorrPane.add(RateRet,1, 10);

// comboBoxUser
       
    BorrPane.add( comboBox, 4,6);
   
    
    //BorrPane.add( comboBoxUser, 4,3);
    try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlStu = "select stname,stnumber from student where flagStu=0 ";


   PreparedStatement preparedStatement = connection.prepareStatement(sqlStu);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String stname = result.getString(1);
Integer  stnumber = result.getInt(2);

   info[i] = stnumber+"-"+stname;

i++;
 }  
 
 String sqlProf = "select profname,profnumber from professor where flagProf=0";


    preparedStatement = connection.prepareStatement(sqlProf);

 result = preparedStatement.executeQuery();
 while(result.next()) {
String Profname = result.getString(1);
Integer  Profnumber = result.getInt(2);

   info[i] = Profnumber+"-"+Profname;

i++;
 }  
 
items=  FXCollections.observableArrayList(info);
 comboBoxUser.setItems(items);

 
String sqlBook = "select bookname,booknumber from book where flagbook=0 && isbookborr=0";


    preparedStatement = connection.prepareStatement(sqlBook);

 result = preparedStatement.executeQuery();
int x = 0;
 while(result.next()) {
String bookname = result.getString(1);
Integer  booknumber = result.getInt(2);

   infouser[x] = booknumber+"-"+bookname;
x++;
 } 
 itemsBook=  FXCollections.observableArrayList(infouser);
 comboBox.setItems(itemsBook);
}
catch (Exception ex) {
ex.printStackTrace();
}    

    SearchBook.setOnKeyReleased(e -> {
     itemsBook.clear();
           String infoBook[] = new String[200];

       String stName =SearchBook.getText();
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlbook = "select bookname,booknumber from book  where bookname like '"+stName+"%' && flagbook=0 && isbookborr=0" ;

   PreparedStatement preparedStatement = connection.prepareStatement(sqlbook);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String bookname = result.getString(1);
Integer booknumer = result.getInt(2);
   infoBook[i] =booknumer+"-"+bookname;

i++;
 } 
itemsBook=  FXCollections.observableArrayList(infoBook);
 comboBox.setItems(itemsBook);

 
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
    ////////////////////////////////////////////////////////////////////////////////////////
        Search.setOnKeyReleased(e -> {
     items.clear();
           String infoUser[] = new String[200];

       String stName =Search.getText();
       System.out.println(stName);
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlStu = "select stname,stnumber from student  where stname like '"+stName+"%' && flagStu=0";

   PreparedStatement preparedStatement = connection.prepareStatement(sqlStu);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String stname = result.getString(1);
Integer stnumber = result.getInt(2);
   infoUser[i] =stnumber+"-"+stname;

i++;
 } 
 String sqlProf = "select profname,profnumber from professor where profname like '"+stName+"%' && flagProf=0";
    preparedStatement = connection.prepareStatement(sqlProf);

 result = preparedStatement.executeQuery();
 while(result.next()) {
String profname = result.getString(1);
Integer profnumber = result.getInt(2);
   infoUser[i] =profnumber+"-"+profname;

i++;
 } 
items=  FXCollections.observableArrayList(infoUser);
 comboBoxUser.setItems(items);

 
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });

   btBorr.setOnAction(e -> {
String userValue=comboBoxUser.getValue();
String BookValue=comboBox.getValue();
try {
    hbox.getChildren().clear(); 
     String DateBorr =Dateborr.getText();
             String RetBorr=  RateRet.getText();       
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sqlBook = "select bookname,booknumber from book where flagbook=0 && isbookborr=0";

    PreparedStatement preparedStatement = connection.prepareStatement(sqlBook);

 result = preparedStatement.executeQuery();
 while(result.next()) {
String bname = result.getString(1);
Integer  bnumber = result.getInt(2);
   String infoBook = bnumber+"-"+bname;
   
   

      if(BookValue.equalsIgnoreCase(infoBook)){
String bookname = result.getString(1);
Integer  booknumbers = result.getInt(2);      
String sqlStu = "select stname,stnumber,NoOfStBorr from student where flagStu=0";

     preparedStatement = connection.prepareStatement(sqlStu);

 result = preparedStatement.executeQuery();
 while(result.next()) {
String stname = result.getString(1);
Integer  stnumber = result.getInt(2);
Integer  NoOfbook = result.getInt(3);

   String infost = stnumber+"-"+stname;

     if(userValue.equalsIgnoreCase(infost)){

         if( NoOfbook >=2  ){ 
           ChBorr.setText("Failed, exceeded the limit in taking books");
         ChBorr.setStyle("-fx-text-Fill:red;-fx-font-size:15px");
         }else{
             ///////////////////////////////////////////////////////////
             
      connection.prepareStatement("insert into borrowbook(borrname,borrnum,borrbooknum,borrbookname,retdate,borrdate)"
               + " values('"+stname+"','"+stnumber+"','"+bnumber+"','"+bookname+"','"+RetBorr+"','"+DateBorr+"')").executeUpdate();
             NoOfbook++;
      connection.prepareStatement("update book set isbookborr=1 where booknumber='"+booknumbers+"'").executeUpdate();
      connection.prepareStatement("update student set  NoOfStBorr='"+NoOfbook+"',isstuborr=1 where stnumber='"+stnumber+"'").executeUpdate();

           ChBorr.setText("Book successfully borrowed");
         ChBorr.setStyle("-fx-text-Fill:green;-fx-font-size:15px");   
         }
     }
 }

String SqlProf = "select profname,profnumber,NoOfProfBorr from professor where flagProf=0" ;
            preparedStatement = connection.prepareStatement(SqlProf);
result = preparedStatement.executeQuery();
 while(result.next()) {

String profname = result.getString(1);
  profnumber = result.getInt(2);
  Integer NoOfProfBorr = result.getInt(3);

  String infopf = profnumber+"-"+profname;

     if(userValue.equalsIgnoreCase(infopf)){


         if( NoOfProfBorr >=5  ){ 

    ChBorr.setText("It is can not to borrow a book");
         ChBorr.setStyle("-fx-text-Fill:red;-fx-font-size:15px");
         }else{
System.out.println(profname);
             
             NoOfProfBorr++;
 connection.prepareStatement("insert into borrowbook(borrname,borrnum,borrbooknum,borrbookname,retdate,borrdate)"
               + " values('"+profname+"',"+profnumber+",'"+bnumber+"','"+bookname+"','"+RetBorr+"','"+DateBorr+"')").executeUpdate();
            
 connection.prepareStatement("update professor set  NoOfProfBorr='"+NoOfProfBorr+"',isprofborr=1 where profnumber='"+profnumber+"'").executeUpdate();
      connection.prepareStatement("update book set isbookborr=1 where booknumber='"+booknumbers+"'").executeUpdate();

           ChBorr.setText("Book successfully borrowed");
         ChBorr.setStyle("-fx-text-Fill:green;-fx-font-size:15px");  
         }
     }
 }
}
      }
          //lb.setStyle("-fx-text-fill:black;-fx-font-size:15px;");
hbox.getChildren().add(ChBorr);
BorrPane.add(hbox,1,1);
    Dateborr.clear();
    RateRet.clear();
 }catch (Exception ex) {
ex.printStackTrace();

}       
    }); 
      border.setBottom(BorrPane);

         }
         
  private void Add() {
          AddProfPane.getChildren().clear();
           AddStudentPane.getChildren().clear();
           AddBookPane.getChildren().clear();
            AddVBox.getChildren().clear();
  DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
                items.clear();
                BorrPane.getChildren().clear();
RetPane.getChildren().clear();
   vbox.getChildren().clear();
         vb.getChildren().clear();
                hbx.getChildren().clear();

       Button AddBook = new Button("Add Book");
       Button AddStudent = new Button("Add Student");
       Button AddProf = new Button("Add Pofessor");
 
      AddBook.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      AddStudent.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      AddProf.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      btAddStudent.setStyle("-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:black;");
      btAddProf.setStyle("-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:black;");
      btAddBook.setStyle("-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:black;");
              
      AddBook.setPrefSize(120, 30);
                 AddStudent.setPrefSize(120, 30);
                 AddProf.setPrefSize(120, 30);

       AddVBox.setPadding(new Insets(11.5, 1, 1, 0));
AddVBox.getChildren().addAll(AddBook,AddStudent,AddProf);

      
      /////////////////////////////////  add Student
      AddStudent.setOnAction(e -> {
          
    try{
          Addstu();
    }catch (Exception ex) {
ex.printStackTrace();
}
   });
      
///////////////////////////////////      add book
      AddBook.setOnAction(e -> {
          
    try{
          Addbook();
    }catch (Exception ex) {
ex.printStackTrace();
}
});
      
//////////////////////////////////////  add prof

     AddProf.setOnAction(e -> {
        try{
Addprof();
        }catch (Exception ex) {
ex.printStackTrace();
} 
 
});


}
       private void Addprof()throws ClassNotFoundException{
BorrPane.getChildren().clear();
RetPane.getChildren().clear();
  AddProfPane.getChildren().clear();
           AddStudentPane.getChildren().clear();
           AddBookPane.getChildren().clear();
            AddVBox.getChildren().clear();
  DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
                items.clear();
  
  AddProfPane.setStyle("-fx-background-color:white;-fx-border-width:3px;-fx-border-color:black;");

    AddProfPane.setAlignment(Pos.CENTER);

                          Button Addprof = new Button("Add Professor");
    
    
   // pane.setHalignment(,HPos.CENTER);
    AddProfPane.setPadding(new Insets(11.5, 12.5, 225, 14.5));
    AddProfPane.setHgap(5.5);
    AddProfPane.setVgap(5.5);
    
    ProfName.clear();
        Label LabelName = new Label("Professor Name:");
    AddProfPane.setHalignment(LabelName,HPos.RIGHT);
    AddProfPane.add(LabelName, 0, 3);
    AddProfPane.add(ProfName, 1, 3);
       ProfNumber.clear();
    Label LabelNumber = new Label("Professor Number : ");
    AddProfPane.setHalignment(LabelNumber,HPos.RIGHT);
    AddProfPane.add(LabelNumber, 0, 5); 
    AddProfPane.add(ProfNumber, 1, 5);
   ProfCollage.clear();
    Label Labelcollage = new Label("Proffessor Collage :");
    AddProfPane.setHalignment(Labelcollage,HPos.RIGHT);
    AddProfPane.add(Labelcollage, 2, 3); 
    AddProfPane.add(ProfCollage, 3, 3);
    
    AddProfPane.setHalignment(Addprof,HPos.RIGHT);
    AddProfPane.add(Addprof, 4, 5);
    
    Addprof.setOnAction(e -> {
        


   String profname = ProfName.getText();
String profnumber = ProfNumber.getText();
String profcollage =  ProfCollage.getText();
            try {
  
                Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

    connection.prepareStatement("insert into professor(profname,profnumber,profcollage,isprofborr,NoOfProfBorr,flagProf)"
               + " values('"+profname+"',"+profnumber+",'"+profcollage+"',0,0,0)").executeUpdate();
ChLabel.setText("A Professor has been added successfully");
ProfName.clear();
ProfNumber.clear();
  ProfCollage.clear();
          ChLabel.setStyle("-fx-text-fill:green;-fx-font-size:15px;");
       AddProfPane.getChildren().add(ChLabel);
    }catch (Exception ex) {
ex.printStackTrace();
ChLabel.setText("Failed to add the Professor");

          ChLabel.setStyle("-fx-text-fill:red;-fx-font-size:15px;");
       AddProfPane.getChildren().add(ChLabel);
    }    
        
    });
    border.setBottom(AddProfPane);

    
    
       }
       private void Addbook()throws ClassNotFoundException{
           AddProfPane.getChildren().clear();
           AddStudentPane.getChildren().clear();
           AddBookPane.getChildren().clear();
            AddVBox.getChildren().clear();
  DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
                items.clear();
                BorrPane.getChildren().clear();
RetPane.getChildren().clear();
             Button AddBook = new Button("Add Book");

    AddBookPane.setAlignment(Pos.CENTER);

          AddBookPane.setStyle("-fx-background-color:white;-fx-border-width:3px;-fx-border-color:black;");

    
   // pane.setHalignment(,HPos.CENTER);
    AddBookPane.setPadding(new Insets(11.5, 12.5, 225, 14.5));
    AddBookPane.setHgap(5.5);
    AddBookPane.setVgap(5.5);
    
    BookName.clear();
        Label LabelName = new Label("Book Title :");
    AddBookPane.setHalignment(LabelName,HPos.RIGHT);
    AddBookPane.add(LabelName, 0, 3);
    AddBookPane.add(BookName, 1, 3);
       BookNumber.clear();
    Label LabelNumber = new Label("Book Number :");
    AddBookPane.setHalignment(LabelNumber,HPos.RIGHT);
    AddBookPane.add(LabelNumber, 0, 5); 
    AddBookPane.add(BookNumber, 1, 5);
   Bookauthor.clear();
     Label Labelauthor = new Label("Book Author :");
    AddBookPane.setHalignment(Labelauthor,HPos.RIGHT);
    AddBookPane.add(Labelauthor, 2, 3); 
    AddBookPane.add(Bookauthor, 3, 3);
    publication.clear();
     Label labelpublication = new Label("publication :");
    AddBookPane.setHalignment(labelpublication,HPos.RIGHT);
    AddBookPane.add(labelpublication, 2, 5); 
    AddBookPane.add(publication, 3, 5);
    
    AddBookPane.setHalignment(AddBook,HPos.RIGHT);
    AddBookPane.add(AddBook, 5, 6);
    
    
        AddBook.setOnAction(e -> {
        
   String bookName = BookName.getText();
String bookNumber = BookNumber.getText();
String bookAuthor = Bookauthor.getText();
String bookpublication = publication.getText();
            
try {
  
                Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

   connection.prepareStatement("insert into book(bookname,booknumber,bookauthor,isbookborr,publication,flagBook) values('"+bookName+"','"+bookNumber+"','"+bookAuthor+"',0,'"+bookpublication+"',0)").executeUpdate();

ChLabel.setText("A book has been added successfully");
          ChLabel.setStyle("-fx-text-fill:green;-fx-font-size:15px;");
       AddBookPane.getChildren().add(ChLabel);
           publication.clear();  
           Bookauthor.clear();  
           BookNumber.clear();    
           BookName.clear();

    }catch (Exception ex) {
ex.printStackTrace();
ChLabel.setText("Failed to add the book");

          ChLabel.setStyle("-fx-text-fill:red;-fx-font-size:15px;");
       AddBookPane.getChildren().add(ChLabel);

}    
        
    });
            border.setBottom(AddBookPane);
       
       }
     private void Addstu()throws ClassNotFoundException{
         AddProfPane.getChildren().clear();
AddBookPane.getChildren().clear();
  AddStudentPane.getChildren().clear();
DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
                  AddVBox.getChildren().clear();
                items.clear();
                BorrPane.getChildren().clear();
RetPane.getChildren().clear();
Button AddStudent = new Button("Add Student");


    AddStudentPane.setAlignment(Pos.CENTER);

      
    AddStudentPane.setStyle("-fx-background-color:white;-fx-border-width:3px;-fx-border-color:black;");
    
   // pane.setHalignment(,HPos.CENTER);
    AddStudentPane.setPadding(new Insets(11.5, 12.5, 225, 14.5));
    AddStudentPane.setHgap(5.5);
    AddStudentPane.setVgap(5.5);
    
    StudentName.clear();
        Label LabelName = new Label("Studnet Name:");
    AddStudentPane.setHalignment(LabelName,HPos.RIGHT);
    AddStudentPane.add(LabelName, 0, 3);
    AddStudentPane.add(StudentName, 1, 3);
       StudnetNumber.clear();
    Label LabelNumber = new Label("Stunet Number :");
    AddStudentPane.setHalignment(LabelNumber,HPos.RIGHT);
    AddStudentPane.add(LabelNumber, 0, 5); 
    AddStudentPane.add(StudnetNumber, 1, 5);
    
    AddStudentPane.setHalignment(AddStudent,HPos.RIGHT);
    AddStudentPane.add(AddStudent, 4, 6);
    
    AddStudent.setOnAction(e -> {
        
   String Stname = StudentName.getText();
String Stnumber = StudnetNumber.getText();
            try {
  
                Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

       connection.prepareStatement("insert into student(stname,stnumber,isstuborr,flagStu,NoOfStBorr) values('"+Stname+"','"+Stnumber+"',0,0,0)").executeUpdate();


ChLabel.setText("A Student has been added successfully");
          ChLabel.setStyle("-fx-text-fill:green;-fx-font-size:15px;");
       AddStudentPane.getChildren().add(ChLabel);
              StudnetNumber.clear();    
              StudentName.clear();

    }catch (Exception ex) {
ex.printStackTrace();
ChLabel.setText("Failed to add the Student");

          ChLabel.setStyle("-fx-text-fill:red;-fx-font-size:15px;");
       AddStudentPane.getChildren().add(ChLabel);
    
    }    
        
    });
    border.setBottom(AddStudentPane);
  
   }
  
   private void Delete() {
             AddVBox.getChildren().clear();
  DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
AddProfPane.getChildren().clear();
AddBookPane.getChildren().clear();
  AddStudentPane.getChildren().clear();
           //     items.clear();  
                BorrPane.getChildren().clear();
RetPane.getChildren().clear();
   vbox.getChildren().clear();
   hbox3.getChildren().clear();
       Button DeleteBook = new Button("Delete Book");
       Button DeleteStude = new Button("Delete Student");
       Button DeleteProf = new Button("Delete Professor");

      DeleteBook.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      DeleteStude.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
      DeleteProf.setStyle("-fx-text-fill:orange;-fx-font-size:13;-fx-border-width:3px;-fx-font-weight:Bolder;-fx-background-color:white;-fx-border-color:#ff5c11;");
                 DeleteBook.setPrefSize(125, 40);
                 DeleteStude.setPrefSize(125, 40);
                 DeleteProf.setPrefSize(125, 40);


       AddVBox.setPadding(new Insets(11.5, 12.5, 13.5, 130));
AddVBox.getChildren().addAll(DeleteBook,DeleteStude,DeleteProf);
   

      /////////////////////////////////  delete Student
       DeleteStude.setOnAction(e -> {
          
    try{
          Deletestu();
    }catch (Exception ex) {
ex.printStackTrace();
}
   });
      
///////////////////////////////////      delete book
      DeleteBook.setOnAction(e -> {
          
    try{
          DeleteBook();
    }catch (Exception ex) {
ex.printStackTrace();
}
});
      
//////////////////////////////////////  add prof

     DeleteProf.setOnAction(e -> {
        try{
Deleteprof();
        }catch (Exception ex) {
ex.printStackTrace();
} 
 
});
   
   }
   
    private void Deletestu() throws ClassNotFoundException {
       DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
                     AddVBox.getChildren().clear();
AddProfPane.getChildren().clear();
AddBookPane.getChildren().clear();
  AddStudentPane.getChildren().clear();
                items.clear();
                ChDelete.clear();
                BorrPane.getChildren().clear();
RetPane.getChildren().clear();
hbox2.getChildren().clear();
vbox.getChildren().clear();
hbox3.getChildren().clear();
    String StuDelete[] = new String[200];

    Button DeleteStudent = new Button("Delete Student");
DeleteLabel.setText("");
Search.clear();
      HBox hbox = new HBox();
    DeleteStudentPane.setStyle("-fx-background-color:white;-fx-border-width:3px;");
    
    DeleteStudentPane.setPadding(new Insets(11,0,0,0));
     hbox1.setPadding(new Insets(20  , 50,0  , 50));
     hbox2.setPadding(new Insets(0  ,50 ,220,50));
     hbox3.setPadding(new Insets(0  ,50 ,0  , 50));
     vbox.setPadding(new Insets(0, 50   ,0  ,50));
    DeleteStudentPane.setHgap(5.5);
    DeleteStudentPane.setVgap(5.5);
    
        Label SearchSt = new Label("Search for student :");
    DeleteStudentPane.setHalignment(SearchSt,HPos.RIGHT);
    DeleteStudentPane.add(SearchSt, 0, 3);
    DeleteStudentPane.add(Search, 1, 3);
       
       
    DeleteStudentPane.setHalignment(DeleteStudent,HPos.RIGHT);
    DeleteStudentPane.add(DeleteStudent, 5, 3);
    
    DeleteStudentPane.add( comboBox, 4,3);
    hbox2.getChildren().add(DeleteStudentPane);
    try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select stname,stnumber from student where flagStu=0";


   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String stname = result.getString(1);
Integer  stnumber = result.getInt(2);
   StuDelete[i] = stnumber+"-"+stname;

i++;
 }  
items=  FXCollections.observableArrayList(StuDelete);
 comboBox.setItems(items);

 
}
catch (Exception ex) {
ex.printStackTrace();
}    

    Search.setOnKeyReleased(e -> {
     items.clear();
           String infoSt[] = new String[200];

       String stName =Search.getText();
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select stname,stnumber from student  where stname like '"+stName+"%' && flagStu=0";

   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String stname = result.getString(1);
Integer stnumer = result.getInt(2);
   infoSt[i] =stnumer+"-"+stname;

i++;
 }    
items=  FXCollections.observableArrayList(infoSt);
 comboBox.setItems(items);

    hbox1.setPadding(new Insets(20  , 0,0  , 50));
      hbox2.setPadding(new Insets(0  ,0 ,10,50));
      hbox3.setPadding(new Insets(0  ,0 ,10  , 50));
      vbox.setPadding(new Insets(0, 0   ,0  ,50));
 ChDelete.clear();
hbox3.getChildren().add(ChDelete);
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
    
    comboBox.setOnAction(e -> {
                ChDelete.clear();
hbox3.getChildren().clear();
    valueComoBox = comboBox.getValue();
   Label lb = new Label();
        try {

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection
("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select stname,stnumber from student where flagStu=0";

   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String stname = result.getString(1);
Integer  number = result.getInt(2);
   String info = number+"-"+stname;

    if(valueComoBox.equalsIgnoreCase(info)){     
String Sql = "select stname,stnumber,isstuborr,NoOfStBorr from student where stnumber="+number+" ";
            preparedStatement = connection.prepareStatement(Sql);
result = preparedStatement.executeQuery();
 while(result.next()) {
      
String name = result.getString(1);
  stnumber = result.getInt(2);
  isStuBorr = result.getInt(3);
Integer  numOfBookBorr = result.getInt(4);

            tempStu = "Name: "+name +" || Number: "+stnumber +" || No. of borrowed book: "+numOfBookBorr;
 }

      hbox1.setPadding(new Insets(20  , 0,0  , 50));
      hbox2.setPadding(new Insets(0  ,0 ,10,50));
      hbox3.setPadding(new Insets(0  ,0 ,10  , 50));
      vbox.setPadding(new Insets(0, 0   ,0  ,50));
 ChDelete.setText(tempStu);
hbox3.getChildren().add(ChDelete);
    }
 }  


 
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
    
    
   DeleteStudent.setOnAction(e -> {        
        if(valueComoBox == null){
   
  Stage stage = new Stage(); 
    stage.setTitle("Warning !!!"); 
        VBox Vpane = new VBox(25);
    Vpane.setPadding(new Insets(80  ,0 ,0,90));
Label lb =new Label("Please Choose Name from combo box");
           lb.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-font-family:serif;");

                    Vpane.setStyle("-fx-background-color:white;-fx-border-color:black;");

 Vpane.getChildren().add(lb);
    stage.setScene(new Scene(Vpane, 400, 200));        
    stage.show();
    
    }else{
            try{  
         CheckDeleteStudent();
     }catch (Exception ex) {
ex.printStackTrace();
}  
    }
           
      
    }); 
      vbox.getChildren().addAll(hbox1,hbox2,hbox3);
      border.setBottom(vbox);

    }
        private void CheckDeleteStudent() throws ClassNotFoundException {
Stage stage = new Stage(); 
    stage.setTitle("Warning !!!");
    
    HBox pane = new HBox(20);
       
    pane.setPadding(new Insets(50  ,0 ,0,70));
    Button btOk = new Button("Ok");
    Button btCancel = new Button("Cancel");
        btOk.setPrefSize(125, 40);
                      pane.setStyle("-fx-background-color:white;");

       btOk.setStyle("-fx-background-color:#99ff66;");

    btCancel.setPrefSize(125, 40);
       btCancel.setStyle("-fx-background-color:red;");
 
    pane.getChildren().addAll(btCancel,btOk);
    stage.setScene(new Scene(pane, 400, 200));        
    stage.show();
        btOk.setOnMouseClicked(e -> {   
          try {
            
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");



    if(isStuBorr==1){     

DeleteLabel.setText("The user cannot be deleted");
DeleteLabel.setStyle("-fx-text-fill:red;-fx-font-size:15px;");
   
    }else{
        
        
          connection.prepareStatement("update student set flagStu=1  where stnumber="+stnumber+"").executeUpdate();

System.out.println("the number"+stnumber);
System.out.println("the borrow "+isStuBorr);
    

          DeleteLabel.setText("The user has been deleted successfully");
DeleteLabel.setStyle("-fx-text-fill:Green;-fx-font-size:15px;");
        }
          hbox1.setPadding(new Insets(5  , 0,0  , 50));
       hbox1.getChildren().add(DeleteLabel);

        }  
catch (Exception ex) {
ex.printStackTrace();

} 
    stage.close();
  }); 
             btCancel.setOnMouseClicked(e -> {   
   stage.close();
   }); 

}
  
private void Deleteprof() throws ClassNotFoundException {
DeleteStudentPane.getChildren().clear();
DeleteProfPane.getChildren().clear();
DeleteBookPane.getChildren().clear();
           ReportPane.getChildren().clear();
  AddVBox.getChildren().clear();
AddProfPane.getChildren().clear();
AddBookPane.getChildren().clear();
  AddStudentPane.getChildren().clear();
        items.clear();
        BorrPane.getChildren().clear();
RetPane.getChildren().clear();
hbox2.getChildren().clear();
DeleteLabel.setText("");

    String ProfDelete[] = new String[200];

     Button Deleteprof = new Button("Delete Professor");

      HBox hbox = new HBox();
    DeleteProfPane.setStyle("-fx-background-color:white;-fx-border-width:3px;");
    
    DeleteProfPane.setPadding(new Insets(11.5,0,0,0));
                            hbox1.setPadding(new Insets(20  , 50,0  , 50));
                            hbox2.setPadding(new Insets(0  ,50 ,220,50));
                            hbox3.setPadding(new Insets(0  ,50 ,0  , 50));
                            vbox.setPadding(new Insets(0, 50   ,0  ,50));
    DeleteProfPane.setHgap(5.5);
    DeleteProfPane.setVgap(5.5);
    Search.clear();
        Label SearchProf = new Label("Search for student :");
    DeleteProfPane.setHalignment(SearchProf,HPos.RIGHT);
    DeleteProfPane.add(SearchProf, 0, 3);
    DeleteProfPane.add(Search, 1, 3);
       
       
    DeleteProfPane.setHalignment(Deleteprof,HPos.RIGHT);
    DeleteProfPane.add(Deleteprof, 5, 3);
    
    DeleteProfPane.add( comboBox, 4,3);
    hbox2.getChildren().add(DeleteProfPane);
    try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select profname,profnumber from professor where flagProf=0";


   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String profname = result.getString(1);
Integer  profnumber = result.getInt(2);
   ProfDelete[i] = profnumber+"-"+profname;

i++;
 }  
items=  FXCollections.observableArrayList(ProfDelete);
 comboBox.setItems(items);

 
}
catch (Exception ex) {
ex.printStackTrace();
}    

    Search.setOnKeyReleased(e -> {
     items.clear();
           String infoprof[] = new String[200];

       String profName =Search.getText();
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select profname,profnumber from professor  where profname like '"+profName+"%' && flagProf=0";

   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String profname = result.getString(1);
Integer profnumer = result.getInt(2);
   infoprof[i] =profnumer+"-"+profname;
        i++;
 }    
items=  FXCollections.observableArrayList(infoprof);
 comboBox.setItems(items);

 
    hbox1.setPadding(new Insets(20  , 0,0  , 50));
      hbox2.setPadding(new Insets(0  ,0 ,10,50));
      hbox3.setPadding(new Insets(0  ,0 ,10  , 50));
      vbox.setPadding(new Insets(0, 0   ,0  ,50));
 ChDelete.clear();
hbox3.getChildren().add(ChDelete);
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
      
comboBox.setOnAction(e -> {
        ChDelete.clear();
   hbox3.getChildren().clear();
   
 valueComoBox = comboBox.getValue();
        try {

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection
("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select profname,profnumber from professor where flagProf=0 ";

   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String profname = result.getString(1);
Integer  number = result.getInt(2);
   String info = number+"-"+profname;

    if(valueComoBox.equalsIgnoreCase(info)){     
String Sql = "select profname,profnumber,isprofborr,NoOfProfBorr,profcollage from professor where profnumber="+number+" ";
            preparedStatement = connection.prepareStatement(Sql);
result = preparedStatement.executeQuery();

while(result.next()) {
      
String name = result.getString(1);
  profnumber = result.getInt(2);
  isProfBorr = result.getInt(3);
Integer  numOfBookBorr = result.getInt(4);
String  profcollage = result.getString(5);

    tempProf = "Name: "+name +" || Number: "+stnumber +" || No. of borrowed book: "+numOfBookBorr+" || Collage :"+profcollage;
 }
 

 ChDelete.setText(tempProf);
ChDelete.setPrefSize(650,200);
hbox3.getChildren().add(ChDelete);
      hbox1.setPadding(new Insets(20, 0,0 , 50));
      hbox2.setPadding(new Insets(0,0 ,10 ,50));
      hbox3.setPadding(new Insets(0,0 ,10 , 50));
      vbox.setPadding(new Insets(0 ,0 ,0  ,50));
    }
 }  


 
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
    
    Deleteprof.setOnAction(e -> {
        if(valueComoBox == null){
   
  Stage stage = new Stage(); 
    stage.setTitle("Warning !!!"); 
        VBox Vpane = new VBox(25);
    Vpane.setPadding(new Insets(80  ,0 ,0,90));
Label lb =new Label("Please Choose Name from combo box");
           lb.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-font-family:serif;");

                    Vpane.setStyle("-fx-background-color:white;-fx-border-color:black;");

 Vpane.getChildren().add(lb);
    stage.setScene(new Scene(Vpane, 400, 200));        
    stage.show();
    
    }else{
            try{  
         CheckDeleteProf();
     }catch (Exception ex) {
ex.printStackTrace();
}  
    }
           }); 
   vbox.getChildren().addAll(hbox1,hbox2,hbox3);
      border.setBottom(vbox);
}
    private void CheckDeleteProf() throws ClassNotFoundException {
Stage stage = new Stage(); 
    stage.setTitle("Warning !!!");
    
    HBox pane = new HBox(20);
       
    pane.setPadding(new Insets(50  ,0 ,0,70));
    Button btOk = new Button("Ok");
    Button btCancel = new Button("Cancel");
        btOk.setPrefSize(125, 40);
                      pane.setStyle("-fx-background-color:white;");

       btOk.setStyle("-fx-background-color:#99ff66;");

    btCancel.setPrefSize(125, 40);
       btCancel.setStyle("-fx-background-color:red;");
 
    pane.getChildren().addAll(btCancel,btOk);
    stage.setScene(new Scene(pane, 400, 200));        
    stage.show();
        btOk.setOnMouseClicked(e -> {   
  try {
            
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

    if(isProfBorr==1){     

DeleteLabel.setText("This user cannot be deleted");
DeleteLabel.setStyle("-fx-text-fill:red;-fx-font-size:15px;");
    }else{
        connection.prepareStatement("update professor set flagProf=1  where profnumber="+profnumber+"").executeUpdate();
          DeleteLabel.setText("This user has been deleted successfully");
DeleteLabel.setStyle("-fx-text-fill:Green;-fx-font-size:15px;");
        }
     stage.close();     
    hbox1.setPadding(new Insets(0, 0,0 , 50));
  
         hbox1.getChildren().add(DeleteLabel);
 }
catch (Exception ex) {
ex.printStackTrace();

}
   }); 
             btCancel.setOnMouseClicked(e -> {   
   stage.close();
   }); 
}
private void DeleteBook() throws ClassNotFoundException {     
       DeleteStudentPane.getChildren().clear();
        DeleteProfPane.getChildren().clear();
        DeleteBookPane.getChildren().clear();
                   ReportPane.getChildren().clear();
  AddVBox.getChildren().clear();
AddProfPane.getChildren().clear();
AddBookPane.getChildren().clear();
  AddStudentPane.getChildren().clear();
   //     items.clear();
        BorrPane.getChildren().clear();
RetPane.getChildren().clear();
        ChDelete.clear();
        hbox2.getChildren().clear();
DeleteLabel.setText("");

             HBox hbox = new HBox();     


            String BookDelete[] = new String[200];

     Button DeleteBook = new Button("Delete Book");
                           hbox1.setPadding(new Insets(20  , 50,0  , 50));
                            hbox2.setPadding(new Insets(0  ,50 ,220,50));
                            hbox3.setPadding(new Insets(0  ,50 ,0  , 50));
                            vbox.setPadding(new Insets(0, 50   ,0  ,50));

         Search.clear();

    DeleteBookPane.setStyle("-fx-background-color:white;-fx-border-width:3px;");
    
    DeleteBookPane.setPadding(new Insets(11.5, 0, 0, 0));

    DeleteBookPane.setHgap(5.5);
    DeleteBookPane.setVgap(5.5);
    
        Label SearchBook = new Label("Search for Book :");
    DeleteBookPane.setHalignment(SearchBook,HPos.RIGHT);
    DeleteBookPane.add(SearchBook, 0, 3);
    DeleteBookPane.add(Search, 1, 3);
       
    DeleteBookPane.setHalignment(DeleteBook,HPos.RIGHT);
    DeleteBookPane.add(DeleteBook, 5, 3);
    
    DeleteBookPane.add( comboBox, 4,3);
    hbox2.getChildren().add(DeleteBookPane);
    try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select bookname,booknumber from book where flagBook=0";


   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String bookname = result.getString(1);
Integer  booknumber = result.getInt(2);
   BookDelete[i] = booknumber+"-"+bookname;

i++;
 }  
items=  FXCollections.observableArrayList(BookDelete);
 comboBox.setItems(items);

 
}
catch (Exception ex) {
ex.printStackTrace();
}    

    Search.setOnKeyReleased(e -> {
     items.clear();
           String infobook[] = new String[200];

       String bookName =Search.getText();
        try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select bookname,booknumber from book where bookname like '"+bookName+"%' && flagBook=0";

   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String bookname = result.getString(1);
Integer booknumer = result.getInt(2);
   infobook[i] =booknumer+"-"+bookname;

i++;
 }    
items=  FXCollections.observableArrayList(infobook);
 comboBox.setItems(items);

    hbox1.setPadding(new Insets(20  , 0,0  , 50));
      hbox2.setPadding(new Insets(0  ,0 ,10,50));
      hbox3.setPadding(new Insets(0  ,0 ,10  , 50));
      vbox.setPadding(new Insets(0, 0   ,0  ,50));
 ChDelete.clear();
hbox3.getChildren().add(ChDelete);
 
}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
    
    comboBox.setOnAction(e -> {
   
          hbox3.getChildren().clear();
ChDelete.clear();
    valueComoBox = comboBox.getValue();

    Label lb = new Label();
        try {

Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection
("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");

String sql = "select bookname,booknumber from book";

   PreparedStatement preparedStatement = connection.prepareStatement(sql);

 result = preparedStatement.executeQuery();
int i = 0;
 while(result.next()) {
String bookname = result.getString(1);
Integer  number = result.getInt(2);
   String info = number+"-"+bookname;

    if(valueComoBox.equalsIgnoreCase(info)){     
String Sql = "select bookname,booknumber,bookauthor,isbookborr,publication from book where booknumber="+number+" ";
            preparedStatement = connection.prepareStatement(Sql);
result = preparedStatement.executeQuery();
 while(result.next()) {
      
String name = result.getString(1);
  booknumber = result.getInt(2);
String bookauthor = result.getString(3);  
  isBookBorr = result.getInt(4);
Integer  publication = result.getInt(5);

            tempStu = "Name: "+name +" || Number: "+booknumber +" || book author: "+bookauthor+" || publication year:"+publication;
 }
  ChDelete.setText(tempStu);
    ChDelete.setPrefSize(650, 200);

hbox3.getChildren().add(ChDelete);
    hbox1.setPadding(new Insets(20  , 0, 0, 50));
   hbox2.setPadding(new Insets(0    , 0,10,50));
   hbox3.setPadding(new Insets(0    , 0,10, 50));
   vbox.setPadding(new Insets(0     , 0, 0,50));

    }
 }  

}
catch (Exception ex) {
ex.printStackTrace();

}       
    });
    DeleteBook.setOnAction(e -> {
        
        if(valueComoBox == null){
   
  Stage stage = new Stage(); 
    stage.setTitle("Warning !!!"); 
        VBox Vpane = new VBox(25);
    Vpane.setPadding(new Insets(80  ,0 ,0,90));
Label lb =new Label("Please Choose Name from combo box");
           lb.setStyle("-fx-text-fill:black;-fx-font-size:15;-fx-font-weight:Bolder;-fx-font-family:serif;");

                    Vpane.setStyle("-fx-background-color:white;-fx-border-color:black;");

 Vpane.getChildren().add(lb);
    stage.setScene(new Scene(Vpane, 400, 200));        
    stage.show();
    
    }else{
            try{  
         CheckDeleteBook();
     }catch (Exception ex) {
ex.printStackTrace();
}  
    }
           });
    vbox.getChildren().addAll(hbox1,hbox2,hbox3);
    
      border.setBottom(vbox);
   
}
    private void CheckDeleteBook() throws ClassNotFoundException {
Stage stage = new Stage(); 
    stage.setTitle("Warning !!!");
    
    HBox pane = new HBox(20);
       
    pane.setPadding(new Insets(50  ,0 ,0,70));
    Button btOk = new Button("Ok");
    Button btCancel = new Button("Cancel");
        btOk.setPrefSize(125, 40);
                      pane.setStyle("-fx-background-color:white;");

       btOk.setStyle("-fx-background-color:#99ff66;");

    btCancel.setPrefSize(125, 40);
       btCancel.setStyle("-fx-background-color:red;");
 
    pane.getChildren().addAll(btCancel,btOk);
    stage.setScene(new Scene(pane, 400, 200));        
    stage.show();
        btOk.setOnMouseClicked(e -> {   
    

        try {
            
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
Connection connection = DriverManager.getConnection

("jdbc:mysql://localhost/library", "root", "");
System.out.println("Database connected");



    if(isBookBorr==1){     

DeleteLabel.setText("The user cannot be deleted");
DeleteLabel.setStyle("-fx-text-fill:red;-fx-font-size:15px;");

    }else{
        
        connection.prepareStatement("update book set flagBook=1  where booknumber="+booknumber+"").executeUpdate();

          DeleteLabel.setText("The user has been deleted successfully");
DeleteLabel.setStyle("-fx-text-fill:Green;-fx-font-size:15px;");

    }
      hbox1.setPadding(new Insets(5  , 0,0  , 50));
       hbox1.getChildren().add(DeleteLabel);
       
      stage.close();

        }  
        
catch (Exception ex) {
ex.printStackTrace();

}
      stage.close();
}); 
             btCancel.setOnMouseClicked(e -> {   
   stage.close();
   }); 

}
   
 public static void main(String[] args) {
    launch(args);
  }

}