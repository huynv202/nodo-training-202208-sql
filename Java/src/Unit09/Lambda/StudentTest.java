package Unit09.Lambda;

import javax.imageio.spi.ServiceRegistry;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

public class StudentTest {
    public static List<Student> filter (List<Student> students, Student.Filter<Student> pred){
        List<Student>list =new ArrayList<>();
        for(Student student : students){
            if(pred.valid(student)){
                list.add(student);
            }
        }
        return  list;
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(46,"Nguyen Van A"));
       students.add(new Student(30,"Tran Van B"));
       students.add(new Student(32,"Trinh Van S"));
       students.add(new Student(30,"Hoang Thi K"));
//      Student.Filter<Student> older = student -> student.getAge()>=30;
//        List<Student> filtered = filter(students, older);
//        filtered.forEach(student -> {
//            System.out.println(student);
//        });
//        Collections.sort(students,(Student student1,Student student2)->
//                student1.getAge()-student2.getAge());
//        students.forEach(student -> {
//            System.out.println(student);
//        });

        Comparator<Student>comparator = (student1, student2)->student1.getAge()-student2.getAge();
        Stream<Student> stream = students.stream().sorted(comparator);
        stream.forEach(student -> System.out.println(student));
        System.out.println("\nMax is "+students.stream().max(comparator));
        int sum= students.stream().mapToInt(Student::getAge).sum();
        System.out.println("Average of age is :"+sum/students.size());
        students.parallelStream().forEach(it-> System.out.println("Hello"+it.getName()));
    }
}
