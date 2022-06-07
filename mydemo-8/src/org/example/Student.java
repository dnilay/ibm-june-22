package org.example;

public class Student implements Comparable {
    private String studentId;
    private String studentName;
    private double gpa;

    public Student() {
    }

    public Student(String studentId, String studentName, double gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student student=(Student)o;
        if(this.getGpa()> student.getGpa())
        {
            return -1;
        }
        else if (this.getGpa()< student.getGpa())
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }
}
