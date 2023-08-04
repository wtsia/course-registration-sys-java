import java.util.ArrayList;

public class CourseAL {
    private String courseName;
    private ArrayList<Student> roster;
    private ArrayList<Student> waitlist;
    private int maxRosterSize;
    private int maxWaitlistSize;

    public CourseAL(String courseName, int maxRosterSize, int maxWaitlistSize) {
        this.courseName = courseName;
        this.roster = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        this.maxRosterSize = maxRosterSize;
        this.maxWaitlistSize = maxWaitlistSize;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getMaxRosterSize() {
        return maxRosterSize;
    }
    public void setMaxRosterSize(int rosterSize) {
        this.maxRosterSize = rosterSize;
    }
    public int getRosterSize() {
        return roster.size();
    }
    public int getWaitlistSize() {
        return waitlist.size();
    }
    public int getMaxWaitlistSize() {
        return maxWaitlistSize;
    }

    public boolean addStudent(Student student) {
        if (student == null || !student.isTuitionPaid() || isEnrolled(student)) {
            return false;
        }

        if (roster.size() < maxRosterSize) {
            roster.add(student);
        } else if (waitlist.size() < maxWaitlistSize) {
            waitlist.add(student);
        } else {
            return false;
        }

        return true;
    }

    public boolean dropStudent(Student student) {
        if (student == null) {
            return false;
        }

        if (roster.remove(student)) {
            if (!waitlist.isEmpty()) {
                roster.add(waitlist.remove(0));
            }
            return true;
        } else if (waitlist.remove(student)) {
            return true;
        }

        return false;
    }

    private boolean isEnrolled(Student student) {
        return roster.contains(student) || waitlist.contains(student);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(courseName).append("\n");
        sb.append(roster.size()).append(" enrolled (maximum allowed ").append(maxRosterSize).append(")\n");
        for (Student student : roster) {
            sb.append(student).append("\n");
        }
        sb.append(waitlist.size()).append(" on waitlist (maximum allowed ").append(maxWaitlistSize).append(")\n");
        for (Student student : waitlist) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}
