package org.example;



import org.example.dao.CourseDao;
import org.example.dao.CourseDaoImpl;
import org.example.model.Course;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class App {
    private static final Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        try {

            int choice=0;
            String courseId;
            String courseName;
            String authorName;
            Course course=null;
            CourseDao courseDao=new CourseDaoImpl();
            do {
                System.out.println("1. create a new course.");
                System.out.println("2. display all available course.");
                System.out.println("3. find course by course-id. ");
                System.out.println("0.exit. ");
                System.out.print("enter your choice: ");
                choice= scanner.nextInt();
                switch (choice)
                {
                    case 1:
                        String arr[]= UUID.randomUUID().toString().split("-");
                       // str=arr[0];
                        course=new Course();
                        System.out.print("Enter Course Name: ");
                        courseName= scanner.next();;
                        System.out.print("Enter Author Name: ");
                        authorName= scanner.next();
                        course.setCourse_id(arr[0]);
                        course.setAuthor(authorName);
                        course.setCourseName(courseName);
                        Course c=courseDao.createCourse(course);
                        System.out.println("course creation succeed. "+c);
                        break;
                    case 2:
                        List<Course> courses=courseDao.getAlCourse();
                        if(courses.isEmpty())
                        {
                            System.out.println("no courses are available..");
                        }
                        else {
                            System.out.println("COURSE_ID\tCOURSE_NAME\tAUTHOR_NAME");
                            for (Course c1:courses)
                            {
                                System.out.println(c1.getCourse_id()+"\t"+c1.getCourseName()+"\t"+c1.getAuthor());
                            }
                        }

                        break;
                    case 3:
                        System.out.print("enter course id: ");
                        courseId= scanner.next();
                        c=courseDao.findCourseByCourseId(courseId);
                        if(c==null)
                        {
                            System.out.println("no such course-id");
                        }
                        else {
                            System.out.println(c);
                        }

                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("invalid choice.");
                        break;
                }


            }while (choice!=0);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
