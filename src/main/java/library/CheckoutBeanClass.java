

package library;

import java.sql.Date;


public class CheckoutBeanClass {
    
   private String DateBorrowed;
   private String MemberID;
   private String Fullname;
   private String Username;
   private String Password;
   private String BookID;
   private String BookTitle;

    

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String MemberID) {
        this.MemberID = MemberID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }
    public String getDateBorrowed() {
        return DateBorrowed;
    }

    public void setDateBorrowed(String DateBorrowed) {
        this.DateBorrowed = DateBorrowed;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    
}
