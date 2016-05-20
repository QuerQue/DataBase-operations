import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Tomek on 5/18/2016.
 */
public class UserData
{
    private int Id;
    private StringProperty Name;
    private StringProperty Email;

    public UserData(int Id, String Name, String Email){
        this.Id = Id;
        this.Name = new SimpleStringProperty(Name);
        this.Email = new SimpleStringProperty(Email);
    }

    public StringProperty NameProperty(){
        return Name;
    }


    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public StringProperty EmailProperty(){
        return Email;



    }
}
