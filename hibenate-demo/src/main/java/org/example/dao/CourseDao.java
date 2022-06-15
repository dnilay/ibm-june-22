package org.example.dao;

import org.example.model.Course;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public interface CourseDao {

    public Course createCourse(Course course);
    public List<Course> getAlCourse();
    public Course findCourseByCourseId(String courseId);
}
