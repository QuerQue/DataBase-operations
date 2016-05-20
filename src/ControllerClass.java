import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


/**
 * Created by Tomek on 5/18/2016.
 */
public class ControllerClass implements Initializable
{
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtemail;
    @FXML
    private TableView table;
    @FXML
    private TableColumn column1;
    @FXML
    private TableColumn column2;
    @FXML
    private TableColumn column3; //id
    @FXML
    private TextField txtid;
    @FXML
    private Button button;


    private ObservableList<UserData> data = FXCollections.observableArrayList();
    PreparedStatement prep;
    Connection con;


    public void buildData(){
        try{
            con = ConnectionSQL.Connector();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM test");
            while (rs.next()){
                data.add(new UserData(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email")));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveButton(ActionEvent event){
        try{
            prep = con.prepareStatement("INSERT INTO test VALUES(?,?,?);");
            prep.setInt(1, Integer.parseInt(txtid.getText()));
            prep.setString(2, txtname.getText());
            prep.setString(3, txtemail.getText());
            prep.execute();
            data.add(new UserData(Integer.parseInt(txtid.getText()), txtname.getText(), txtemail.getText()));
            txtid.setText(null); txtname.setText(null); txtemail.setText(null);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQL exception");
        }
}

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        buildData();

        column1.setCellValueFactory(new PropertyValueFactory("Name"));
        column2.setCellValueFactory(new PropertyValueFactory("Email"));
        column3.setCellValueFactory(new PropertyValueFactory("Id"));
        table.setItems(null);
        table.setItems(data);
    }

}
