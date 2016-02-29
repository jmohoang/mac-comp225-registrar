package registrar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bjackson on 2/21/2016.
 */
public class Course {

    private Set<Student> enrolledIn;
    private List<Student> waitlist;
    private String number;
    private String name;
    private int limit;

    public Course(){
        enrolledIn = new HashSet<>();
        waitlist = new ArrayList<>();
        limit = 16;
    }

    public void setCatalogNumber(String number){
        this.number = number;
    }

    public void setTitle(String title){
        this.name = title;
    }

    public int getEnrollmentLimit(){
        return limit;
    }

    public boolean setEnrollmentLimit(int limit){
        //If students are enrolled you can't change the limit
        if (enrolledIn.size() == 0){
            this.limit = limit;
            return true;
        }
        return false;
    }

    public Set<Student> getStudents(){
        return enrolledIn;
    }

    public List<Student> getWaitList(){
        return waitlist;
    }

    public boolean enrollIn(Student name){
        if (enrolledIn.contains(name)){
            return true;
        }
        if (enrolledIn.size() >= limit){
            if (waitlist.contains(name)){
                return false;
            }
            waitlist.add(name);
            return false;
        }
        enrolledIn.add(name);
        return true;
    }

    public void dropStudent(Student name){
        if (enrolledIn.contains(name)) {
            enrolledIn.remove(name);
            if (waitlist.size() > 0) {
                Student toEnroll = waitlist.remove(0);
                enrolledIn.add(toEnroll);
                toEnroll.enrolledIn.add(this);
            }
        }
        else if (waitlist.contains(name)){
            waitlist.remove(name);
        }
    }
    public void removeEnrollmentLimit(){}

}
