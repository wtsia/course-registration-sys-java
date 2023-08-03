# Course Enrollment System - Java

|AUTHORS|
|:-:|
| [Jaime Pastelero](https://github.com/jaimepasta), [Winston Tsia](https://github.com/wtsia) |

A program utilizing concepts in Classes and Objects. This program implements a Course Enrollment System in Java. The `Course` class allows you to keep track of students enrolled in a course (on the roster) and students on the waitlist for the course. It provides functionalities to add and drop students from the roster and waitlist based on specific conditions.

## Course Class
The `Course` class represents a course and includes the following features:

## Instance Data Variables
- `courseName`: A String variable to store the name of the course.
- `roster`: An array of Student objects representing the students enrolled in the course.
- `waitlist`: An array of Student objects representing the students on the waitlist.
- `maxRosterSize`: An integer indicating the maximum number of students allowed on the roster.
- `maxWaitlistSize`: An integer indicating the maximum number of students allowed on the waitlist.
- `rosterSize`: An integer to keep track of the current number of students on the roster.
- `waitlistSize`: An integer to keep track of the current number of students on the waitlist.

## Constructor
The Course object is initially created by specifying the course name, maximum roster size, and maximum waitlist size. The roster and waitlist are initially empty.

```
public Course(String courseName, int maxRosterSize, int maxWaitlistSize)
```

## Getters and Setters
`getCourseName()`: Returns the name of the course.
`getMaxRosterSize()`: Returns the maximum roster size.
`getMaxWaitlistSize()`: Returns the maximum waitlist size.
`getRosterSize()`: Returns the current number of students on the roster.
`getWaitlistSize()`: Returns the current number of students on the waitlist.
`setCourseName(String courseName)`: Sets the name of the course.

## Methods
- `addStudent(Student student)`: Adds a student to the course. The student is eligible to be added if they have paid their tuition, are not already enrolled on the roster or waitlist, and there is available space. Returns `true` if the student is added successfully, `false` otherwise.

- `dropStudent(Student student)`: Drops a student from the course. The student can be removed if they are on the roster or waitlist. If a spot becomes available after dropping a student from the roster, the first student on the waitlist will be added to the roster. Returns `true` if the student is removed successfully, `false` otherwise.

### `toString()` Method
The `toString()` method provides a text representation of the course's details, including the course name, the number of students enrolled in the course, the roster of enrolled students, the number of students on the waitlist, and the waitlisted students' information. No "nulls" will be printed with the arrays.

## Usage
1. Create a new `Course` object by providing the course name, maximum roster size, and maximum waitlist size.
2. Use the `addStudent(Student student)` method to enroll students in the course.
3. Use the `dropStudent(Student student)` method to remove students from the course if needed.
4. Use the getter methods to retrieve information about the course, roster, and waitlist.

Feel free to customize the Student class as needed to include additional student information, such as student ID, contact details, etc.

Happy course enrollment! :mortar_board:





