package Lbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseCon {

    private static Connection connection = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DatabaseCon() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lbs_db", "root", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //user login method
    public boolean isUserLoginSuccess(String username, String password) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM user WHERE username = ? and password = ? LIMIT 1");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            LoggedUser loginDetails = new LoggedUser();

            if (rs.next()) {
                loginDetails.setLoginUser(new UserProfile(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("role"), rs.getString("address"), rs.getString("tp_no"), rs.getString("nic_no"), rs.getString("email")));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void refreshLoggedUserDetails(int userId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM user WHERE id = ? LIMIT 1");
            //set user id
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            LoggedUser loginDetails = new LoggedUser();
            if (rs.next()) {
                loginDetails.setLoginUser(new UserProfile(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("role"), rs.getString("address"), rs.getString("tp_no"), rs.getString("nic_no"), rs.getString("email")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //user details update method
    public boolean updateUserDetails(int userId, String username, String password, String role, String name, String email, String tp, String department, String imagePath) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //build query
            ps = connection.prepareStatement("UPDATE user_profiles SET username=?, password=?, role=?, name=?, email=?, tp=?, department=?, pro_image=? WHERE id=?");
            //set username and password to query
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setString(4, name);
            ps.setString(5, email);
            ps.setString(6, tp);
            ps.setString(7, department);
            ps.setString(8, imagePath);
            ps.setInt(9, userId);

            //run the query and check if update is success or not            
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //get attendance detail for selected user
    public ArrayList getAttendanceDetails(int userId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            //build query
            ps = connection.prepareStatement("SELECT cour.course_code, cour.course_name, attn.date FROM student_attendance attn "
                    + "LEFT JOIN courses cour ON attn.course_id = cour.id WHERE attn.user_profiles_id = ?");
            //set user id
            ps.setInt(1, userId);
            //run the query
            rs = ps.executeQuery();
            while (rs.next()) {
                //store attendance details to array list
                list.add(new String[]{rs.getString("course_code"), rs.getString("course_name"), rs.getString("date")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //get course detail for selected user
    public ArrayList getCourseDetails(int userId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            //build query
            ps = connection.prepareStatement("SELECT cours.course_code, cours.course_type, cours.course_name FROM student_courses stcour "
                    + "LEFT JOIN courses cours ON stcour.courses_id = cours.id WHERE stcour.user_profiles_id = ?");
            //set user id
            ps.setInt(1, userId);
            //run the query
            rs = ps.executeQuery();
            while (rs.next()) {
                //store course details to array list
                list.add(new String[]{rs.getString("course_code"), rs.getString("course_type"), rs.getString("course_name")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //get marks detail for selected user
    public ArrayList getMarksDetails(int userId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            //build query
            ps = connection.prepareStatement("SELECT cur.course_code, exm.exam_name, exm.date, mrk.marks, mrk.grade, mrk.gpa FROM student_marks mrk "
                    + "LEFT JOIN exams exm ON mrk.exams_id = exm.id "
                    + "LEFT JOIN courses cur ON exm.courses_id = cur.id "
                    + "WHERE mrk.user_profiles_id = ?");
            //set user id
            ps.setInt(1, userId);
            //run the query
            rs = ps.executeQuery();
            while (rs.next()) {
                //store marks details to array list
                list.add(new String[]{rs.getString("course_code"), rs.getString("exam_name"), rs.getString("date"), rs.getString("marks"), rs.getString("grade"), rs.getString("gpa")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //get medical detail for selected user
    public ArrayList getMedicaleDetails(int userId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            //build query
            ps = connection.prepareStatement("SELECT from_date, to_date, reason FROM medicals WHERE user_profiles_id = ?");
            //set user id
            ps.setInt(1, userId);
            //run the query
            rs = ps.executeQuery();
            while (rs.next()) {
                //store medical details to array list
                list.add(new String[]{rs.getString("from_date"), rs.getString("to_date"), rs.getString("reason")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //get time table detail for selected user
    public ArrayList getTimeTableDetails(int userId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            //build query
            ps = connection.prepareStatement("SELECT curs.course_code, curs.course_type, curs.course_name, timet.date, timet.start_time, timet.end_time, timet.location FROM timetables timet "
                    + "LEFT JOIN student_courses stcurs ON stcurs.courses_id = timet.course_id "
                    + "INNER JOIN courses curs ON timet.course_id = curs.id "
                    + "WHERE stcurs.user_profiles_id = ?");
            //set user id
            ps.setInt(1, userId);
            //run the query
            rs = ps.executeQuery();
            while (rs.next()) {
                //store time table details to array list
                list.add(new String[]{rs.getString("course_code"), rs.getString("course_type"), rs.getString("course_name"), rs.getString("date"), rs.getString("start_time"), rs.getString("end_time"), rs.getString("location")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //get notice detail for selected user
    public ArrayList getNoticeDetails() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            //build query
            ps = connection.prepareStatement("SELECT title, date, message FROM notices");
            //run the query
            rs = ps.executeQuery();
            while (rs.next()) {
                //store time table details to array list
                list.add(new String[]{rs.getString("title"), rs.getString("date"), rs.getString("message")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    ///////////////////////////////////////////// LBS////////////////////////////////
    public ArrayList getAllBooksFromDB() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            ps = connection.prepareStatement("SELECT bk.id, bk.code, bk.name, bk.category, bk.created_at, IF((SELECT ibk.return_status FROM issued_book ibk WHERE ibk.book_code = bk.code AND ibk.status = 'A' ORDER BY ibk.id ASC LIMIT 1) = 'Pending', 'Isuued', 'Available') as status FROM book bk");
            rs = ps.executeQuery();
            while (rs.next()) {
                //store attendance details to array list
                list.add(new String[]{rs.getString("id"), rs.getString("code"), rs.getString("name"), rs.getString("category"), rs.getString("created_at"), rs.getString("status")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean saveNewBook(String code, String name, String category) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO book(code, name, category, created_at, status) VALUES (?,?,?,?,?)");
            ps.setString(1, code);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setString(4, dateFormat.format(new Date()));
            ps.setString(5, "A");

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBook(int id, String code, String name, String category) {

        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("UPDATE book SET code=?, name=?, category=? WHERE id=?");
            ps.setString(1, code);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setInt(4, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isThisCodeAlreadyUsed(String code) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT id FROM book WHERE code = ?  LIMIT 1");
            ps.setString(1, code);
            //run the query
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addUser(String username, String password, String name, String email, String tp, String nic, String address, String role) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO  user (username, password, name, email, role, address, tp_no, nic_no, created_at, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setString(5, role);
            ps.setString(6, address);
            ps.setString(7, tp);
            ps.setString(8, nic);
            ps.setString(9, dateFormat.format(new Date()));
            ps.setString(10, "A");

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(int id, String name, String email, String tp, String nic, String address, String role) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE user SET name=?, email=?, role=?, address=?, tp_no=?, nic_no=? WHERE id=?");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, role);
            ps.setString(4, address);
            ps.setString(5, tp);
            ps.setString(6, nic);
            ps.setInt(7, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isThisUsernameAlreadyUsed(String username) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT id FROM user WHERE username = ?  LIMIT 1");
            ps.setString(1, username);
            //run the query
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList getAlUsersFromDB() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            ps = connection.prepareStatement("SELECT id, username, name, role, created_at FROM user WHERE status = 'A'");
            rs = ps.executeQuery();
            while (rs.next()) {
                //store attendance details to array list
                list.add(new String[]{rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("role"), rs.getString("created_at")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserProfile getSelecteduserDetails(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("SELECT id, username, password, name, role, address, tp_no, nic_no, email FROM user WHERE id = " + id + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserProfile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, Integer> getAlUsersForIssueBook() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        HashMap<String, Integer> list = new HashMap<>();

        try {
            ps = connection.prepareStatement("SELECT id, username FROM user WHERE status = 'A'");
            rs = ps.executeQuery();
            while (rs.next()) {
                //store attendance details to array list
                list.put(rs.getString(2), rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean isThisAvailbeForIssue(String code) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean bookStaus = true;
        try {
            ps = connection.prepareStatement("SELECT id FROM  issued_book WHERE book_code = ? AND return_status = ? AND status = 'A'");
            ps.setString(1, code);
            ps.setString(2, "Pending");
            rs = ps.executeQuery();
            if (rs.next()) {
                bookStaus = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookStaus;
    }

    public String isThisBookCodeValid(String code) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT name FROM book WHERE code = ? AND status = 'A'");
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean saveIssueBookDataToDb(String code, int brUserId, String retDate, String remarks) {

        PreparedStatement ps = null;
        LoggedUser loggedUser = new LoggedUser();

        try {
            ps = connection.prepareStatement("INSERT INTO issued_book (book_code, issued_user, borrowed_user, borrowed_date, return_date, return_status, issue_remarks, created_at, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, code);
            ps.setInt(2, loggedUser.getLoginUser().userId);
            ps.setInt(3, brUserId);
            ps.setString(4, dateFormat.format(new Date()));
            ps.setString(5, retDate);
            ps.setString(6, "Pending");
            ps.setString(7, remarks);
            ps.setString(8, dateFormat.format(new Date()));
            ps.setString(9, "A");
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList getAllIssuedBooksFromDB(int studentId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        String query = "SELECT ibk.id, ibk.book_code, usr.username, ibk.borrowed_date, ibk.return_date, ibk.return_status FROM issued_book ibk INNER JOIN user usr ON ibk.borrowed_user = usr.id WHERE ibk.status = 'A' AND ibk.return_status = 'Pending'";

        if (studentId > 0) {
            query = "SELECT ibk.id, ibk.book_code, usr.username, ibk.borrowed_date, ibk.return_date, ibk.return_status FROM issued_book ibk INNER JOIN user usr ON ibk.borrowed_user = usr.id WHERE ibk.status = 'A' AND ibk.return_status = 'Pending' AND ibk.borrowed_user = " + studentId + "";
        }

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //store attendance details to array list
                list.add(new String[]{rs.getString("id"), rs.getString("book_code"), rs.getString("username"), rs.getString("borrowed_date"), rs.getString("return_date"), rs.getString("return_status")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList getAllReturnedBooksFromDB(int studentId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        String query = "SELECT ibk.id, ibk.book_code, usr.username, ibk.borrowed_date, ibk.return_date, ibk.return_status FROM issued_book ibk INNER JOIN user usr ON ibk.borrowed_user = usr.id WHERE ibk.status = 'A' AND ibk.return_status = 'Returned'";

        if (studentId > 0) {
            query = "SELECT ibk.id, ibk.book_code, usr.username, ibk.borrowed_date, ibk.return_date, ibk.return_status FROM issued_book ibk INNER JOIN user usr ON ibk.borrowed_user = usr.id WHERE ibk.status = 'A' AND ibk.return_status = 'Returned' AND ibk.borrowed_user = " + studentId + "";
        }

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //store attendance details to array list
                list.add(new String[]{rs.getString("id"), rs.getString("book_code"), rs.getString("username"), rs.getString("borrowed_date"), rs.getString("return_date"), rs.getString("return_status")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean saveReturnBookDataToDb(int id, String retDate, String remarks) {

        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("UPDATE issued_book SET ac_return_date=?, return_status=?, return_remarks=?, updated_at=? WHERE id=?");

            ps.setString(1, retDate);
            ps.setString(2, "Returned");
            ps.setString(3, remarks);
            ps.setString(4, dateFormat.format(new Date()));
            ps.setInt(5, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> isThisBookCanReturn(String code) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList();

        try {
            ps = connection.prepareStatement("SELECT ibk.id, usr.name FROM issued_book ibk LEFT JOIN user usr ON ibk.borrowed_user = usr.id WHERE ibk.book_code = ? AND ibk.status = 'A' AND ibk.return_status = 'Pending' LIMIT 1");
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>(Arrays.asList(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
