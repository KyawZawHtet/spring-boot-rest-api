package com.kyaw.springbootrestapi.controller;

import com.kyaw.springbootrestapi.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
//RequestMapping => same URL or Base URL
public class StudentController {

    //http://localhost:8080/student
    //ResponseEntity<> used return type
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Kyaw Zaw",
                "Htet"
        );
        /*
        * return new ResponseEntity<>(student, HttpStatus.OK); -> another way
          return ResponseEntity.ok(student);                   -> another way
          return ResponseEntity.status(HttpStatus.OK).body(student); -> another way
         */
        return ResponseEntity.ok().header("custom-header", "Kyaw Zaw").body(student);
    }
    /* Simple Way
    * @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Kyaw Zaw",
                "Htet"
        );
        return student;
    }*/

    //http://localhost:8080/students
    // ResponseEntity<> used return type
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John","Doe"));
        students.add(new Student(2, "Jane","Smith"));
        students.add(new Student(3, "Alice","Johnson"));
        students.add(new Student(4, "Bob","Brown"));
        students.add(new Student(5, "Sophia","White"));
        return ResponseEntity.ok(students);
    }
    /*
    * Simple Way
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John","Doe"));
        students.add(new Student(2, "Jane","Smith"));
        students.add(new Student(3, "Alice","Johnson"));
        students.add(new Student(4, "Bob","Brown"));
        students.add(new Student(5, "Sophia","White"));
        return students;
    }
     */

    //Spring Boot REST API with Path Variable
    //{id} => URL template variable
    //http://localhost:8080/students/1/John/Doe
    //ResponseEntity<> used return type
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        Student student = new Student(
                studentId, firstName, lastName
        );
        return  ResponseEntity.ok(student);
    }

    /*
    * Simple Way
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        return new Student(
                studentId, firstName, lastName
        );
    }
     */

    //Spring Boot REST API with Request Param
    //Query Parameter
    //http://localhost:8080/students/query/?id=1&firstName=John&lastName=Doe
    //ResponseEntity<> used return type
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {

        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /*
    * Simple Way
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
     */

    //Spring Boot REST API that handles HTTP POST Request -> creating new resource
    //@PostMapping and @RequestBody and @ResponseStatus
    //ResponseEntity<> used return type
    //@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("ID : " + student.getId());
        System.out.println("First Name : " + student.getFirstName());
        System.out.println("Last Name : " + student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    /*
    * Simple Way
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println("ID : " + student.getId());
        System.out.println("First Name : " + student.getFirstName());
        System.out.println("Last Name : " + student.getLastName());
        return student;
    }
     */

    //Spring Boot REST API that handles HTTP PUT Request - updating existing resource
    //ResponseEntity<> used return type
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
        System.out.println("First Name : " + student.getFirstName());
        System.out.println("Last Name : " + student.getLastName());
        return ResponseEntity.ok(student);
    }

    /*
    * Simple Way
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
        System.out.println("First Name : " + student.getFirstName());
        System.out.println("Last Name : " + student.getLastName());
        return student;
    }
     */

    //Spring Boot REST API that handles HTTP PUT Request - deleting existing resource
    //ResponseEntity<> used return type
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println("ID : " + studentId + " Deleted!");
        return ResponseEntity.ok("Student deleted successfully!");
    }

    /*
    * Simple Way
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println("ID : " + studentId + " Deleted!");
        return "Student deleted successfully!";
    }
     */

}











































