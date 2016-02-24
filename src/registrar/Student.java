package registrar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bjackson on 2/21/2016.
 */
public class Student {

    public String name;
    public Set<Course> enrolledIn;

    public Student(){
        enrolledIn = new HashSet<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Course> getCourses(){
        return enrolledIn;
    }

    public boolean enrollIn(Course courseName){
        if(courseName.enrollIn(this)) {
            enrolledIn.add(courseName);
            return true;
        }
        else {
            return false;
        }
    }

    public void drop(Course courseName){
        if (enrolledIn.contains(courseName)) {
            enrolledIn.remove(courseName);
        }
        courseName.dropStudent(this);
    }
}
