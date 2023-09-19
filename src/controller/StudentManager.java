package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import model.Student;


public class StudentManager{
    ArrayList<Student> list = new ArrayList<>();

    public StudentManager() {
    }
    
    public void addStudent(Student cd){
        list.add(cd);
    }
    
    public void display(ArrayList<Student> rs) {
        for (Student candidate : rs) {
            System.out.println(candidate);
        }
    }
    public void display() {
        for (Student candidate : list) {
            System.out.println(candidate);
        }
    }
    public ArrayList<Student> search(Predicate<Student> c) {
        ArrayList<Student> rs = new ArrayList<Student>();
        for (Student customer : list) {
            if (c.test(customer)) {
                rs.add(customer);
            }
        }
        return rs;
    }
    
    public void remove(int id) {
        list.remove(search(c -> c.getId()==id ));
    }
    
    public void sort() {
        Collections.sort(list);
    }
 public void generateReport() {
        Map<String, Integer> courseCounts = new HashMap<>();

        for (Student student : list) {           
            courseCounts.put(student.getStudentName() + "|" + student.getCourseName(), courseCounts.getOrDefault(student.getStudentName() + "|" + student.getCourseName(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : courseCounts.entrySet()) {
            String[] parts = entry.getKey().split("\\|");
            String name = parts[0];
            String course = parts[1];
            int count = entry.getValue();

            System.out.println(name + " | " + course + " | " + count);
        }
    }

    }

